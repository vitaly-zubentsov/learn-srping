package com.zubentsov.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zubentsov.aopdemo.dao.AccountDAO;
import com.zubentsov.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {

		// add spring context(java object)

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get accountDAO from contex
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		// add paremeters to account DAO
		accountDAO.setName("silver");
		accountDAO.setServiceCode("red");

		// call business method
		accountDAO.addAccount("easy", 9);
		accountDAO.doWork();

		// get paremeters from DAO
		accountDAO.getName();
		accountDAO.getServiceCode();

		// get membershipDao
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

		// call business membership method
		membershipDAO.addSillyMember();
		membershipDAO.goToSleep();

		// close context
		context.close();
	}

}
