package com.onmobile.training;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAO {
	private HibernateTemplate templatee;

	public void setTemplatee(HibernateTemplate templatee) {
		this.templatee = templatee;
	}
	
	public void addCustomer(Customer c)
	{
		templatee.save(c);
	}
	
	public List<Customer> getAllCustomers()
	{
		return templatee.find("from Customer");
	}
}
