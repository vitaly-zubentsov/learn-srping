package com.zubentsov.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.zubentsov.aopdemo.Account;

@Aspect
@Component
@Order(-10000)
public class MyDemoLoggingAspect {

	@After("execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..)) ")
	public void afterFindAccountAdvice(JoinPoint joinPoint) {

		// print in which method are advising
		System.out.println("\n------------- executing @After (finnaly) on: " + joinPoint.getSignature().toShortString()
				+ "----------------- \n");

	}

	@AfterThrowing(pointcut = "execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..)) ", throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Exception exception) {

		// print in which method are advising
		System.out.println("\n------------- executing @AfterThrowing on: " + joinPoint.getSignature().toShortString()
				+ "----------------- ");

		// print out the result of method call
		System.out.println("-------------exeption is : " + exception);

	}

	@AfterReturning(pointcut = "execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..)) ", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		// print in which method are advising
		System.out.println("\n------------- executing @AfterReturning on: " + joinPoint.getSignature().toShortString()
				+ "----------------- ");

		// print out the result of method call
		System.out.println("-------------result is : " + result);

		// post process data

		convertAccountNameToUpperCase(result);

		System.out.println("------------- modifed result is : " + result);

	}

	// this is where we add all of our related advice for logging
	@Before("com.zubentsov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint jointPoint) {
		System.out.println("----------Call of aspect method---------------");

		// display method signature
		MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
		System.out.println("Method signatture: " + methodSignature);

		// display method arguments
		Object[] args = jointPoint.getArgs();

		for (Object arg : args) {

			if (arg instanceof String) {
				System.out.println("arg: " + arg + " - it is a String");
			} else if (arg instanceof Integer) {
				System.out.println("arg: " + arg + " - it is an Integer");
			} else {
				System.out.println("arg: " + arg);
			}
		}

	}

	private void convertAccountNameToUpperCase(List<Account> result) {

		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
