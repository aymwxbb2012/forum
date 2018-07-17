package cdu.xeon.forum.service;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.ArrayUtils;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.basic.util.SecurityUtil;
import cdu.xeon.forum.dao.IGroupDao;
import cdu.xeon.forum.dao.IRoleDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.User;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements IUserService {
	private IUserDao userDao;
	private IRoleDao roleDao;
	private IGroupDao groupDao;
	

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	public IRoleDao getRoleDao() {
		return roleDao;
	}
	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IGroupDao getGroupDao() {
		return groupDao;
	}
	@Inject
	public void setGroupDao(IGroupDao groupDao) {
		this.groupDao = groupDao;
	}
	
	private void addUserRole(User user,int rid) {
		Role role = roleDao.load(rid);
		if(role==null) throw new ForumException("The user role to be added does not exist");
		userDao.addUserRole(user, role);
	}
	
	private void addUserGroup(User user,int gid) {
		Group group = groupDao.load(gid);
		if(group==null) throw new ForumException("The group object to be added does not exist");
		userDao.addUserGroup(user, group);
	}

	@Override
	public void add(User user, Integer[] rids, Integer[] gids) {
		User tu = userDao.loadByUsername(user.getUsername());
		if(tu!=null)throw new ForumException("The added user object already exists and cannot be added");
		user.setCreateDate(new Date());
		try {
			user.setPassword(SecurityUtil.md5(user.getUsername(),user.getPassword()));
		} catch (NoSuchAlgorithmException e) {
			throw new ForumException("Password encryption failed:"+e.getMessage());
		}
		userDao.add(user);
		
		for(Integer rid:rids) {
			this.addUserRole(user, rid);
		}
		
		for(Integer gid:gids) {
			addUserGroup(user, gid);
		}
	}

	@Override
	public void delete(int id) {
		
		
		
		userDao.deleteUserGroups(id);
		
		userDao.deleteUserRoles(id);
		userDao.delete(id);
	}

	@Override
	public void update(User user, Integer[] rids, Integer[] gids) {
		
		List<Integer> erids = userDao.listUserRoleIds(user.getId());
		List<Integer> egids = userDao.listUserGroupIds(user.getId());
		
		for(Integer rid:rids) {
			if(!erids.contains(rid)) {
				addUserRole(user, rid);
			}
		}
		for(Integer gid:gids) {
			if(!egids.contains(gid)) {
				addUserGroup(user,gid);
			}
		}
		
		for(Integer erid:erids) {
			if(!ArrayUtils.contains(rids, erid)) {
				userDao.deleteUserRole(user.getId(), erid);
			}
		}
		
		for(Integer egid:egids) {
			if(!ArrayUtils.contains(gids, egid)) {
				userDao.deleteUserGroup(user.getId(), egid);
			}
		}
	}

	@Override
	public void updateStatus(int id) {
		User u = userDao.load(id);
		if(u==null) throw new ForumException("The user of the modified state does not exist");
		if(u.getStatus()==0) u.setStatus(1);
		else u.setStatus(0);
		userDao.update(u);
	}

	@Override
	public Pager<User> findUser() {
		return userDao.findUser();
	}

	@Override
	public User load(int id) {
		return userDao.load(id);
	}

	@Override
	public List<Role> listUserRoles(int id) {
		return userDao.listUserRoles(id);
	}

	@Override
	public List<Group> listUserGroups(int id) {
		return userDao.listUserGroups(id);
	}
	@Override
	public List<Integer> listUserRoleIds(int id) {
		return userDao.listUserRoleIds(id);
	}
	@Override
	public List<Integer> listUserGroupIds(int id) {
		return userDao.listUserGroupIds(id);
	}
	@Override
	public List<User> listGroupUsers(int gid) {
		return userDao.listGroupUsers(gid);
	}
	@Override
	public List<User> listRoleUsers(int rid) {
		return userDao.listRoleUsers(rid);
	}
	@Override
	public User login(String username, String password) {
		User user = userDao.loadByUsername(username);
		if(user==null) throw new ForumException("User name or password is incorrect");
		try {
			if(!SecurityUtil.md5(username,password).equals(user.getPassword())) {
				throw new ForumException("User name or password is incorrect");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new ForumException("Password encryption failed:"+e.getMessage());
		}
		if(user.getStatus()==0) throw new ForumException("The user has been disabled, please contact the administrator");
		return user;
	}
	@Override
	public void update(User user) {
		userDao.update(user);
	}
	@Override
	public void updatePwd(int uid, String oldPwd, String newPwd) {
		try {
			User u = userDao.load(uid);
			if(!SecurityUtil.md5(u.getUsername(),oldPwd).equals(u.getPassword())) {
				throw new ForumException("The original password is incorrect");
			}
			u.setPassword(SecurityUtil.md5(u.getUsername(), newPwd));
			userDao.update(u);
		} catch (NoSuchAlgorithmException e) {
			throw new ForumException("Update password failed:"+e.getMessage());
		}
	}

}
