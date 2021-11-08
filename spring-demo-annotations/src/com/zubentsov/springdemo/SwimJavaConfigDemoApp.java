package com.zubentsov.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("swimCoach", Coach.class);
		
		System.out.println(theCoach.getDialyWorkout());
		
		System.out.println(theCoach.getDialyFortune());
		
		context.close();
		
	}

}
