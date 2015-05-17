package com.onmobile.training;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {
	private Customer cust;

	@Override
	public void contextDestroyed(ServletContextEvent e) {
		// TODO Auto-generated method stub
		cust = null;
	}
  
	public void contextInitialized(ServletContextEvent e) {
		// TODO Auto-generated method stub
		ServletContext ctx = e.getServletContext();
		cust = new Customer(1008, "Raju", 70000);
		ctx.setAttribute("customer",cust); 
		System.out.println("*********Context Attribute Created");
		
	}
}