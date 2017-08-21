package org.mum.edu.ea.controller;

import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.domain.PositionStatus;
import org.mum.edu.ea.domain.WebUser;
import org.mum.edu.ea.service.PostJobService;
import org.mum.edu.ea.service.WebUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;

/**
 * Created by Zamuna on 8/14/2017.
 */
@Controller
@RequestMapping("/job")
public class ApplyJobController {
    @Autowired
   PostJobService postJobService;
    @Autowired
    WebUserService webUserService;
@PostMapping("/apply/{jobId}")
public String applyJob(@PathVariable Long jobId, Principal principal, Model model){
    System.out.println("Apply Job---->"+jobId);
    Position applyPosition=postJobService.getPosition(jobId);
    //TODO change user
    WebUser user=webUserService.findByEmail(principal.getName());
    applyPosition.setWebUser(user);
    postJobService.updatePosition(applyPosition);
    return "redirect:../apply";
}

@GetMapping("/apply")
    public String appliedJob(Principal principal, Model model){
    //TODO convert to email
    model.addAttribute("uemail",principal.getName());
    model.addAttribute("positionList",postJobService.getAllPositionApplied(webUserService.findByEmail(principal.getName())));
    return "applyJob/appliedJobs";
}

@PostMapping("/approve/{pId}/{uId}")
    public String approveUser(@PathVariable("pId")Long pid,@PathVariable("uId") Long uId){
    System.out.println("Approve USer");
        Position position=postJobService.getPosition(pid);
        position.setSelectedUser(webUserService.findById(uId).getEmail());
        position.setStatus(PositionStatus.DEACTIVIATE);
        postJobService.updatePosition(position);
        return "redirect:/jobPost/getPosition/"+pid;
}
}
