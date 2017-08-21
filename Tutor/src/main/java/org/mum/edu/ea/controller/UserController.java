package org.mum.edu.ea.controller;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.mum.edu.ea.auth.UserValidator;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.domain.WebUserProfile;
import org.mum.edu.ea.domain.WebUserProfileType;
import org.mum.edu.ea.repository.IPostJob;
import org.mum.edu.ea.service.PostJobService;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
   @Autowired	
   private UserValidator userValidator;
   @Autowired
   private WebUserServiceImpl userService;
   @Autowired
   private PostJobService jobService;
   
	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
   
	// defaul page (just for testing)
	@RequestMapping(value = {"/welcome","/"}, method = RequestMethod.GET)
	public String welcomem(Model model) {
		model.addAttribute("positionList", jobService.getAllPositions());
		System.out.println("---------Here is the result--------------"+jobService.getAllPosition().size());
		return "home";
	}

	
	// defaul page (just for testing)
		@RequestMapping(value = "/registration", method = RequestMethod.GET)
		public String registrationForm(Model model) {
			model.addAttribute("userForm", new WebUser());
			return "registration";
		}


    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") WebUser userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);
        WebUser userExists = userService.findByEmail(userForm.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);
        return "redirect:/";
    }

	@RequestMapping("/UserDetail")
	public String UserDetail(@PathParam("id") Long id, Model model) {

		return "userDetail";
	}
	
	@RequestMapping(value="/redirect/url", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebUser user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", user.getUsername());
		for(WebUserProfile profile : user.getWebUserProfileCollection()){
			System.out.println("-----------user role------------------"+profile.getRole());
		}
		System.out.println("-----------we are here------------------"+user.getId());
		List<String> roles = new ArrayList<>();
		for(WebUserProfile w:user.getWebUserProfileCollection()) {
			roles.add(w.getRole());
		}
		if(roles.contains(WebUserProfileType.ADMIN.name())) {
			System.out.println("-----------we are here------------------"+user.getUsername());
			modelAndView.addObject("positionList",jobService.getAllPositions());
			modelAndView.setViewName("admin/home");
		}else {
			System.out.println("-----------we are here------------------"+user.getUsername()+"User");
			modelAndView.addObject("positionList",jobService.getAllPositions());
			modelAndView.setViewName("user/home");
		}
		
		
		return modelAndView;
	}
	

}
