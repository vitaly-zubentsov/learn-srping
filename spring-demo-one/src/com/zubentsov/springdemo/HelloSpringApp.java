package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach",Coach.class);
		
		System.out.println(theCoach.getDialyWorcout());
		
		System.out.println(theCoach.getDialyFortune());
		
		context.close();
		
	}

}
