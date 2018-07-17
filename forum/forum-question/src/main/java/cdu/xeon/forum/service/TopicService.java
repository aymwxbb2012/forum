package cdu.xeon.forum.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.dao.IAttachmentDao;
import cdu.xeon.forum.dao.IChannelDao;
import cdu.xeon.forum.dao.ITopicDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.Attachment;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Topic;
import cdu.xeon.forum.model.User;
import org.springframework.stereotype.Service;

@Service("topicService")
public class TopicService implements ITopicService {
	private ITopicDao topicDao;
	private IAttachmentDao attachmentDao;
	private IChannelDao channelDao;
	private IUserDao userDao;
	
	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}
	public ITopicDao getTopicDao() {
		return topicDao;
	}
	@Inject
	public void setTopicDao(ITopicDao topicDao) {
		this.topicDao = topicDao;
	}

	public IAttachmentDao getAttachmentDao() {
		return attachmentDao;
	}
	@Inject
	public void setAttachmentDao(IAttachmentDao attachmentDao) {
		this.attachmentDao = attachmentDao;
	}
	
	private void addTopicAtts(Topic topic,Integer[] aids) {
		if(aids!=null) {
			for(Integer aid:aids) {
				Attachment a = attachmentDao.load(aid);
				if(a==null) continue;
				a.setTopic(topic);
			}
		}
	}

	@Override
	public void add(Topic topic, int cid, int uid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		User u = userDao.load(uid);
		if(c==null||u==null)throw new ForumException("Articles to be added must have users and columns");
		topic.setAuthor(u.getNickname());
		topic.setCname(c.getName());
		topic.setCreateDate(new Date());
		topic.setChannel(c);
		topic.setUser(u);
		topicDao.add(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void add(Topic topic, int cid, int uid) {
		add(topic,cid,uid,null);
	}

	@Override
	public void delete(int id) {
		List<Attachment> atts = attachmentDao.listByTopic(id);
		attachmentDao.deleteByTopic(id);
		topicDao.delete(id);
		for(Attachment a:atts) {
			AttachmentService.deleteAttachFiles(a);
		}
	}

	@Override
	public void update(Topic topic, int cid, Integer[] aids) {
		Channel c = channelDao.load(cid);
		if(c==null)throw new ForumException("Articles to be updated must have users and columns");
		topic.setCname(c.getName());
		topic.setChannel(c);
		topicDao.update(topic);
		addTopicAtts(topic, aids);
	}

	@Override
	public void update(Topic topic, int cid) {
		update(topic,cid,null);
	}

	@Override
	public Topic load(int id) {
		return topicDao.load(id);
	}

	@Override
	public Pager<Topic> find(Integer cid, String title, Integer status) {
		return topicDao.find(cid, title, status);
	}

	@Override
	public Pager<Topic> find(Integer uid, Integer cid, String title,
			Integer status) {
		return topicDao.find(uid, cid, title, status);
	}

	@Override
	public Pager<Topic> searchTopicByKeyword(String keyword) {
		return topicDao.searchTopicByKeyword(keyword);
	}

	@Override
	public Pager<Topic> searchTopic(String con) {
		return topicDao.searchTopic(con);
	}

	@Override
	public Pager<Topic> findRecommendTopic(Integer ci) {
		return topicDao.findRecommendTopic(ci);
	}
	@Override
	public void updateStatus(int tid) {
		Topic t = topicDao.load(tid);
		if(t.getStatus()==0) t.setStatus(1);
		else t.setStatus(0);
		topicDao.update(t);
	}
	@Override
	public List<Topic> listTopicByChannelAndNumber(int cid, int num) {
		return topicDao.listTopicByChannelAndNumber(cid, num);
	}
	@Override
	public List<Topic> listTopicByChannel(int cid) {
		return topicDao.listTopicsByChannel(cid);
	}
	@Override
	public boolean isUpdateIndex(int cid) {
		return topicDao.isUpdateIndex(cid);
	}
	
	@Override
	public Topic loadLastedTopicByColumn(int cid) {
		return topicDao.loadLastedTopicByColumn(cid);
	}

}
