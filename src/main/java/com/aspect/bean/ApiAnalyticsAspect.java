package com.aspect.bean;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class ApiAnalyticsAspect {

	@Before("com.aspect.bean.DemoLoggingAspect.myAccountDaoSimpleMethods()")
	public void logToApi() {
		System.out.println("Logging to api analytics aspect");
	}

	// Runs after method returns successfully
	@AfterReturning(pointcut = "execution(* com.aspect.bean.AccountDAO.findAccountList(..))",returning = "accountList" )
	public void logAccountList(JoinPoint jp,List<Account> accountList ){
		
		
		for(Account a:accountList){
			
			if(a.getName().equals("Parbat")){
				a.setBalance(10.00);
				a.setName("Sharbat");
			}
				
		}
		
		
	}
	
	
	// Runs if exception is thrown
	@AfterThrowing(pointcut = "execution(* com.aspect.bean.AccountDAO.findAccountList(..))",throwing = "e")
	public void logException(JoinPoint jp, Throwable e){
		
		System.out.println("In @AfterThrowing exception caught: "+e);
	}
	
}
