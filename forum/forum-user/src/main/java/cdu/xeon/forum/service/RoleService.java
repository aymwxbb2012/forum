package cdu.xeon.forum.service;

import java.util.List;

import javax.inject.Inject;

import cdu.xeon.forum.dao.IRoleDao;
import cdu.xeon.forum.dao.IUserDao;
import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.User;
import org.springframework.stereotype.Service;

@Service("roleService")
public class RoleService implements IRoleService {
	private IRoleDao roleDao;
	private IUserDao userDao;
	
	
	public IRoleDao getRoleDao() {
		return roleDao;
	}
	@Inject
	public void setRoleDao(IRoleDao roleDao) {
		this.roleDao = roleDao;
	}

	public IUserDao getUserDao() {
		return userDao;
	}
	@Inject
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(Role role) {
		roleDao.add(role);
	}

	@Override
	public void delete(int id) {
		List<User> us = userDao.listRoleUsers(id);
		if(us!=null&&us.size()>0) throw new ForumException("The deleted role object has the user and cannot be deleted");
		roleDao.delete(id);
	}

	@Override
	public void update(Role role) {
		roleDao.update(role);
	}

	@Override
	public Role load(int id) {
		return roleDao.load(id);
	}

	@Override
	public List<Role> listRole() {
		return roleDao.listRole();
	}

	@Override
	public void deleteRoleUsers(int rid) {
		roleDao.deleteRoleUsers(rid);
	}

}
