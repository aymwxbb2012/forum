package cdu.xeon.forum.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.basic.model.SystemContext;
import cdu.xeon.forum.model.Answer;
import cdu.xeon.forum.model.Attachment;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelType;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.Topic;
import cdu.xeon.forum.service.IAnswerService;
import cdu.xeon.forum.service.IAttachmentService;
import cdu.xeon.forum.service.IChannelService;
import cdu.xeon.forum.service.IKeywordService;
import cdu.xeon.forum.service.IQuestionService;
import cdu.xeon.forum.service.ITopicService;
import cdu.xeon.forum.web.BaseInfoUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	private IChannelService channelService;
	private IQuestionService questionService;
	private ITopicService topicService;
	private IAttachmentService attachmentService;
	private IKeywordService keywordService;
	private IAnswerService answerService;
	

	public IAnswerService getAnswerService() {
		return answerService;
	}
	@Inject
	public void setAnswerService(IAnswerService answerService) {
		this.answerService = answerService;
	}
	public IQuestionService getQuestionService() {
		return questionService;
	}
	@Inject
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}
	public IKeywordService getKeywordService() {
		return keywordService;
	}
	@Inject
	public void setKeywordService(IKeywordService keywordService) {
		this.keywordService = keywordService;
	}

	public IAttachmentService getAttachmentService() {
		return attachmentService;
	}
	
	@Inject
	public void setAttachmentService(IAttachmentService attachmentService) {
		this.attachmentService = attachmentService;
	}
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}

	@RequestMapping({"/","/index"})
	public String qindex(Model model) {
		model.addAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
		return "index/qindex";
	}
	
	@RequestMapping({"/tindex"})
	public String tindex(Model model) {
		model.addAttribute("baseInfo", BaseInfoUtil.getInstacne().read());
		return "index/tindex";
	}
	
	
	@RequestMapping("/qchannel/{cid}")
	public String showQChannel(@PathVariable int cid,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		Channel c = channelService.load(cid);
		//System.out.println(c.getType());
		Channel pc = null;
		if(c.getType()==ChannelType.NAV_CHANNEL) {
			pc = c;
			c = channelService.loadFirstChannelByNav(c.getId());
		} else {
			pc = c.getParent();
		}
//		System.out.println(c.getType()==ChannelType.TOPIC_LIST);
//		System.out.println(c.getType());
		if(c.getType()==ChannelType.QUESTION_CONTENT) {
			resp.sendRedirect(req.getContextPath()+"/question/"+questionService.loadLastedQuestionByColumn(cid).getId());
		} else if(c.getType()==ChannelType.QUESTION_LIST) {
			SystemContext.setSort("q.publishDate");
			SystemContext.setOrder("desc");
			//System.out.println(c.getType());
			model.addAttribute("datas", questionService.find(c.getId(),null,1));
			//System.out.println(c.getType());
		} 
		SystemContext.removeSort();
		SystemContext.removeOrder();
		model.addAttribute("pc", pc);
		model.addAttribute("cs", channelService.listUseChannelByParent(pc.getId()));
		model.addAttribute("channel", c);
		if(c.getType()==ChannelType.QUESTION_LIST) {
			return "index/qchannel";
		} else {
			return "index/channel_pic";
		}
	}
	
	@RequestMapping("/tchannel/{cid}")
	public String showChannel(@PathVariable int cid,Model model,HttpServletResponse resp,HttpServletRequest req) throws IOException {
		Channel c = channelService.load(cid);
		//System.out.println(c.getType());
		Channel pc = null;
		if(c.getType()==ChannelType.NAV_CHANNEL) {
			pc = c;
			c = channelService.loadFirstChannelByNav(c.getId());
		} else {
			pc = c.getParent();
		}
//		System.out.println(c.getType()==ChannelType.TOPIC_LIST);
//		System.out.println(c.getType());
		if(c.getType()==ChannelType.TOPIC_CONTENT) {
			resp.sendRedirect(req.getContextPath()+"/topic/"+topicService.loadLastedTopicByColumn(cid).getId());
		} else if(c.getType()==ChannelType.TOPIC_IMG){
			SystemContext.setPageSize(16);
			SystemContext.setSort("a.topic.publishDate");
			SystemContext.setOrder("desc");
			Pager<Attachment> atts = attachmentService.findChannelPic(cid);
			model.addAttribute("datas", atts);
		} else if(c.getType()==ChannelType.TOPIC_LIST) {
			SystemContext.setSort("t.publishDate");
			SystemContext.setOrder("desc");
			//System.out.println(c.getType());
			model.addAttribute("datas", topicService.find(c.getId(),null,1));
			//System.out.println(c.getType());
		} 
		SystemContext.removeSort();
		SystemContext.removeOrder();
		model.addAttribute("pc", pc);
		model.addAttribute("cs", channelService.listUseChannelByParent(pc.getId()));
		model.addAttribute("channel", c);
		if(c.getType()==ChannelType.TOPIC_LIST) {
			return "index/tchannel";
		} else {
			return "index/channel_pic";
		}
	}
	
	@RequestMapping("/question/{qid}")
	public String showQuestion(@PathVariable int qid,Model model) {
		Question q = questionService.load(qid);
		String keywords = q.getKeyword();
		model.addAttribute("question", q);
		if(keywords==null||"".equals(keywords.trim())||"\\|".equals(keywords.trim())) {
			model.addAttribute("hasKey", false);
		} else {
			String[] kws = keywords.split("\\|");
			model.addAttribute("hasKey", true);
			model.addAttribute("kws",kws);
		}
		List<Answer> asws = answerService.listAnswerByQuestion(qid);
		if(asws.size()>0) {
			model.addAttribute("hasAsws", true);
			model.addAttribute("asws", asws);
		} else {
			model.addAttribute("hasAsws",false);
		}
		
		return "index/question";
	}
	
	
	@RequestMapping("/topic/{tid}")
	public String showTopic(@PathVariable int tid,Model model) {
		Topic t = topicService.load(tid);
		String keywords = t.getKeyword();
		model.addAttribute("topic", t);
		if(keywords==null||"".equals(keywords.trim())||"\\|".equals(keywords.trim())) {
			model.addAttribute("hasKey", false);
		} else {
			String[] kws = keywords.split("\\|");
			model.addAttribute("hasKey", true);
			model.addAttribute("kws",kws);
		}
		List<Attachment> atts = attachmentService.listAttachByTopic(tid);
		if(atts.size()>0) {
			model.addAttribute("hasAtts", true);
			model.addAttribute("atts", atts);
		} else {
			model.addAttribute("hasAtts",false);
		}
		return "index/topic";
	}
	
	
	
	@RequestMapping("/search/{con}")
	public String search(@PathVariable String con,Model model) {
		SystemContext.setOrder("asc");
		SystemContext.setSort("c.orders");
		model.addAttribute("cs", channelService.listChannelByType(ChannelType.NAV_CHANNEL));
		SystemContext.setOrder("desc");
		SystemContext.setSort("q.publishDate");
		Pager<Question> questions = questionService.searchQuestionByKeyword(con);
		qemp(questions,con);
		model.addAttribute("qdatas", questions);
		SystemContext.setSort("t.publishDate");
		Pager<Topic> topics = topicService.searchTopic(con);
		temp(topics,con);
		model.addAttribute("tdatas", topics);
		model.addAttribute("con", con);
		return "index/search";
	}
	
	@RequestMapping("/keyword/{con}")
	public String keyword(@PathVariable String con,Model model) {
		model.addAttribute("kws", keywordService.getMaxTimesKeyword(9));
		SystemContext.setOrder("desc");
		SystemContext.setSort("q.publishDate");
		Pager<Question> questions = questionService.searchQuestionByKeyword(con);
		qemp(questions,con);
		model.addAttribute("qdatas", questions);
		SystemContext.setSort("t.publishDate");
		Pager<Topic> topics = topicService.searchTopicByKeyword(con);
		temp(topics,con);
		model.addAttribute("tdatas", topics);
		
		model.addAttribute("con", con);
		return "index/keyword";
	}

	private void temp(Pager<Topic> topics, String con) {
		for(Topic t:topics.getDatas()) {
			if(t.getTitle().contains(con)) {
				String tt = t.getTitle().replaceAll(con, "<span class='emp'>"+con+"</span>");
				t.setTitle(tt);
			}
		}
	}
	
	private void qemp(Pager<Question> questions, String con) {
		for(Question q:questions.getDatas()) {
			if(q.getTitle().contains(con)) {
				String qt = q.getTitle().replaceAll(con, "<span class='emp'>"+con+"</span>");
				q.setTitle(qt);
			}
		}
	}
}
