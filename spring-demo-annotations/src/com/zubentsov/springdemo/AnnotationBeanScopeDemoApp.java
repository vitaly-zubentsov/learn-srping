package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach theCoach2 = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach==theCoach2);
		
		System.out.println("Is theCoach and theCoach2 the same : " + result);
		
		System.out.println("TheCoach pointing to :" + theCoach);
		
		System.out.println("TheCoach2 pointing to :" + theCoach2);
		 
		context.close();
	}

}
