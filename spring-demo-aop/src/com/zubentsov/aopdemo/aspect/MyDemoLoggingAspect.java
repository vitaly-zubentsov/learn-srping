package com.zubentsov.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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

	private Logger logger = Logger.getLogger(this.getClass().getName());

	@Around("execution(* com.zubentsov.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// print in which method are advising
		logger.info("\n=======> executing @After (finnaly) on: " + proceedingJoinPoint.getSignature().toShortString());

		// get begin timestamp
		long begin = System.currentTimeMillis();

		// execute the method
		Object result = null;

		try {
			result = proceedingJoinPoint.proceed();
		} catch (Exception ex) {

			// log the exception
			logger.warning(ex.getMessage());

			// give a user custom message
			result = "Major accident! B ut no worries, be happy";
		}

		// get end timestamp
		long end = System.currentTimeMillis();

		// calculate and print duration
		logger.info("=======> Duration: " + ((end - begin) / 1000) + " sec");

		return result;
	}

	@After("execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFindAccountAdvice(JoinPoint joinPoint) {

		// print in which method are advising
		logger.info("\n------------- executing @After (finnaly) on: " + joinPoint.getSignature().toShortString()
				+ "----------------- \n");

	}

	@AfterThrowing(pointcut = "execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..)) ", throwing = "exception")
	public void afterThrowingFindAccountAdvice(JoinPoint joinPoint, Exception exception) {

		// print in which method are advising
		logger.info("\n------------- executing @AfterThrowing on: " + joinPoint.getSignature().toShortString()
				+ "----------------- ");

		// print out the result of method call
		logger.info("-------------exeption is : " + exception);

	}

	@AfterReturning(pointcut = "execution(* com.zubentsov.aopdemo.dao.AccountDAO.findAccounts(..)) ", returning = "result")
	public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result) {

		// print in which method are advising
		logger.info("\n------------- executing @AfterReturning on: " + joinPoint.getSignature().toShortString()
				+ "----------------- ");

		// print out the result of method call
		logger.info("-------------result is : " + result);

		// post process data

		convertAccountNameToUpperCase(result);

		logger.info("------------- modifed result is : " + result);

	}

	// this is where we add all of our related advice for logging
	@Before("com.zubentsov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void beforeAddAccountAdvice(JoinPoint jointPoint) {
		logger.info("----------Call of aspect method---------------");

		// display method signature
		MethodSignature methodSignature = (MethodSignature) jointPoint.getSignature();
		logger.info("Method signatture: " + methodSignature);

		// display method arguments
		Object[] args = jointPoint.getArgs();

		for (Object arg : args) {

			if (arg instanceof String) {
				logger.info("arg: " + arg + " - it is a String");
			} else if (arg instanceof Integer) {
				logger.info("arg: " + arg + " - it is an Integer");
			} else {
				logger.info("arg: " + arg);
			}
		}

	}

	private void convertAccountNameToUpperCase(List<Account> result) {

		for (Account account : result) {
			account.setName(account.getName().toUpperCase());
		}
	}

}
