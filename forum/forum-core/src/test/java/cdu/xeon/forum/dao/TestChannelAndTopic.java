package cdu.xeon.forum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.dbunit.DatabaseUnitException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import cdu.xeon.forum.model.Channel;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestChannelAndTopic {
	@Inject
	private SessionFactory sessionFactory;
	@Inject
	private IChannelDao channelDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
	}
	
	@Test
	public void testTopNav() {
		List<Channel> cs = channelDao.listQTopNavChannel();
		for(Channel c:cs) {
			System.out.println(c.getId()+","+c.getName()+","+c.getCustomLink()+","+c.getCustomLinkUrl());
		}
	}
	
	
	@After
	public void tearDown() throws DatabaseUnitException, SQLException, IOException {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
	}
}
