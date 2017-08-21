package org.mum.edu.ea.utils;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.mum.edu.ea.domain.Position;
import org.mum.edu.ea.service.PostJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;

import java.security.Principal;

@Component
@Aspect
public class ServiceTimerAdvice {
	@Autowired
	private PostJobService postJobService;
	@Autowired
	private MailUtil mailUtil;
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceTimerAdvice.class);
	@Around("execution(* org.mum.edu.ea.service.PostJobService.getAllPositions(..))")
	public Object time(ProceedingJoinPoint call) throws Throwable {
		StopWatch sw = new StopWatch();
		sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		
		long totaltime=sw.getLastTaskTimeMillis();
        System.out.println("-------------Time to execute-------------- "+call.getSignature().getName()+" ---------------=-----"+totaltime+" ms");
       // LOGGER.debug("------------------Time to execute method getAllPosition-------------- "+call.getSignature().getName()+" ---------------=-----"+totaltime+" ms");
		return retVal;
	}

	@After("execution(* org.mum.edu.ea.controller.ApplyJobController.applyJob(..)) && args(jobId,principal,model)")
	public void sendEmail(Long jobId, Principal principal, Model model){
		Position position=postJobService.getPosition(jobId);
		mailUtil.sendEmail(principal.getName(),"zamuna16@gmail.com","Applied for this job","You have successfully applied for this job with title "
				+position.getTitle()+ " and its deadline is: "+position.getDeadline());
	}

}
