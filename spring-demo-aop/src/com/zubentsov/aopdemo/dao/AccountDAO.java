package com.zubentsov.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	private String name;

	private String serviceCode;

	public void addAccount() {

		System.out.println(this.getClass() + " Do some db work to add account\n");
	}

	public boolean doWork() {

		System.out.println(this.getClass() + " Do work \n");

		return false;
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
		System.out.println(this.getClass() + "set ServiceCode \n");
		this.serviceCode = serviceCode;
	}

}
