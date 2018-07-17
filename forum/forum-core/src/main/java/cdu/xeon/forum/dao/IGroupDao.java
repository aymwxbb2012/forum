package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.GroupChannel;

public interface IGroupDao extends IBaseDao<Group> {
	public List<Group> listGroup();
	public Pager<Group> findGroup();
	public void deleteGroupUsers(int gid);
	
	public void addGroupChannel(Group group,Channel channel);
	
	public GroupChannel loadGroupChannel(int gid,int cid);
	
	public void clearGroupChannel(int gid);
	
	public void deleteGroupChannel(int gid,int cid);
	
	public List<Integer> listGroupChannelIds(int gid);
	
	public List<ChannelTree> generateGroupChannelTree(int gid);
	
	public List<ChannelTree> generateUserChannelTree(int uid);

}
