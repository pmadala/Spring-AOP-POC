package org.SpringAOP.spring.aspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.SpringAOP.spring.model.Trie;
import org.SpringAOP.spring.model.Word;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class WordAroundAspect {
	@Around("execution(* org.SpringAOP.spring.model.Word.getValue())")
	public Object wordAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		System.out.println("Before invoking getValue() method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking getValue() method. Return value=" + value);
		return value;
	}

	@Pointcut("execution(* org.SpringAOP.spring.service.WordService.setWord())")
	public void setWordAroundAdvice(ProceedingJoinPoint pjp) {
		System.out.println("Before invoking setWord() method");

		try {
			String value = getWordValueFromParameters(pjp);
			if (!value.isEmpty()) {
				if (!Trie.INSTANCE.hasWord(value)) {
					System.out.println("setWordAroundAdvice inserting word to cache");
					Trie.INSTANCE.insert(value);
					pjp.proceed();
				} else {
					System.out.println("setWordAroundAdvice retrieve word from cache");
					Trie.INSTANCE.searchNode(value);
				}
			} else {
				System.out.println("setWordAroundAdvice Word arg doesnt have content.");
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("After invoking setWord() method.");
		return;
	}

	private String getWordValueFromParameters(ProceedingJoinPoint pjp)
			throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		String value = "";
		for (final Object argument : pjp.getArgs()) {
			if (argument instanceof Word) {
				value = getValueFromWord(argument);
			}
		}
		return value;
	}

	private String getValueFromWord(Object argument) throws NoSuchMethodException, SecurityException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		String methodName = "getValue";
		Method method = Word.class.getMethod(methodName, new Class[] {});
		String value = (String) method.invoke(argument, new Object[] {});
		return value;
	}
}
