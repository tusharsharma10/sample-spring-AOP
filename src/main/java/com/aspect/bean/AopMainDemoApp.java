package com.aspect.bean;

import java.util.ArrayList;
import java.util.List;

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
//		ob.setAge(23);
//		ob.setName("Zapata");
//		ob.findAccount(ob.getAge());
		
		List<Account> accList = new ArrayList<Account>();
		accList.add(new Account("Rajan", 25, 5090912.00));
		accList.add(new Account("Parbat", 22, 509012.00));
		accList.add(new Account("Rahi", 27, 500912.00));
		
		ob.setAccountList(accList);
		ob.findAccountList();
		
		// close the context
		context.close();

	}

}
