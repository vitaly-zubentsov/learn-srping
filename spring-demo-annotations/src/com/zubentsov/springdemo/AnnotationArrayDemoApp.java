package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationArrayDemoApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("propertyFile-applicationContext.xml");
		
		Coach theCoach = context.getBean("gymCoach", Coach.class);
		
		System.out.println(theCoach.getDialyWorkout());
		
		System.out.println(theCoach.getDialyFortune());
		
		context.close();
		
		
	}
	
	

}
