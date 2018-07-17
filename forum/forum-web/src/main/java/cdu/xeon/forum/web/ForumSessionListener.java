package cdu.xeon.forum.web;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ForumSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent event) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		ForumSessionContext.removeSession(event.getSession());
		System.out.println("remove Session:"+event.getSession().getId());
	}

}
