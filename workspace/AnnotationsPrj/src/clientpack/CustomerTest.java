package clientpack;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
		
		/*Customer c1 = new Customer(1, "Rajiv", 60000);
		Customer c2 = new Customer(2, "Arjun", 70000);
		Customer c3 = new Customer(3, "Rahul", 80000);
		Customer c4 = new Customer(4, "Chandra kanth", 90000);
		Transaction tx = session.beginTransaction();
		session.save(c1);
		session.save(c2);
		session.save(c3);
		session.save(c4);
		tx.commit();
		*/
		
		/*
		Query q1 = session.getNamedQuery("findByBalance");
		q1.setParameter("balance", 70000D);
		List <Customer> list = q1.list();
		for(Customer c : list)
		{
			System.out.println(c.getCustomerId() + "\t" + c.getCustomerName() + "\t" + c.getBalance());
		}
		Query q2 = session.getNamedQuery("findByName");
		q2.setParameter("name", "Arjun");
		List <Object[]> list2 = q2.list();
		for(Object[] obj : list2)
		{
			System.out.println(obj[0] + "\t" + obj[1] + "\t" + obj[2]);
		}
		*/
		
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.eq("customerName", "Arjun"));
		List <Customer> list = criteria.list();
		for(Customer c : list)
		{
			System.out.println(c.getCustomerId() + "\t" +c.getCustomerName() + "\t" + c.getBalance());
		}
		System.out.println("Customer whose Name starts with R");
		criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.like("customerName", "R%"));
		list = criteria.list();
		for(Customer c : list)
		{
			System.out.println(c.getCustomerId() + "\t" +c.getCustomerName() + "\t" + c.getBalance());
		}
		
		System.out.println("Customer Names with customerId < 4 and balance > 60000");
		criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.gt("balance", 60000D));
		criteria.add(Restrictions.lt("customerId",4));
		list = criteria.list();
		for(Customer c : list) 
		{
			System.out.println(c.getCustomerId() + "\t" +c.getCustomerName() + "\t" + c.getBalance());
		}
		criteria = session.createCriteria(Customer.class);
		ProjectionList projList = Projections.projectionList();
		/*
		projList.add(Projections.max("balance"));
		projList.add(Projections.min("balance"));
		projList.add(Projections.count("customerId"));
		projList.add(Projections.avg("balance"));
		criteria.setProjection(projList);
		List <Object[]> arrList = criteria.list();
		
		Object[] row = arrList.get(0);
		System.out.println("Maximum balance " + row[0]);
		System.out.println("Minimum balance " + row[1]);
		System.out.println("Count of customers " + row[2]);
		System.out.println("Average balance " + row[3]);
		*/
		projList.add(Projections.max("balance"));
		projList.add(Projections.property("customerId"));
		projList.add(Projections.property("customerName"));
		
		criteria.setProjection(projList);
		List <Object[]> arrList = criteria.list();
		for(Object[] arr : arrList)
		{
			System.out.println(arr[0] + "\t" + arr[1] + "\t" + arr[2]);
		}
		session.close();	
	}
}