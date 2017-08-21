package org.mum.edu.ea.controller;

import java.security.Principal;
import java.util.List;

import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.mum.edu.ea.service.PostJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchController {
	
	@Autowired
	private WebUserServiceImpl userService;
	@Autowired
	private PostJobService jobService;
	
    @RequestMapping(value = "/searchPosition", method=RequestMethod.POST)
	public String searchPosition(@ModelAttribute("keyword") String keyword,Principal principal, Model model) {
		
    	model.addAttribute("keyword", keyword);
    	if(principal!=null) {
			String email = principal.getName();
			WebUser user = userService.findByEmail(email);
			model.addAttribute("user", user);
		}
		
		List<Position> positionList = jobService.getAllMatchsPosition(keyword);
		
		if (positionList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "search";
		}
		
		model.addAttribute("positionList", positionList);
		
		return "search";
	}
    
    @PostMapping("/job/apply/{jobId}/{keyword}")
    public String applyJob(@PathVariable Long jobId,@PathVariable String keyword, Principal principal, Model model){
      //  System.out.println("Apply Job---->"+jobId);
    	//ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		WebUser user = userService.findByEmail(auth.getName());
		model.addAttribute("user", user);

        Position applyPosition=jobService.getPosition(jobId);
        user.addPosition(applyPosition);
        
        applyPosition.setWebUser(user);
        jobService.updatePosition(applyPosition);
        System.out.println("------------done here----------------------"+user.getEmail());
        return "applyresult";
    }

}
