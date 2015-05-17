package clientpack;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.onmobile.training.Customer;

public class CustomerTest
{
	public static void main(String[] args) 
	{
		Configuration conf =new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(new Customer(101, "Rajiv"));
		session.save(new Customer(102, "Arjun"));
		tx.commit();
	}
}