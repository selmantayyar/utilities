package com.utils.samples.spring.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	
	private static final Logger LOG=Logger.getLogger(LoggingAspect.class);
	
	@Before("allGetters()")
	public void loggingAdvice(JoinPoint joinPoint)
	{		
	    String objectName=joinPoint.getTarget().getClass().getName();
		LOG.info(objectName+ " getter  Called");
	}
	
	@Before(value="execution(void com.utils.samples.spring.aop.model.Circle.setName(String)) && args(inputName)")
	public void setterAdvice(JoinPoint joinPoint,String inputName)
	{
		LOG.info("Setter Method Called for Circle with param "+inputName);
	}
	
	@AfterReturning(pointcut="args(name)",returning="returnString")
	public void stringArgumentsMethod(String name,String returnString){
		LOG.info("String Arguments Method called,param is: "+name);
		
		LOG.info("Return value of method is: "+returnString);
	}
	
	@AfterThrowing(pointcut="args(value)",throwing="ex")
	public void stringArgumentsMethodException(Integer value,RuntimeException ex){
		LOG.info("String Arguments Method called with EXCEPTION,exception is: "+ex.toString());
	}
	
	@Pointcut("execution(* get*(..))")	
	public void allGetters(){
			
	}

	@Pointcut("within(com.utils.samples.spring.aop.model.Circle)")	
	public void allCircleMethods(){
			
	}

}
