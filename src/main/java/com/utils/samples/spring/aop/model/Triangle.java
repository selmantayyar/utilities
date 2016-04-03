package com.utils.samples.spring.aop.model;

import org.springframework.stereotype.Component;

@Component
public class Triangle {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getNewName(String newName) {
		return name+newName;
	}

}
