package com.onmobile.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeDAO 
{
	Configuration conf;
	
	SessionFactory factory;
	
	EmployeeDAO()
	{
		conf = new Configuration().configure();
		
		factory = conf.buildSessionFactory();
	}
	
	public boolean addEmployee(Employee emp, Account acc)
	{
		try
		{
			//Configuration conf = new Configuration().configure();
			
			//SessionFactory factory = conf.buildSessionFactory();
			
			Session session = factory.openSession();
			
			Transaction tx = session.beginTransaction();
			
			emp.setAccount(acc);
			
					
			session.save(emp);
			
			tx.commit();
			
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
