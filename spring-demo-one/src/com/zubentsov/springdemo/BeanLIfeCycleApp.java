package com.zubentsov.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLIfeCycleApp {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
		
		TrackCoach theCoach = context.getBean("myCoach", TrackCoach.class);		
		
		context.close();
	}

}
