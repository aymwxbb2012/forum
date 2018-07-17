package cdu.xeon.forum.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.inject.Inject;

import org.directwebremoting.ui.servlet.BaseUtilHandler;
import cdu.xeon.basic.model.SystemContext;
import cdu.xeon.basic.util.FreemarkerUtil;
import cdu.xeon.basic.util.PropertiesUtil;
import cdu.xeon.forum.model.BaseInfo;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelType;
import cdu.xeon.forum.model.IndexQuestion;
import cdu.xeon.forum.model.IndexTopic;
import cdu.xeon.forum.model.Question;
import cdu.xeon.forum.model.Topic;
import cdu.xeon.forum.web.BaseInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("indexService")
public class IndexService implements IIndexService {
	
	private String outPath;
	private FreemarkerUtil util;
	
	@Autowired(required=true)
	public IndexService(String ftlPath, String outPath) {
		super();
		if(util==null) {
			this.outPath = outPath;
			util = FreemarkerUtil.getInstance(ftlPath);
		}
	}

	private IChannelService channelService;
	private ITopicService topicService;
	private IIndexPicService indexPicService;
	private IKeywordService keyworkService;
	private IQuestionService questionService;
	
	
	public IQuestionService getQuestionService() {
		return questionService;
	}
    @Inject
	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	public IKeywordService getKeyworkService() {
		return keyworkService;
	}
	
	@Inject
	public void setKeyworkService(IKeywordService keyworkService) {
		this.keyworkService = keyworkService;
	}
	public IIndexPicService getIndexPicService() {
		return indexPicService;
	}
	@Inject
	public void setIndexPicService(IIndexPicService indexPicService) {
		this.indexPicService = indexPicService;
	}

	public ITopicService getTopicService() {
		return topicService;
	}
	
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}
	public IChannelService getChannelService() {
		return channelService;
	}
	@Inject
	public void setChannelService(IChannelService channelService) {
		this.channelService = channelService;
	}

	@Override
	public void generateTop(String type) {
		if(type=="question") {
			List<Channel> cs = channelService.listTTopNavChannel();
			Map<String,Object> root = new HashMap<String,Object>();
			root.put("navs", cs);
			root.put("baseInfo", BaseInfoUtil.getInstacne().read());
			String outfile = SystemContext.getRealPath()+outPath+"/qtop.jsp";
			util.fprint(root, "/qtop.ftl", outfile);
		}else if(type=="topic") {
		List<Channel> cs = channelService.listTTopNavChannel();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("navs", cs);
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		String outfile = SystemContext.getRealPath()+outPath+"/ttop.jsp";
		util.fprint(root, "/ttop.ftl", outfile);
	}
	}
	@Override
	public void generateBottom() {
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("baseInfo", BaseInfoUtil.getInstacne().read());
		String outfile = SystemContext.getRealPath()+outPath+"/bottom.jsp";
		util.fprint(root, "/bottom.ftl", outfile);
	}

	@Override
	public void generateBody(String type) {
		if(type=="topic") {
		List<Channel> cs = channelService.listAllIndexChannel(ChannelType.TOPIC_LIST);
		Properties prop = PropertiesUtil.getInstance().load("tIndexChannel");
		Map<String,IndexTopic> topics = new HashMap<String, IndexTopic>();
		for(Channel c:cs) {
			int cid = c.getId();
			System.out.println(cid);
			String[] xs = prop.getProperty(cid+"").split("_");
			String order = xs[0];
			int num = Integer.parseInt(xs[1]);
			System.out.println("xxxxxxxxxxxxxxxxx"+order+"xxxxxxxxxxxxx"+num+"xxxxxxxxxxxxxxxxxxx");
			IndexTopic it = new IndexTopic();
			it.setCid(cid);
			it.setCname(c.getName());
			List<Topic> tops = topicService.listTopicByChannelAndNumber(cid, num);
			it.setTopics(tops);
			topics.put(order, it);
		}
		String outfile = SystemContext.getRealPath()+outPath+"/tbody.jsp";
		BaseInfo bi = BaseInfoUtil.getInstacne().read();
		int picnum = bi.getIndexPicNumber();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("ts", topics);
		root.put("pics", indexPicService.listIndexPicByNum(picnum));
		root.put("keywords", keyworkService.getMaxTimesKeyword(12));
		root.put("xxgk", topicService.loadLastedTopicByColumn(7));
		util.fprint(root, "/tbody.ftl", outfile);
	}
	
    else if(type=="question") {
    	List<Channel> cs = channelService.listAllIndexChannel(ChannelType.QUESTION_LIST);
		Properties prop = PropertiesUtil.getInstance().load("qIndexChannel");
		Map<String,IndexQuestion> questions = new HashMap<String, IndexQuestion>();
		for(Channel c:cs) {
			int cid = c.getId();
			System.out.println(cid);
			String[] xs = prop.getProperty(cid+"").split("_");
			String order = xs[0];
			int num = Integer.parseInt(xs[1]);
			System.out.println("xxxxxxxxxxxxxxxxx"+order+"xxxxxxxxxxxxx"+num+"xxxxxxxxxxxxxxxxxxx");
			IndexQuestion iq = new IndexQuestion();
			iq.setCid(cid);
			iq.setCname(c.getName());
			List<Question> ques = questionService.listQuestionByChannelAndNumber(cid, num);
//			System.out.println(cid+"--"+tops);
			iq.setQuestions(ques);
			questions.put(order, iq);
		}
		String outfile = SystemContext.getRealPath()+outPath+"/qbody.jsp";
		BaseInfo bi = BaseInfoUtil.getInstacne().read();
		int picnum = bi.getIndexPicNumber();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("qs", questions);
		root.put("pics", indexPicService.listIndexPicByNum(picnum));
		root.put("keywords", keyworkService.getMaxTimesKeyword(12));
		root.put("xxgk", topicService.loadLastedTopicByColumn(7));
		util.fprint(root, "/qbody.ftl", outfile);
	}
	}
}
