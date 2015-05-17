package clientpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onmobile.training.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure(); 
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Customer customer1 =new Customer();
		customer1.setCustomerId(102);
		customer1.setCustomerName("Arvind");
		customer1.setBalance(5000);
		session.save(customer1);
		tx.commit();
	}
}
