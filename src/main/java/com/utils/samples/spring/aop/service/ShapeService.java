package com.utils.samples.spring.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.utils.samples.spring.aop.model.Circle;
import com.utils.samples.spring.aop.model.Triangle;

@Component
public class ShapeService {

	@Autowired
	private Circle circle;
	
	@Autowired
	private Triangle triangle;
	
	
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
