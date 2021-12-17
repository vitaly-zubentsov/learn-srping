package com.zubentsov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1000)
public class MyCloudLoggingAspect {
	
	@Before("com.zubentsov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void logToCloudAsync() {
		System.out.println("----------login to cloud in async fashion-----------");
	}

}
