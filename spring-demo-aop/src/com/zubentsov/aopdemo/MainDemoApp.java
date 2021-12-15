package com.zubentsov.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zubentsov.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//add spring context(java object)
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get accountDAO from context
		
		AccountDAO accountDao = context.getBean("accountDAO", AccountDAO.class);
		
		//call business method
		accountDao.addAccount();
		
		//close context
		context.close();
	}

}
