package cdu.xeon.forum.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cdu.xeon.basic.model.SystemContext;
import cdu.xeon.basic.util.JsonUtil;
import cdu.xeon.forum.auth.AuthClass;
import cdu.xeon.forum.auth.AuthMethod;
import cdu.xeon.forum.dto.AjaxObj;
import cdu.xeon.forum.dto.QuestionDto;
import cdu.xeon.forum.model.Attachment;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.User;
import cdu.xeon.forum.service.IAnswerService;
import cdu.xeon.forum.service.IChannelService;
import cdu.xeon.forum.service.IGroupService;
import cdu.xeon.forum.service.IIndexService;
import cdu.xeon.forum.service.IKeywordService;
import cdu.xeon.forum.service.IQuestionService;

@Controller
@AuthClass("login")
@RequestMapping("/admin/question")
public class QuestionController {
private IChannelService channelService;
private IKeywordService keywordService;
private IQuestionService questionService;
private IGroupService groupService;
private IIndexService indexService;
private IAnswerService answerService;



public IAnswerService getAnswerService() {
	return answerService;
}

@Inject
public void setAnswerService(IAnswerService answerService) {
	this.answerService = answerService;
}

public IChannelService getChannelService() {
	return channelService;
}

@Inject
public void setChannelService(IChannelService channelService) {
	this.channelService = channelService;
}

public IKeywordService getKeywordService() {
	return keywordService;
}

@Inject
public void setKeywordService(IKeywordService keywordService) {
	this.keywordService = keywordService;
}

public IQuestionService getQuestionService() {
	return questionService;
}

@Inject
public void setQuestionService(IQuestionService questionService) {
	this.questionService = questionService;
}

public IGroupService getGroupService() {
	return groupService;
}

@Inject
public void setGroupService(IGroupService groupService) {
	this.groupService = groupService;
}

public IIndexService getIndexService() {
	return indexService;
}

@Inject
public void setIndexService(IIndexService indexService) {
	this.indexService = indexService;
}

private void initList(String con,Integer cid,Model model,HttpSession session,Integer status) {
	SystemContext.setSort("q.publishDate");
	SystemContext.setOrder("desc");
	boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
	if(isAdmin) {
		model.addAttribute("datas",questionService.find(cid, con, status));
	} else {
		User loginUser = (User)session.getAttribute("loginUser");
		model.addAttribute("datas", questionService.find(loginUser.getId(),cid, con, status));
	}
	if(con==null) con="";
	SystemContext.removeOrder();
	SystemContext.removeSort();
	model.addAttribute("con",con);
	model.addAttribute("cid",cid);
	model.addAttribute("cs",channelService.listPublishChannel());
}

@RequestMapping("/audits")
@AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
public String auditList(@RequestParam(required=false) String con,@RequestParam(required=false) Integer cid,Model model,HttpSession session) {
	System.out.println(con);
	
	initList(con, cid, model, session,1);
	return "question/list";
}

@RequestMapping("/unaudits")
@AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
public String unauditList(@RequestParam(required=false) String con,@RequestParam(required=false) Integer cid,Model model,HttpSession session) {
	initList(con, cid, model, session,0);
	return "question/list";
}

@RequestMapping("/changeStatus/{id}")
@AuthMethod(role="ROLE_AUDIT")
public String changeStatus(@PathVariable int id,Integer status) {
	questionService.updateStatus(id);
	Question t = questionService.load(id);
	if(questionService.isUpdateIndex(t.getChannel().getId())) {
		indexService.generateBody("question");
	}
	if(status==0) {
		return "redirect:/admin/question/unaudits";
	} else {
		return "redirect:/admin/question/audits";
	}
}

@RequestMapping("/delete/{id}")
@AuthMethod(role="ROLE_PUBLISH")
public String delete(@PathVariable int id,Integer status) {
	Question t = questionService.load(id);
	questionService.delete(id);
	if(questionService.isUpdateIndex(t.getChannel().getId())) {
		indexService.generateBody("question");
	}
	if(status==0) {
		return "redirect:/admin/question/unaudits";
	} else {
		return "redirect:/admin/question/audits";
	}
}


@RequestMapping(value="/add",method=RequestMethod.GET)
@AuthMethod(role="ROLE_PUBLISH")
public String add(Model model) {
	Question t = new Question();
	t.setPublishDate(new Date());
	QuestionDto td = new QuestionDto(t);
	model.addAttribute("questionDto",td);
	return "question/add";
}

@RequestMapping(value="/add",method=RequestMethod.POST)
public String add(@Validated QuestionDto questionDto,BindingResult br,String[]aks,Integer[] aids,HttpSession session) {
	if(br.hasErrors()) {
		return "question/add";
	}
	Question t = questionDto.getquestion();
	User loginUser = (User)session.getAttribute("loginUser");
	StringBuffer keys = new StringBuffer();
	if(aks!=null) {
		for(String k:aks) {
			keys.append(k).append("|");
			keywordService.addOrUpdate(k);
		}
	}
	t.setKeyword(keys.toString());
	questionService.add(t, questionDto.getCid(), loginUser.getId());
	if(questionDto.getStatus()==1&&questionService.isUpdateIndex(questionDto.getCid())) {
		indexService.generateBody("question");
	}
	return "redirect:/jsp/common/addSuc.jsp";
}



@RequestMapping("/{id}")
public String show(@PathVariable int id,Model model) {
	model.addAttribute(questionService.load(id));
	model.addAttribute("adatas",answerService.listAnswerByQuestion(id));
	return "question/show";
}

@RequestMapping(value="/searchKeyword")
@AuthMethod(role="ROLE_PUBLISH")
public @ResponseBody List<String> searchKeyword(String term) {
	return keywordService.listKeywordStringByCon(term);
}


@RequestMapping("/treeAll")
@AuthMethod(role="ROLE_PUBLISH")
public @ResponseBody List<ChannelTree> tree(HttpSession session) {
	boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
	User loginUser = (User)session.getAttribute("loginUser");
	if(isAdmin)
		return channelService.generateTree();
	else
		return groupService.generateUserChannelTree(loginUser.getId());
}
}
