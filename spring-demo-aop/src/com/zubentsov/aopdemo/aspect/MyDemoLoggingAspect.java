package com.zubentsov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// add pointcut declaration for using one pointcut expression in many advice
	@Pointcut("execution(* com.zubentsov.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// this is where we add all of our related advice for logging
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("----------Call of aspect method---------------");
	}

	@Before("forDaoPackage()")
	public void performApiAnalitics() {
		System.out.println("----------do some analitic stuff---------------");
	}

}
