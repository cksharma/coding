package com.onmobile.training;

import java.util.Date;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.util.ServletContextAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LogInterceptor extends AbstractInterceptor {

	
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		// TODO Auto-generated method stub
		ActionContext ctx = inv.getInvocationContext();

		ServletContext servletCtx = (ServletContext) ctx
				.get(ServletActionContext.SERVLET_CONTEXT);
		
		// System.out.println("This request is made at " + new Date());
		servletCtx.log("Request made at " + new Date());

		return inv.invoke();
	}

	/*
	 * @Override public void setServletContext(ServletContext context) { // TODO
	 * Auto-generated method stub this.context = context; }
	 */
}
