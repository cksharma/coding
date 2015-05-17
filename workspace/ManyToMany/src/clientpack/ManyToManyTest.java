package clientpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onmobile.training.Address;
import com.onmobile.training.Customer;

public class ManyToManyTest 
{
	public static void main(String[] args) 
	{
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		/*
		Customer c1 = new Customer(101, "Rajesh");
		Customer c2 = new Customer(102, "Arvind");
		Customer c3 = new Customer(103, "Arjun");
		
		Address add1 = new Address(501, "BG Road", "Bangalore");
		Address add2 = new Address(502, "Panjakutta", "Hyderabad");
		Address add3 = new Address(503, "Hinjewadi", "Pune");
		Address add4 = new Address(504, "Bandra", "Mumbai");
		
		Set <Address> set1 = new HashSet <Address>();
		set1.add(add2);
		set1.add(add3);
		set1.add(add4);
		
		Set <Address> set2 = new HashSet <Address>();
		set2.add(add4);
		set2.add(add1);
		set2.add(add2);
		
		Set <Address> set3 = new HashSet <Address>();
		set3.add(add1);
		set3.add(add2);
		set3.add(add3);
		
		c1.setSetAddress(set1);
		c2.setSetAddress(set2);
		c3.setSetAddress(set3);
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		tx.commit();
		session.close();
		*/
		
		Address add = (Address)session.load(Address.class, 501);
		System.out.println("City " + add.getCity());
		for(Customer c : add.getSetCustomer())
		{
			System.out.println("Name = " + c.getCustomerName());
		}
	}
}
