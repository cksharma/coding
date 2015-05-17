package com.onmobile.training.aop;


@Aspect
public class MyPointCut {

	@Pointcut("execution(* com.onmobile.training.aop.Sample.doSomething())")
	public void samplePointCut() {
		System.out.println("Sample Point Cut Starting");
	}
}