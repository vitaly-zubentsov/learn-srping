package com.zubentsov.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.zubentsov.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {
	
	//add logger
	private static Logger logger = Logger.getLogger(AroundDemoApp.class.getName());

	public static void main(String[] args) {

		
		
		
		
		
		// add spring context(java object)
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get TrafficFortuneService from contex
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		//call trafficFortuneService
		
		logger.info("Main programm: Around Demo App");
		
		logger.info("Calling trafficFortuneService");
		
		String myFortune = trafficFortuneService.getFortune();
		
		logger.info(myFortune);
		
		logger.info("finished");
		
		// close context
		context.close();
	}

}
