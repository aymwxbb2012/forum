package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.GroupChannel;

public interface IGroupService {
	public void add(Group group);
	public void delete(int id);
	public Group load(int id);
	public void update(Group group);
	
	public List<Group> listGroup();
	public Pager<Group> findGroup();
	public void deleteGroupUsers(int gid);
	
	
	public void addGroupChannel(int gid,int cid);
	
	public GroupChannel loadGroupChannel(int gid,int cid);
	
	public void clearGroupChannel(int gid);
	
	public void deleteGroupChannel(int gid,int cid);
	
	public List<Integer> listGroupChannelIds(int gid);
	
	public List<ChannelTree> generateGroupChannelTree(int gid);
	
	public List<ChannelTree> generateUserChannelTree(int uid);
}
