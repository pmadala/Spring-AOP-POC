package org.SpringAOP.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class WordAspect {
	@Before("execution(public String getValue())")
	public void getValueAdvice(){
		System.out.println("Executing Advice on getValue()");
	}
	
	@Before("execution(* org.SpringAOP.spring.service.*.get*())")
	public void getAllAdvice(){
		System.out.println("Service method getter called");
	}
}
