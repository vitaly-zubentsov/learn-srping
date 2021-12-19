package com.zubentsov.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zubentsov.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// add spring context(java object)

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get accountDAO from contex
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// call method to find accounts

		List<Account> accounts = accountDAO.findAccounts();

		
		System.out.println("\nprint accounts from main: \n");
		System.out.println(accounts );
		// close context 
		context.close();
	}

}
