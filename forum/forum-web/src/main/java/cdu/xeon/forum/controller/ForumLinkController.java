package cdu.xeon.forum.controller;

import java.util.Map;

import javax.inject.Inject;

import cdu.xeon.forum.auth.AuthClass;
import cdu.xeon.forum.model.ForumLink;
import cdu.xeon.forum.service.IForumLinkService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@AuthClass
@RequestMapping("/admin/forumLink")
public class ForumLinkController {
	private IForumLinkService forumLinkService;
	
	
	public IForumLinkService getForumLinkService() {
		return forumLinkService;
	}

	@Inject
	public void setforumLinkService(IForumLinkService forumLinkService) {
		this.forumLinkService = forumLinkService;
	}


	@RequestMapping("/links")
	public String list(Model model,String type) {
		model.addAttribute("datas", forumLinkService.findByType(type));
		model.addAttribute("types",forumLinkService.listAllType());
		Map<String,Integer> m = forumLinkService.getMinAndMaxPos();
		model.addAttribute("min", m.get("min"));
		model.addAttribute("max",m.get("max"));
		return "forumLink/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model) {
		model.addAttribute(new ForumLink());
		model.addAttribute("types",forumLinkService.listAllType());
		return "forumLink/add";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String add(@Validated ForumLink forumLink,BindingResult br) {
		if(br.hasFieldErrors()) {
			return "forumLink/add";
		}
		forumLinkService.add(forumLink);
		return "redirect:/admin/forumLink/links";
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String delete(@PathVariable int id) {
		forumLinkService.delete(id);
		return "redirect:/admin/forumLink/links";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.GET)
	public String update(@PathVariable int id,Model model) {
		model.addAttribute(forumLinkService.load(id));
		model.addAttribute("types",forumLinkService.listAllType());
		return "forumLink/update";
	}
	
	@RequestMapping(value="/update/{id}",method=RequestMethod.POST)
	public String update(@PathVariable int id,@Validated ForumLink forumLink,BindingResult br) {
		if(br.hasFieldErrors()) {
			return "forumLink/update";
		}
		ForumLink tcl = forumLinkService.load(id);
		tcl.setNewWin(forumLink.getNewWin());
		tcl.setTitle(forumLink.getTitle());
		tcl.setType(forumLink.getType());
		tcl.setUrl(forumLink.getUrl());
		tcl.setUrlClass(forumLink.getUrlClass());
		tcl.setUrlId(forumLink.getUrlId());
		forumLinkService.update(tcl);
		return "redirect:/admin/forumLink/links";
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public String show(@PathVariable int id,Model model) {
		model.addAttribute(forumLinkService.load(id));
		return "forumLink/show";
	}
}
