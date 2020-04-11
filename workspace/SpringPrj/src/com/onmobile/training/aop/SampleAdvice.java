package com.onmobile.training.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class SampleAdvice 
{
	@Before("com.onmobile.training.aop.MyPointCut.samplePointCut()")
	public void beforedoSomething()
	{
		System.out.println("Before doing Something");
	}
	
	@After("com.onmobile.training.aop.MyPointCut.samplePointCut()")
	public void afterdoSomething()
	{
		System.out.println("After  doing Something");
	}
}
