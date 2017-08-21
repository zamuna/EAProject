package org.mum.edu.ea.utils;


import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.mum.edu.ea.domain.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Useraspect {
	
	@Autowired
	private MailUtil mailUtil;
	
	@After("execution(* org.mum.edu.ea.service.WebUserService.save(..)) && args(user)")
	public void logBefore(WebUser user) {
		
		mailUtil.sendEmail(user.getEmail(), "kuthu.eshan@gmail.com", "Your account is created", "Congratulation for your account");
		
		
	}

}
