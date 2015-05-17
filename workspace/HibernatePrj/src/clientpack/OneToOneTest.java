package clientpack;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.onmobile.training.Address;
import com.onmobile.training.Customer;

public class OneToOneTest 
{
	public static void main(String[] args) 
	{
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Customer c1 = new Customer(1, "Rajesh", 5000);
		Address a1 = new Address(1, "Jaya Nagar", "bangalore");
		c1.setAddress(a1);
		Customer c2 = new Customer(2, "Arjun", 10000);
		Address a2 = new Address(2, "Malad East", "Mumbai");
		c2.setAddress(a2);
		Transaction tx = session.beginTransaction();
		session.save(c1);
		session.save(c2);
		tx.commit();
		
		List <Customer> list = session.createQuery("from Customer").list();
		for(Customer c : list)
		{
			System.out.println( c.getCustomerId() + "\t" +
								c.getCustomerName() + "\t" +
								c.getBalance() + "\t" + 
								c.getAddress().getLocation() + "\t" +
								c.getAddress().getCity());
		}
			
		session.close();
	}
}
