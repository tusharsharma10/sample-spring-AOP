package com.aspect.bean;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

	private static Logger log = Logger.getLogger(DemoLoggingAspect.class);
	// point cut expression
	// this method will get execute before addAccount method
	
	/**
	 * @Before("execution(public void com.aspect.bean.AccountDAO.addAccount())"
	 * @Before("execution(public void add*())")
	 * @Before("execution(public * addAccount())"
	 */
	
	/**
	 * Using pointcut
	 */
	@Pointcut("execution(public void saveAccount(..))")
	private void myPointcut(){};
	
	/**
	 * Combining Pointcuts
	 */
	// pointcut for all methods in class AccountDAO
	@Pointcut("execution(* com.aspect.bean.AccountDAO.*(..))")
	private void myAccountDao(){};
	
	// pointcut for all getter methods in class AccountDAO
	@Pointcut("execution(* com.aspect.bean.AccountDAO.get*(..))")
	private void myAccountDaoGetter(){};
	
	// pointcut for all setter methods in class AccountDAO
	@Pointcut("execution(* com.aspect.bean.AccountDAO.set*(..))")
	private void myAccountDaoSetter(){};
	
	@Pointcut("myAccountDao() && !(myAccountDaoGetter() || myAccountDaoSetter() )")
	public void myAccountDaoSimpleMethods(){};
	
	@Before("myAccountDaoSimpleMethods()")
	public void beforeSimpleAccountAdvice(){
		System.out.println("@Before executing non getter and setter method ");
	}
	
	@After("myAccountDao()")
	public void afterAllmethods(){
		System.out.println("@After executing all methods of AccountDao class ");
	}
	
	
	@Before("myPointcut()")
	public void beforeSaveAccountAdvice(){
		System.out.println("@Before save advice executing");
	}
	
	@Before("execution(public void addAccount())")
	public void beforeAddAccountAdvice(){
		System.out.println("@Before Add advice executing");
	}
	
}
