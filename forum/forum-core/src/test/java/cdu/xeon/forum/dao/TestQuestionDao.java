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
import cdu.xeon.forum.model.Question;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestQuestionDao extends AbstractDbUnitTestCase{

	
		@Inject
		private SessionFactory sessionFactory;
		
		@Inject
		private IQuestionDao questionDao;
		
		@Before
		public void setUp() throws SQLException, IOException, DatabaseUnitException {
			Session s = sessionFactory.openSession();
			TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
			this.backupAllTable();
			IDataSet ds = createDateSet("Question");
			DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
		}
		
		@Test
		public void testFindByCts() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			Pager<Question> qs = questionDao.find(7, null, 1);
			Assert.assertEquals(qs.getTotal(), 3);
			List<Question> ls = Arrays.asList(new Question(1,"how to solve jlk?","aa|aaa",1,1,"Administrator",50),
					new Question(2,"how to solve xgf?","ef",1,1,"Administrator",50),
					new Question(3,"how to solve xcv?","ef|efg|aaa",1,1,"Administrator",50));
			TestUtil.assertListByClz(ls, qs.getDatas(), Question.class,
					new String[]{"content","user","publishDate",
				"createDate","cname","channel","coins"});
		}


		@Test
		public void testSearchQuestionByKeyword() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			Pager<Question> qs = questionDao.searchQuestionByKeyword("ef");
			Assert.assertEquals(qs.getTotal(), 2);
			List<Question> ls = Arrays.asList(new Question(2,"how to solve xgf?","ef",1,1,"Administrator",50),
					new Question(3,"how to solve xcv?","ef|efg|aaa",1,1,"Administrator",50));
			TestUtil.assertListByClz(ls, qs.getDatas(), Question.class,
					new String[]{"content","user","publishDate",
				"createDate","cname","channel","coins"});
		}

		@Test
		public void testSearchQuestion() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			Pager<Question> qs = questionDao.searchQuestion("b");
			Assert.assertEquals(qs.getTotal(), 1);
			List<Question> ls = Arrays.asList(new Question(4,"how to solve vb?","cd",1,1,"Publisher",50));
			TestUtil.assertListByClz(ls, qs.getDatas(), Question.class,
					new String[]{"content","user","publishDate",
				"createDate","cname","channel","coins"});
		}

		@Test
		public void testFindRecommendQuestion() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
			Pager<Question> qs = questionDao.findRecommendQuestion(7);
			Assert.assertEquals(qs.getTotal(), 3);
			List<Question> ls = Arrays.asList(new Question(1,"how to solve jlk?","aa|aaa",1,1,"Administrator",50),
					new Question(2,"how to solve xgf?","ef",1,1,"Administrator",50),
					new Question(3,"how to solve xcv?","ef|efg|aaa",1,1,"Administrator",50));
			TestUtil.assertListByClz(ls, qs.getDatas(), Question.class,
					new String[]{"content","user","publishDate",
				"createDate","cname","channel","coins"});
		}
		
		
		@After
		public void tearDown() throws DatabaseUnitException, SQLException, IOException {
			SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
			Session s = holder.getSession(); 
			s.flush();
			TransactionSynchronizationManager.unbindResource(sessionFactory);
		//	this.resumeTable();
		}

}
