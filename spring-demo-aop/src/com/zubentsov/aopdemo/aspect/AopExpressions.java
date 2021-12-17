package com.zubentsov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {

	// add pointcut declaration for using one pointcut expression in many advice
	@Pointcut("execution(* com.zubentsov.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// create pointcut for getter and setter method DAO package
	@Pointcut("execution(* com.zubentsov.aopdemo.dao.*.set* (..))")
	private void setter() {
	}

	@Pointcut("execution(* com.zubentsov.aopdemo.dao.*.get*(..))")
	private void getter() {
	}

	// create pointcut: include package DAO and exclude getter and setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterAndSetter() {
	}
}
