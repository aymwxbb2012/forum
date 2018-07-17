package cdu.xeon.forum.dao;


import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.ChannelType;

public interface IChannelDao extends IBaseDao<Channel> {
	
	public List<Channel> listByParent(Integer pid);
	
	public int getMaxOrderByParent(Integer pid);
	
	public List<ChannelTree> generateTree();
	
	public List<ChannelTree> generateTreeByParent(Integer pid);
	
	public void updateSort(Integer[] ids);
	
	public List<Channel> listPublishChannel();
	
	public List<Channel> listAllIndexChannel(ChannelType ct);
	
	public List<Channel> listQTopNavChannel();
	
	public List<Channel> listTTopNavChannel();
	
	public void deleteChannelGroups(int cid);
	
	public Channel loadFirstChannelByNav(int cid);
	
	public List<Channel> listUseChannelByParent(Integer cid);
	
	public List<Channel> listChannelByType(ChannelType ct);
}
