package cdu.xeon.forum.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cdu.xeon.basic.model.SystemContext;
import cdu.xeon.forum.auth.AuthClass;
import cdu.xeon.forum.auth.AuthMethod;
import cdu.xeon.forum.dto.AnswerDto;
import cdu.xeon.forum.model.Answer;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.User;
import cdu.xeon.forum.service.IAnswerService;
import cdu.xeon.forum.service.IGroupService;
import cdu.xeon.forum.service.IQuestionService;
import cdu.xeon.forum.service.IUserService;

@Controller
@AuthClass("login")
@RequestMapping("/admin/answer")
public class AnswerController {
	
	private IQuestionService questionService;
	private IAnswerService answerService;
	private IGroupService groupService;
	private IUserService userService;
	




	public IUserService getUserService() {
		return userService;
	}
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
    @Inject
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public IAnswerService getAnswerService() {
		return answerService;
	}
	@Inject
	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}

	public IGroupService getGroupService() {
		return groupService;
	}
	@Inject
	public void setGroupService(IGroupService groupService) {
		this.groupService = groupService;
	}

	private void initList(Integer qid,Model model,HttpSession session,Integer chosen) {
		SystemContext.setSort("a.createDate");
		SystemContext.setOrder("desc");
		boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
		if(isAdmin) {
			model.addAttribute("datas",answerService.find(qid,chosen));
		} else {
			User loginUser = (User)session.getAttribute("loginUser");
			model.addAttribute("datas", answerService.find(loginUser.getId(),qid,chosen));
		}
		SystemContext.removeOrder();
		SystemContext.removeSort();
	}

	@RequestMapping("/chosens")
	@AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
	public String chosenList(@RequestParam(required=false) Integer qid,Model model,HttpSession session) {
		initList(qid,model, session,1);
		return "answer/list";
	}

	@RequestMapping("/unchosens")
	@AuthMethod(role="ROLE_PUBLISH,ROLE_AUDIT")
	public String unchosenList(@RequestParam(required=false) Integer qid,Model model,HttpSession session) {
		initList(qid,model, session,0);
		return "answer/list";
	}

	@RequestMapping("/delete/{id}")
	@AuthMethod(role="ROLE_PUBLISH")
	public String delete(@PathVariable int id,Integer chosen) {
		answerService.delete(id);
		if(chosen==0) {
			return "redirect:/admin/answer/unchosens";
		} else {
			return "redirect:/admin/answer/chosens";
		}
			
			
		
	}


	@RequestMapping(value="/add",method=RequestMethod.GET)
	@AuthMethod(role="ROLE_PUBLISH,ROLE_MEMBER")
	public String add(@RequestParam(value="qid") Integer qid,Model model) {
		Answer a = new Answer();
		AnswerDto ad = new AnswerDto(a);
		model.addAttribute("answerDto",ad);
		if(qid!=0){
		model.addAttribute(qid);	
		}
		return "answer/add";
	}

	@RequestMapping(value="/add/{qid}",method=RequestMethod.GET)
	@AuthMethod(role="ROLE_PUBLISH")
	public String add(@PathVariable int qid,Model model) {
		Question q = questionService.load(qid);
		Answer a = new Answer();
		AnswerDto ad = new AnswerDto(a,q.getId());
		model.addAttribute("answerDto",ad);
		model.addAttribute("qname",q.getTitle());
		return "answer/add";
	}
	
	@RequestMapping(value="/add/{qid}",method=RequestMethod.POST)
	public String add(@Validated AnswerDto answerDto,BindingResult br,Integer[] aids,HttpSession session) {
		if(br.hasErrors()) {
			return "answer/add";
		}
		Answer a = answerDto.getAnswer();
		User loginUser = (User)session.getAttribute("loginUser");
		
		answerService.add(a, answerDto.getQid(), loginUser.getId());
		return "redirect:/jsp/common/addSuc.jsp";
	}



	@RequestMapping("/{id}")
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(answerService.load(id));
		return "answer/show";
	}

	@RequestMapping("chosen/{id}")
	public String choose(@PathVariable int id,Model model) {
		Answer a=answerService.load(id);
		a.setChosen(1);
		Question q=a.getQuestion();
		User u=a.getUser();
		u.setCoins(q.getCoins());
		q.setCoins(0);
		questionService.update(q, q.getChannel().getId());
		userService.update(u);
		answerService.update(a, q.getId());
		return "question/show";
	}


	
}
