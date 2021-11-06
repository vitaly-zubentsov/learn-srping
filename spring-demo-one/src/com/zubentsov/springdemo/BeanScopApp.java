package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		Coach theCoach = context.getBean("myCoach", TrackCoach.class);
		
		Coach anotherCoach = context.getBean("myCoach", TrackCoach.class);
		
		boolean result = (theCoach == anotherCoach);
		
		System.out.println(" Beans are the same : " + result);

		System.out.println("\n The pointer of TheCoach : " + theCoach);
		
		System.out.println("\n The pointer of anotherCoach : " + anotherCoach);
		
		context.close();
		
	}

}
