package org.SpringAOP.spring.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class WordAfterAspect {
	@After("args(value)")
	public void logStringArguments(String value) {
		System.out.println("Running After Advice. String argument passed=" + value);
	}

	@AfterThrowing("within(com.SpringAOP.spring.model.Word)")
	public void logExceptions(JoinPoint joinPoint) {
		System.out.println("Exception thrown in Word Method=" + joinPoint.toString());
	}

	@AfterReturning(pointcut = "execution(* getValue())", returning = "returnString")
	public void getValueReturningAdvice(String returnString) {
		System.out.println("getValueReturningAdvice executed. Returned String=" + returnString);
	}
}
