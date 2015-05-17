package com.onmobile.training;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

public class CustomerDAO {
	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	public void addCustomer(Customer c)
	{
		template.save(c);
		
	}
	public List <Customer> getAllCustomers()
	{
		List <Customer> list = template.find("from Customer");
		return list;
	}
	public void deleteCustomer(int id)
	{
		Customer c =(Customer)template.load(Customer.class, id);
		template.delete(c);
	}
}
