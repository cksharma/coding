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

public class LogFilter implements Filter{
	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) req;
		String uri = request.getRequestURI();
		ServletContext sc = config.getServletContext();
		Date now = new Date();
		sc.log("request for " + uri + " is made at " + now);
		long startTime = System.currentTimeMillis();
		chain.doFilter(req, resp); // if there are other filers also it takes to that filter.
		long endTime = System.currentTimeMillis();
		long timeTaken = endTime - startTime;
		sc.log("time taken to process is " + timeTaken);
	}
	
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.config = config;
	}	
}
