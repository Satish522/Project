package org.swapna.mission.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

//@Aspect
@Component
public class LoginAspect {
	
	Logger logger=LoggerFactory.getLogger(LoginAspect.class);
	
	//@Around("execution(* org.swapna.mission.service.EmpService.*(..))")
	public Object loginAspect(ProceedingJoinPoint pc) throws Throwable
	{
		String methodName=pc.getSignature().getName();
		logger.info("Started executing "+methodName);
		
		Object ret=pc.proceed();
		
		logger.info("Execution completed of "+methodName+" with return "+ret);
		return ret;
		
	}

}
