package com.aspect.bean;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

	@AfterReturning(pointcut = "execution(* com.aspect.bean.AccountDAO.findAccountList(..))",returning = "accountList" )
	public void logAccountList(JoinPoint jp,List<Account> accountList ){
		
		
		for(Account a:accountList){
			System.out.print(a.getName()+" ");
		}
		
		
	}
}
