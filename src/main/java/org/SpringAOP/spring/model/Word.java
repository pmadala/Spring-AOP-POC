package org.SpringAOP.spring.model;

import org.springframework.stereotype.Component;

@Component
public class Word {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void throwException() {
		throw new RuntimeException("Dummy Exception");
	}
}
