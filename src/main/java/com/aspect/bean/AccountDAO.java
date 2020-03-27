package com.aspect.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	private String name;
	private Integer age;
	private List<Account> accountList;
	
	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

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

	
	
	public void addAccount() {
		System.out.println("Doing my db work adding an account");
	}
	
	public void saveAccount() {
		System.out.println("Doing my db work saving an account");
	}
	
	public void findAccount(Integer age) {
		System.out.println("Doing my db work finding an account");
	}
	
	public List<Account> findAccountList(boolean flag) {
		
		if(flag)
			throw new RuntimeException();
		
		System.out.println("Doing my db work findingaccount list");
		return accountList;
	}
	
}
