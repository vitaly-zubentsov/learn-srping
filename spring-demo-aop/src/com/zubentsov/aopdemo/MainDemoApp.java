package com.zubentsov.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zubentsov.aopdemo.dao.AccountDAO;
import com.zubentsov.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		//add spring context(java object)
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get accountDAO from contex		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call business method
		accountDAO.addAccount();
		accountDAO.doWork();
		
		//get membershipDao
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call business membership method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();
		
		//close context
		context.close();
	}

}
