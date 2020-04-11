package clientpack;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onmobile.training.Address;
import com.onmobile.training.Employee;

public class OneToOneTest {
	public static void main(String[] args) {
		Configuration conf = new Configuration().configure(); 
		conf.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/trainingDB");
		
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e = new Employee(3, "Raju", "Developer", 25000);
		Address add = new Address(113, "J.P.Nagar", "Bangalore");
		add.setEmpId(12);
		e.setAddress(add);
		session.save(e);
		tx.commit();
		//session.save(add); // by making cascade all it like this.
		
		Employee e1 = (Employee) session.load(Employee.class, 3);
		System.out.println("ID = " + e1.getEmployeeId() + "\tName" + e1.getEmployeeName());
		
		Address add1 = e1.getAddress();
		System.out.println("Location = " + add1.getLocation() + "\tCity = " + add1.getCity());		
		
	}
}
