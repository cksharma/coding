package clientpack;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.onmobile.training.Account;
import com.onmobile.training.Customer;

public class OneToManyTest {
	public static void main(String[] args) {
		Configuration conf=new Configuration().configure();
		SessionFactory factory=conf.buildSessionFactory();
		Session session=factory.openSession();
		Customer c1=new Customer(1,"Rajesh");
		Customer c2=new Customer(2,"Rakesh");
		Account a1=new Account(101,"SB",5000);
		Account a2=new Account(102,"CA",10000);
		Account a3=new Account(103,"RD",15000);
		Account a4=new Account(104,"SB",25000);
		Set<Account> list1=new HashSet<Account>();
		list1.add(a1);
		list1.add(a2);
		Set<Account> list2=new HashSet<Account>();
		list2.add(a3);
		list2.add(a4);
		
		c1.setAccountList(list1);
		c2.setAccountList(list2);
		
		Transaction tx=session.beginTransaction();
		session.save(c1);
		session.save(c2);
		tx.commit();
		session.close();
	}
}
