package com.onmobile.training;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


public class CustomerController extends AbstractController
{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		ServletContext ctx = getServletContext();
		ApplicationContext actx = WebApplicationContextUtils.getWebApplicationContext(ctx);
		int customerId = Integer.parseInt(req.getParameter("customerId"));
		CustomerDetails details = (CustomerDetails)actx.getBean("customerDetails");
		Customer customer = details.getCustomerDetails(customerId);
		String viewName = "showcustomer";
		String modelName = "customer";
		System.out.println(customer.getCustomerName());
		return new ModelAndView(viewName, modelName, customer);
	}
	
}
