package cdu.xeon.forum.dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")



@Rollback
@Transactional(transactionManager = "txManager")
public class TestUser {
	
	@Inject
	private IUserDao userDao;
	
	@Test
	public void testLoad() {
		
	}
}
