package com.utils.samples.spring.aop.model;

import org.springframework.stereotype.Component;

@Component
public class Circle {

	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name)  {
		this.name = name;	
	}
    
	public String setNameAndReturn(String name)  {
		this.name = name;	
		return name;

	}
	
	public void getThrowException(Integer value)  {
	
		throw (new RuntimeException("Exception thrown to test AOP,value is "+value));
	}
	
	public void testThrowException(Integer value)  {
		
		try{
			getThrowException(value);
		}
		
		catch (RuntimeException ex){
			//do nothing
		}
		
	}


}
