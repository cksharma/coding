package com.onmobile.training;

import com.opensymphony.xwork2.ActionSupport;

public class AddCustomerAction extends ActionSupport{
	
	private CustomerDAO customerDAO;
	
	private int customerId;
	private String customerName;
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerDAO(CustomerDAO customerDAO)
	{
		this.customerDAO=customerDAO;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer=new Customer();
		customer.setCustomerId(customerId);
		customer.setCustomerName(customerName);
		customerDAO.addCustomer(customer);
		return SUCCESS;
	}
}
