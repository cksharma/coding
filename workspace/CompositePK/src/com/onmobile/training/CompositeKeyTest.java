package com.onmobile.training;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CompositeKeyTest {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Name name1 = new Name("Rajesh", "Jain");
		Person p1 = new Person(name1, 23);
		
		Name name2 = new Name("Chandra", "Kanth");
		Person p2 = new Person(name2, 22);
		
		session.save(p1);
		session.save(p2);
		
		tx.commit();
	}
}
