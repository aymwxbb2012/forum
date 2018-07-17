package cdu.xeon.forum.controller;

import javax.servlet.http.HttpSession;

import cdu.xeon.forum.auth.AuthClass;
import cdu.xeon.forum.auth.AuthMethod;
import cdu.xeon.forum.web.ForumSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AuthClass("login")
public class AdminController {

	@RequestMapping("/admin")
	@AuthMethod
	public String index() {
		return "admin/index";
	}
	
	@AuthMethod
	@RequestMapping("/admin/logout")
	public String logout(HttpSession session) {
		ForumSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/login";
	}
	
	@AuthMethod
	@RequestMapping("/ulogout")
	public String uLogout(HttpSession session) {
		ForumSessionContext.removeSession(session);
		session.invalidate();
		return "redirect:/index";
	}
	
}
