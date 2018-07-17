package cdu.xeon.forum.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import cdu.xeon.basic.model.Pager;
import cdu.xeon.basic.test.util.AbstractDbUnitTestCase;
import cdu.xeon.basic.test.util.TestUtil;
import cdu.xeon.forum.model.Answer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestAnswerDao extends AbstractDbUnitTestCase{
	@Inject
	private SessionFactory sessionFactory;
	
	@Inject
	private IAnswerDao answerDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
//		this.backupAllTable();
//		IDataSet ds = createDateSet("question");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	@Test
	public void testFindByQ() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Pager<Answer> as = answerDao.find(1);
		Assert.assertEquals(as.getTotal(), 3);
		List<Answer> ls = Arrays.asList(new Answer(1,1,"Publisher"),
				new Answer(2,0,"Publisher"),
				new Answer(3,0,"Publisher"));
		TestUtil.assertListByClz(ls, as.getDatas(), Answer.class,
				new String[]{"content","user","createDate","qname","question"});
	}


	@Test
	public void testFindByQuestion() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Pager<Answer> as = answerDao.find(1);
		System.out.println(as);
	}
	
	
	@Test
	public void testSearchAnswer() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Pager<Answer> as = answerDao.searchAnswer("d");
		Assert.assertEquals(as.getTotal(), 1);
		List<Answer> ls = Arrays.asList(new Answer(2,0,"Publisher"));
		TestUtil.assertListByClz(ls, as.getDatas(), Answer.class,
				new String[]{"content","user","createDate","qname","question"});
	}

	@Test
	public void testFindChosenAnswer() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Pager<Answer> as = answerDao.findChosenAnswer(1);
		Assert.assertEquals(as.getTotal(), 1);
		List<Answer> ls = Arrays.asList(new Answer(1,1,"Publisher"));
		TestUtil.assertListByClz(ls, as.getDatas(), Answer.class,
				new String[]{"content","user","createDate","qname","question"});
	}
	
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
//		this.resumeTable();
	}
//

}
