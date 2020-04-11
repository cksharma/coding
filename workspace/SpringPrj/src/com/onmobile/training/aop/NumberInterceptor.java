package com.onmobile.training.aop;

import org.springframework.asm.commons.Method;
import org.springframework.cglib.proxy.MethodInterceptor;

public class NumberInterceptor implements MethodInterceptor 
{
	@Override
	public Object invoke(MethodInvocation inv) throws Throwable 
	{

		Method m = inv.getMethod();
		Object[] value = (Object[]) inv.getArguments();
		Object obj = inv.getThis();
		int num1 = (Integer) value[0];
		int num2 = (Integer) value[1];
		int retValue = (Integer) m.invoke(obj, num1 * num1, num2 * num2);
		return retValue;
	}

}
