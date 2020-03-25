package com.aspect.bean;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AopMainDemoApp {

	public static void main(String[] args) {
		// log4j configuration
		//BasicConfigurator.configure();
		// read spring java config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		AccountDAO ob = context.getBean("accountDAO", AccountDAO.class);
		MembershipDao mem = context.getBean("membershipDao",MembershipDao.class);
		// call the business method
		ob.findAccount();
		
		// close the context
		context.close();

	}

}
