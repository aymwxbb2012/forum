package cdu.xeon.forum.dao;

import java.util.List;

import cdu.xeon.basic.dao.IBaseDao;
import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.RoleType;
import cdu.xeon.forum.model.User;
import cdu.xeon.forum.model.UserGroup;
import cdu.xeon.forum.model.UserRole;

public interface IUserDao extends IBaseDao<User>{
	
	
	public List<Role> listUserRoles(int userId);
	
	public List<Integer> listUserRoleIds(int userId);
	
	public List<Group> listUserGroups(int userId);
	
	public List<Integer> listUserGroupIds(int userId);
	
	public UserRole loadUserRole(int userId,int roleId);
	
	public UserGroup loadUserGroup(int userId,int groupId);
	
	public User loadByUsername(String username);
	
	public List<User> listRoleUsers(int roleId);
	
	public List<User> listRoleUsers(RoleType roleType);
	
	public List<User> listGroupUsers(int gid);
	
	public void addUserRole(User user,Role role);
	
	public void addUserGroup(User user,Group group);
	
	public void deleteUserRoles(int uid);
	
	public void deleteUserGroups(int gid);
	
	public Pager<User> findUser();
	
	public void deleteUserRole(int uid,int rid);
	
	public void deleteUserGroup(int uid,int gid);
}
