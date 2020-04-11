package com.onmobile.training;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter {

   	private FilterConfig config;
   	
	public void destroy() {
		// TODO Auto-generated method stub
	}
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	
		HttpServletRequest request = (HttpServletRequest)req;
		
		if(request.getParameter("action")!= null && request.getParameter("action").equals("purchase"))
		{
		
			ServletContext ctx = config.getServletContext();
		
			Date now = new Date();
		
			ctx.log("Purchasing the item " + request.getParameter("id") + "  " + now ); // using logging is bset coz chan.log doesnot wait for the writing in the log... so logging is preferred... if we use system.out.println then that chain.dofilter will wait till syso completes printing..coz this is running as a seprate thread
			
		}
		chain.doFilter(req, res); // do before chain.doFilter() is pre-filter.. and after that is post-filter
	}

	
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
		System.out.println("filter me hoon");
	}
}
