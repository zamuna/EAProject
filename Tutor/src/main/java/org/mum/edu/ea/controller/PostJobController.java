package org.mum.edu.ea.controller;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.sun.xml.internal.bind.v2.runtime.*;
import com.sun.xml.internal.bind.v2.runtime.Location;
import org.eclipse.jdt.internal.compiler.lookup.MethodBinding;
import org.mum.edu.ea.domain.*;
//import org.mum.edu.ea.domain.Location;
import org.mum.edu.ea.service.IPostJobService;
import org.mum.edu.ea.service.PositionCategoryService;
import org.mum.edu.ea.serviceimpl.PositionCategoryImpl;
import org.mum.edu.ea.serviceimpl.WebUserServiceImpl;
import org.mum.edu.ea.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by Zamuna on 8/11/2017.
 */
@Controller
@RequestMapping("/jobPost")
public class PostJobController {
    @Autowired
    IPostJobService jobService;
    @Autowired
    WebUserServiceImpl webUserService;
    @Autowired
    PositionCategoryImpl positionCategoryService;

    @RequestMapping(value = "/addPosition", method = RequestMethod.POST)
    public String postJob(@ModelAttribute("pos") @Valid Position position, Principal principal, Model model, BindingResult binding) {
        if(binding.hasErrors()){
            return "/postJob/postJob";
        }
        position.setStatus(PositionStatus.ACTIVATE);
        position.setPostedBy(principal.getName());
        jobService.createPosition(position);
        return "redirect:../getPosition/" + position.getId();
    }

    @RequestMapping(value = "/addPosition", method = RequestMethod.GET)
    public String postJobForm(Model model, @ModelAttribute("pos") Position pos) {
        model.addAttribute("categories", Category.values());
        model.addAttribute("states", State.values());
        model.addAttribute("pos", new Position());
        return "/postJob/postJob";
    }

    @RequestMapping(value = "/getAllPosition", method = RequestMethod.GET)
    public String getAll(Model model,Principal principal) {
        //TODO change userid
        model.addAttribute("positionList", jobService.getAllPositionPosted(principal.getName()));
        return "postJob/postList";
    }

    @RequestMapping(value = "/getPosition/{id}", method = RequestMethod.GET)
    public String getOne(@PathVariable Long id, Model model,Position position) {
        model.addAttribute("position", jobService.getPosition(id));
        List<WebUser> userList=jobService.getAllUserApplied(jobService.getPosition(id));
        model.addAttribute("appliedUsers",userList);
        return "postJob/postDetail";
    }

    @RequestMapping(value = "/addPosition/{id}", method = RequestMethod.POST)
    public String updatePosition(Position position, @PathVariable("id") Long id,Principal principal) {
        //TODO get user
        position.setPostedBy(principal.getName());
        position.setStatus(PositionStatus.ACTIVATE);
        jobService.updatePosition(position);
        return "redirect:../getPosition/" + position.getId();
    }

    @RequestMapping(value = "/updatePosition/{id}", method = RequestMethod.GET)
    public String updatePositionForm(Position position, @PathVariable Long id, Model model) {
        model.addAttribute("pos", jobService.getPosition(id));
        model.addAttribute("jobPosition", jobService.getPosition(id));
        model.addAttribute("categories", positionCategoryService.findAll());
        model.addAttribute("states", State.values());
        model.addAttribute("location", new org.mum.edu.ea.domain.Location());
        return "/postJob/postJob";
    }

    @RequestMapping(value = "/deletePosition/{id}", method = RequestMethod.GET)
    public String deletePosition(Position position, @PathVariable("id") Long id) {
        jobService.deletePosition(position);
        return "redirect:../getAllPosition";
    }
}
