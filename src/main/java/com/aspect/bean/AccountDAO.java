package com.aspect.bean;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		System.out.println("Doing my db work adding an account");
	}
}
