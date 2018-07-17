package cdu.xeon.forum.dao;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import cdu.xeon.basic.test.util.AbstractDbUnitTestCase;
import cdu.xeon.basic.test.util.EntitiesHelper;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.RoleType;
import cdu.xeon.forum.model.User;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestRoleDao extends AbstractDbUnitTestCase{
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private IRoleDao roleDao;
	@Inject
	private IUserDao userDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
		this.backupAllTable();
		IDataSet ds = createDateSet("t_user");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	@Test
	public void testListRole() {
		List<Role> actuals = Arrays.asList(
					new Role(1,"Administrator",RoleType.ROLE_ADMIN),
					new Role(2,"Publisher",RoleType.ROLE_PUBLISH),
					new Role(3,"Auditor",RoleType.ROLE_AUDIT),
					new Role(4,"Member",RoleType.ROLE_MEMBER));
		List<Role> roles = roleDao.listRole();
		EntitiesHelper.assertRoles(roles, actuals);
	}
	
	@Test
	public void testDeleteRoleUsers() {
		int rid = 2;
		roleDao.deleteRoleUsers(rid);
		List<User> users = userDao.listRoleUsers(rid);
		assertEquals(users.size(), 0);
	}
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
		this.resumeTable();
	}
}
