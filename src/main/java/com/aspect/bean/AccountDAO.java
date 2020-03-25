package com.aspect.bean;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	private Integer age;
	
	public void addAccount() {
		System.out.println("Doing my db work adding an account");
	}
	
	public void saveAccount() {
		System.out.println("Doing my db work saving an account");
	}
	
	public void findAccount() {
		System.out.println("Doing my db work finding an account");
	}
	
}
