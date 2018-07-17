package cdu.xeon.forum.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import cdu.xeon.basic.model.SystemContext;
import cdu.xeon.forum.service.IIndexService;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class TestIndexService {
	@Inject
	private IIndexService indexService;
	private String rp = "F:\\projects\\forum\\forum-web\\src\\main\\webapp";
	@Test
	public void testGenerateTop() {
		SystemContext.setRealPath(rp);
		indexService.generateTop("topic");
		indexService.generateTop("question");
		
	}
	
	@Test
	public void testGenerateBody() {
		SystemContext.setRealPath(rp);
		indexService.generateBody("topic");
		indexService.generateBody("question");
		
	}
}
