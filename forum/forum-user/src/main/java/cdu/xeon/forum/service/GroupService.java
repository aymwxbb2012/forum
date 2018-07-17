package cdu.xeon.forum.service;

import java.util.List;

import javax.inject.Inject;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.dao.IChannelDao;
import cdu.xeon.forum.dao.IGroupDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.Channel;
import cdu.xeon.forum.model.ChannelTree;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.GroupChannel;
import cdu.xeon.forum.model.User;
import org.springframework.stereotype.Service;

@Service("groupService")
public class GroupService implements IGroupService{
	private IGroupDao groupDao;
	private IUserDao userDao;
	private IChannelDao channelDao;

	
	public IChannelDao getChannelDao() {
		return channelDao;
	}
	@Inject
	public void setChannelDao(IChannelDao channelDao) {
		this.channelDao = channelDao;
	}
	public IGroupDao getGroupDao() {
		return groupDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Group group) {
		groupDao.add(group);
	}

	@Override
	public void delete(int id) {
		List<User> users = userDao.listGroupUsers(id);
		if(users!=null&&users.size()>0) throw new ForumException("There are also users in the deleted group, which cannot be deleted");
		groupDao.delete(id);
	}

	@Override
	public Group load(int id) {
		return groupDao.load(id);
	}

	@Override
	public void update(Group group) {
		groupDao.update(group);
	}

	@Override
	public List<Group> listGroup() {
		return groupDao.listGroup();
	}

	@Override
	public Pager<Group> findGroup() {
		return groupDao.findGroup();
	}

	@Override
	public void deleteGroupUsers(int gid) {
		groupDao.deleteGroupUsers(gid);
	}
	@Override
	public void addGroupChannel(int gid, int cid) {
		Group g = groupDao.load(gid);
		Channel c = channelDao.load(cid);
		if(c==null||g==null)throw new ForumException("The group channel association object to be added does not exist");
		groupDao.addGroupChannel(g, c);
	}
	@Override
	public GroupChannel loadGroupChannel(int gid, int cid) {
		return groupDao.loadGroupChannel(gid, cid);
	}
	@Override
	public void clearGroupChannel(int gid) {
		groupDao.clearGroupChannel(gid);
	}
	@Override
	public void deleteGroupChannel(int gid, int cid) {
		groupDao.deleteGroupChannel(gid, cid);
	}
	@Override
	public List<Integer> listGroupChannelIds(int gid) {
		return groupDao.listGroupChannelIds(gid);
	}
	@Override
	public List<ChannelTree> generateGroupChannelTree(int gid) {
		return groupDao.generateGroupChannelTree(gid);
	}
	@Override
	public List<ChannelTree> generateUserChannelTree(int uid) {
		return groupDao.generateUserChannelTree(uid);
	}

}
