package cdu.xeon.forum.dao;


import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import cdu.xeon.basic.test.util.AbstractDbUnitTestCase;
import cdu.xeon.forum.model.ForumLink;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestForumLinkDao extends AbstractDbUnitTestCase{
	@Inject
	private SessionFactory sessionFactory;
	
	@Inject
	private IForumLinkDao forumLinkDao;
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	}
	
	@Test
	public void testAdd() {
		ForumLink cl = new ForumLink();
		cl.setNewWin(1);
		cl.setTitle("abc");
		cl.setType("aaa");
		cl.setUrl("aaaaa");
		forumLinkDao.add(cl);
	}
	




	
	@Test
	public void testFind() {
		System.out.println(forumLinkDao.findByType("normal website").getDatas());
	}
	
	@Test
	public void testList() {
		System.out.println(forumLinkDao.listByType("normal"));
	}
	
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	}
}
