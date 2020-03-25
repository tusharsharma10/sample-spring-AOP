package com.aspect.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class LogToCloudAspect {

	@Before("com.aspect.bean.DemoLoggingAspect.myAccountDaoSimpleMethods()")
	public void logToCloud(JoinPoint jp){
		
		MethodSignature methodSignature = (MethodSignature) jp.getSignature();
		System.out.println("Method Signature: "+methodSignature);
		System.out.println("Logging to cloud");
	}
	
}
