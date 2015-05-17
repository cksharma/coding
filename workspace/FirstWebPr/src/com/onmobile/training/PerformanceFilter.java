package com.onmobile.training;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class PerformanceFilter
 */
public class PerformanceFilter implements Filter {

    private FilterConfig config;
	
    public PerformanceFilter() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		
		long requestedTime = System.currentTimeMillis();
		chain.doFilter(req, res);
		long currentTime = System.currentTimeMillis();
		long timeTaken = currentTime - requestedTime;
		config.getServletContext().log("Time taken to process: " + timeTaken + " milli seconds");
	}

	public void init(FilterConfig c) throws ServletException {
		// TODO Auto-generated method stub
		config = c;
	}

}
