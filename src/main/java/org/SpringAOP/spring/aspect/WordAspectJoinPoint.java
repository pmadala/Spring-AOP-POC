package org.SpringAOP.spring.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class WordAspectJoinPoint {
	@Before("execution(public void org.SpringAOP.spring.model..set*(*))")
	public void loggingAdvice(JoinPoint joinPoint){
		System.out.println("Before running loggingAdvice on method="+joinPoint.toString());
		System.out.println("Agruments Passed=" + Arrays.toString(joinPoint.getArgs()));
	}
	
	//Advice arguments, will be applied to bean methods with single String argument
	@Before("args(value)")
	public void logStringArguments(String value){
		System.out.println("String argument passed="+value);
	}
}
