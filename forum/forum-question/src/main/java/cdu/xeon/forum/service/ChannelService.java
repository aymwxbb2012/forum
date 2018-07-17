package cdu.xeon.forum.service;

import java.util.List;

import javax.inject.Inject;

import cdu.xeon.forum.dao.IChannelDao;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.ChannelType;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Topic;
import org.springframework.stereotype.Service;

@Service("channelService")
public class ChannelService implements IChannelService {
	private IChannelDao channelDao;
	private ITopicService topicService;
	
	

	public ITopicService getTopicService() {
		return topicService;
	}
	
	@Inject
	public void setTopicService(ITopicService topicService) {
		this.topicService = topicService;
	}
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}

	public void add(Channel channel, Integer pid) {
		Integer orders = channelDao.getMaxOrderByParent(pid);
		if(pid!=null&&pid>0) {
			Channel pc = channelDao.load(pid);
			if(pc==null) throw new ForumException("The parent object of the column is not correct!");
			channel.setParent(pc);
		}
		channel.setOrders(orders+1);
		channelDao.add(channel);
	}

	public void update(Channel channel) {
		channelDao.update(channel);
	}

	public void delete(int id) {
		List<Channel> cs = channelDao.listByParent(id);
		if(cs!=null&&cs.size()>0) throw new ForumException("There are sub-columns to delete, which cannot be deleted");
		List<Topic> ts = topicService.listTopicByChannel(id);
		if(ts.size()>0) {
			throw new ForumException("This column also has corresponding article information, cannot delete");
		}
		channelDao.deleteChannelGroups(id);
		channelDao.delete(id);
	}

	public void clearTopic(int id) {
		List<Topic> tops = topicService.listTopicByChannel(id);
		for(Topic t:tops) {
			topicService.delete(t.getId());
		}
	}

	public Channel load(int id) {
		return channelDao.load(id);
	}

	public List<Channel> listByParent(Integer pid) {
		return channelDao.listByParent(pid);
	}
	@Override
	public List<ChannelTree> generateTree() {
		return channelDao.generateTree();
	}
	@Override
	public List<ChannelTree> generateTreeByParent(Integer pid) {
		return channelDao.generateTreeByParent(pid);
	}
	@Override
	public void updateSort(Integer[] ids) {
		channelDao.updateSort(ids);
	}
	@Override
	public List<Channel> listPublishChannel() {
		return channelDao.listPublishChannel();
	}
	@Override
	public List<Channel> listQTopNavChannel() {
		return channelDao.listQTopNavChannel();
	}
	@Override
	public List<Channel> listTTopNavChannel() {
		return channelDao.listTTopNavChannel();
	}
	@Override
	public List<Channel> listAllIndexChannel(ChannelType ct) {
		return channelDao.listAllIndexChannel(ct);
	}

	@Override
	public Channel loadFirstChannelByNav(int cid) {
		return channelDao.loadFirstChannelByNav(cid);
	}

	@Override
	public List<Channel> listUseChannelByParent(Integer cid) {
		return channelDao.listUseChannelByParent(cid);
	}

	@Override
	public List<Channel> listChannelByType(ChannelType ct) {
		return channelDao.listChannelByType(ct);
	}
	

}
