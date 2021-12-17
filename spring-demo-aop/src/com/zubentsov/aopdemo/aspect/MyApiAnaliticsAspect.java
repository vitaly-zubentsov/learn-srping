package com.zubentsov.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-80)
public class MyApiAnaliticsAspect {

	@Before("com.zubentsov.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterAndSetter()")
	public void performApiAnalitics() {
		System.out.println("----------do some analitic stuff---------------");
	}
}
