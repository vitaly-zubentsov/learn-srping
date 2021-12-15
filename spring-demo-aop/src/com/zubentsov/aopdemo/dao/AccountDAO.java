package com.zubentsov.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {
	
	public void addAccount() {
		
		System.out.println(this.getClass() + " Do some db work to add account");
	}

}
