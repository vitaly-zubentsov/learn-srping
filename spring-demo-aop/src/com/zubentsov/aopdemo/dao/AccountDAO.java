package com.zubentsov.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zubentsov.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;

	private String serviceCode;

	public void addAccount(String name, int id) {

		System.out.println(this.getClass() + " Do some db work to add account\n");
	}

	public boolean doWork() {

		System.out.println(this.getClass() + " Do work \n");

		return false;
	}
	
	public List<Account> findAccounts(){
		
		List<Account> accounts = new ArrayList<Account>();
		
		accounts.add(new Account("Anna","Silver"));
		accounts.add(new Account("Victor","Platinum"));
		accounts.add(new Account("Igor","Gold"));
		
		return accounts;
	}

	public String getName() {
		System.out.println(this.getClass() + " get Name \n");
		return name;
	}

	public void setName(String name) {
		System.out.println(this.getClass() + " set Name \n");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(this.getClass() + " get ServiceCode \n");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(this.getClass() + " set ServiceCode \n");
		this.serviceCode = serviceCode;
	}

}
