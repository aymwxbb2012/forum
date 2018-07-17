package cdu.xeon.forum.web;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cdu.xeon.forum.model.ForumException;
import cdu.xeon.forum.model.User;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	@SuppressWarnings("unchecked")
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		
		String sid = request.getParameter("sid");
		if(sid!=null&&!"".equals(sid.trim())) {
			session = ForumSessionContext.getSession(sid);
		}
		HandlerMethod hm = (HandlerMethod)handler;
		User user = (User)session.getAttribute("loginUser");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/login");
		} else {
			boolean isAdmin = (Boolean)session.getAttribute("isAdmin");
			if(!isAdmin) {
				Set<String> actions = (Set<String>)session.getAttribute("allActions");
				String aname = hm.getBean().getClass().getName()+"."+hm.getMethod().getName();
				if(!actions.contains(aname)) throw new ForumException("There is no permission to access this feature");
			}
		}
		return super.preHandle(request, response, handler);
	}
}
