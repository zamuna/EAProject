package org.mum.edu.ea.controller;



import java.util.List;

import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.service.PositionCategoryService;
import org.mum.edu.ea.service.PostJobService;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/admincontrol")
public class AdminController {
    @Autowired
	WebUserServiceImpl userservice;
    
    @Autowired
    PostJobService postservice;
	
	@RequestMapping("/login")
	public String admin(Model model){
		
		return "/login";
	}
	
	@RequestMapping("/dashboard")
	public String adminView(Model model){
		return "admin/dashboard";
	}

	@RequestMapping(value="/displayuser", method=RequestMethod.GET)
	public String  userDisplay(Model model){
		List<WebUser> userlist = userservice.findAll();
		model.addAttribute("user",userlist);
		return "admin/displayuser";
	
	}
	
	@RequestMapping(value="/joboffer", method=RequestMethod.GET)
	public String  jobOfferDisplay(Model model){
		List<Position> positionlist = postservice.getAllPosition();
				
		model.addAttribute("joboffer",positionlist);
		return "admin/joboffer";
	
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(long  userId) {
		userservice.deleteUserById(userId);
		return "redirect:displayuser";
	}

}
