package com.onmobile.training;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FirstTest {

	public static void main(String[] args) {
	
		Configuration conf = new Configuration().configure();//create the configuration object.configure() reads the content from cfg.xml and loads it when called..If we have given different name then it should be explicitly passed to the method.
		SessionFactory factory = conf.buildSessionFactory();//its a factory of session objects. only thru a session we can interact with the ORM tools
		Session session = factory.openSession();//we have to build a session to connect to the ORM tools that in turn connects to the database. and we need to open the session explicitley by this method.
		Customer cust1 = new Customer(101, "Rajesh", 10000);
		Customer cust2 = new Customer(102, "Arvind", 30000);
		Transaction tx = session.beginTransaction();
		session.save(cust1);
		
		session.save(cust2);
		tx.commit();
	
		Query query=session.createQuery("from Customer");
		List<Customer> list=query.list();
		for(Customer c:list){
			System.out.println(c.getCustomerId()+"\t"+c.getCustomerName()+"\t"+c.getBalance());
		}
		session.close();//we shud close the session at last
	}
}
