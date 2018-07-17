package cdu.xeon.forum.service;

import java.util.List;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.forum.model.Group;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.User;

public interface IUserService {
	
	public void add(User user,Integer[]rids,Integer[]gids);
	
	public void delete(int id);
	
	public void update(User user,Integer[] rids,Integer[] gids);
	
	public void update(User user);
	
	public void updatePwd(int uid,String oldPwd,String newPwd);
	
	public void updateStatus(int id);
	
	public Pager<User> findUser();
	
	public User load(int id);
	
	public List<Role> listUserRoles(int id);
	
	public List<Group> listUserGroups(int id);
	
	public List<Integer> listUserRoleIds(int id);
	
	public List<Integer> listUserGroupIds(int id);
	
	public List<User> listGroupUsers(int gid);
	public List<User> listRoleUsers(int rid);
	
	public User login(String username,String password);
}
