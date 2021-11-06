package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterArrayApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myGymCoach", Coach.class);
		
		System.out.println(theCoach.getDialyWorcout());
		
		System.out.println(theCoach.getDialyFortune());
		
	
		context.close();
	}

}
