package com.zubentsov.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<BeginWith, String> {

	private String beginWithSymbols;

	@Override
	public void initialize(BeginWith theBeginWith) {
		beginWithSymbols = theBeginWith.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraintValidatorContext) {

		if (theCode != null) {
			return theCode.startsWith(beginWithSymbols); 
		} else {
			return true;
		}
	}
}