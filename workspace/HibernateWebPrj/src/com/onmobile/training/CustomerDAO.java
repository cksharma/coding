package com.onmobile.training;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

public class CustomerDAO {
	private SessionFactory sessionFactory;
	
	public CustomerDAO()
	{
		super();
		Configuration conf = new Configuration().configure();
		sessionFactory = conf.buildSessionFactory();
	}
	
	public Customer findCustomer(int customerId)
	{
		Customer c = null;
		Session session = sessionFactory.openSession();
		c = (Customer)session.get(Customer.class, customerId); // session.get retrives the Customer object for the corresponding customerId .. with PK it can retrive the class object..
		return c;
	}
}
