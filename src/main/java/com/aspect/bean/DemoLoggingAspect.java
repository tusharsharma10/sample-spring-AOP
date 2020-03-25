package com.aspect.bean;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

	private static Logger log = Logger.getLogger(DemoLoggingAspect.class);
	// point cut expression
	// this method will get execute before addAccount method
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice(){
		System.out.println("@Before advice executing");
	}
	
}
