package cdu.xeon.forum.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import cdu.xeon.basic.util.Captcha;
import cdu.xeon.forum.dto.UserDto;
import cdu.xeon.forum.model.Role;
import cdu.xeon.forum.model.RoleType;
import cdu.xeon.forum.model.User;
import cdu.xeon.forum.service.IUserService;
import cdu.xeon.forum.web.ForumSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	private IUserService userService;

	public IUserService getUserService() {
		return userService;
	}
	
	@Inject
	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(String username,String password,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","captcha is wrong,try again");
			return "admin/login";
		}
		User loginUser = userService.login(username, password);
		System.out.println(loginUser.getPassword());
		session.setAttribute("loginUser", loginUser);
		List<Role> rs = userService.listUserRoles(loginUser.getId());
		boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
		session.setAttribute("isAdmin", isAdmin);
		if(!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isAudit", isRole(rs,RoleType.ROLE_AUDIT));
			session.setAttribute("isPublish", isRole(rs,RoleType.ROLE_PUBLISH));
		}
		session.removeAttribute("cc");
		ForumSessionContext.addSessoin(session);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/ulogin",method=RequestMethod.GET)
	public String uLogin() {
		return "member/login";
	}
	
	@RequestMapping(value="/ulogin",method=RequestMethod.POST)
	public String uLogin(String username,String password,String checkcode,Model model,HttpSession session) {
		String cc = (String)session.getAttribute("cc");
		if(!cc.equals(checkcode)) {
			model.addAttribute("error","captcha is wrong,try again");
			return "member/login";
		}
		User loginUser = userService.login(username, password);
		System.out.println(loginUser.getPassword());
		session.setAttribute("loginUser", loginUser);
		List<Role> rs = userService.listUserRoles(loginUser.getId());
		boolean isAdmin = isRole(rs,RoleType.ROLE_ADMIN);
		session.setAttribute("isAdmin", isAdmin);
		if(!isAdmin) {
			session.setAttribute("allActions", getAllActions(rs, session));
			session.setAttribute("isAudit", isRole(rs,RoleType.ROLE_AUDIT));
			session.setAttribute("isPublish", isRole(rs,RoleType.ROLE_PUBLISH));
		}
		session.removeAttribute("cc");
		ForumSessionContext.addSessoin(session);
		return "redirect:/index";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute("userDto",new UserDto());//user,user
		return "member/register";
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String add(@Valid UserDto userDto,BindingResult br,Model model) {
		if(br.hasErrors()) {
			return "member/register";
		}
		User u=userDto.getUser();
		u.setCoins(50);
		u.setStatus(1);
		userService.add(u, new Integer[] {3}, null);
		return "redirect:/ulogin";
	}
	@SuppressWarnings("unchecked")
	private Set<String> getAllActions(List<Role> rs,HttpSession session) {
		Set<String> actions = new HashSet<String>();
		Map<String,Set<String>> allAuths = (Map<String,Set<String>>)session.getServletContext().getAttribute("allAuths");
		actions.addAll(allAuths.get("base"));
		for(Role r:rs) {
			if(r.getRoleType()==RoleType.ROLE_ADMIN) continue;
			actions.addAll(allAuths.get(r.getRoleType().name()));
		}
		return actions;
	}
	
	
	private boolean isRole(List<Role> rs,RoleType rt) {
		for(Role r:rs) {
			if(r.getRoleType()==rt) return true;
		}
		return false;
	}
	
	
	@RequestMapping("/drawCheckCode")
	public void drawCheckCode(HttpServletResponse resp,HttpSession session) throws IOException {
		resp.setContentType("image/jpg");
		int width = 200;
		int height = 30;
		Captcha c = Captcha.getInstance();
		c.set(width, height);
		String checkcode = c.generateCheckcode();
		session.setAttribute("cc", checkcode);
		OutputStream os = resp.getOutputStream();
		ImageIO.write(c.generateCheckImg(checkcode), "jpg", os);
	}
}
