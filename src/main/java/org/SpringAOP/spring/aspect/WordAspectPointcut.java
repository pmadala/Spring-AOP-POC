package org.SpringAOP.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WordAspectPointcut {

	@Before("getValuePointcut()")
	public void loggingAdvice(){
		System.out.println("Executing loggingAdvice on getValue()");
	}
	
	@Before("getValuePointcut()")
	public void secondAdvice(){
		System.out.println("Executing secondAdvice on getValue()");
	}
	
	@Pointcut("execution(public String getValue())")
	public void getValuePointcut(){}
	
	@Before("allMethodsPointcut()")
	public void allServiceMethodsAdvice(){
		System.out.println("Before executing service method");
	}
	
	//Pointcut to execute on all the methods of classes in a package
	@Pointcut("within(org.SpringAOP.spring.service.*)")
	public void allMethodsPointcut(){}
}
