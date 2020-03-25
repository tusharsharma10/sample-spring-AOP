package com.aspect.bean;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {
	public void addAccount() {
		System.out.println("Doing my db work adding an Membership account");
	}
}
