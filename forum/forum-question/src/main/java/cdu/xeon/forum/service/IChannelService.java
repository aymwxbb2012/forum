package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.ChannelType;

public interface IChannelService {
	
	
	public void add(Channel channel,Integer pid);
	
	public void update(Channel channel);
	
	public void delete(int id);
	
	
	public void clearTopic(int id);
	
	public Channel load(int id);
	
	public List<Channel> listByParent(Integer pid);
	
	
	public List<ChannelTree> generateTree();
	
	public List<ChannelTree> generateTreeByParent(Integer pid);
	
	public List<Channel> listPublishChannel();
	
	public List<Channel> listQTopNavChannel();
	
	public List<Channel> listTTopNavChannel();
	
	public void updateSort(Integer[] ids);
	
	public List<Channel> listAllIndexChannel(ChannelType ct);
	
	public Channel loadFirstChannelByNav(int cid);
	
	public List<Channel> listUseChannelByParent(Integer cid);
	
	
	public List<Channel> listChannelByType(ChannelType ct);
}
