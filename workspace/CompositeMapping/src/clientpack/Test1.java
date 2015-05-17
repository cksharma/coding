package clientpack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.onmobile.training.Employee;
import com.onmobile.training.Project;
import com.onmobile.training.ProjectMembers;

public class Test1 {

	public static void main(String[] args) {
		
		Configuration config=new Configuration().configure();
		SessionFactory factory=config.buildSessionFactory();
		Session session=factory.openSession();
		Employee e1=new Employee(1, "Naveen", "CEO", 1);
		Employee e2=new Employee(2, "Keerti", "Director", 1);
		Employee e3=new Employee(3, "Pranav", "Project Leader", 2);
		Employee e4=new Employee(4, "Tarun", "SE", 3);
		
		Project p1=new Project(101, "Cloud Computing", 0, 0.0);
		Project p2=new Project(102, "Live Cricket", 1, 0.0);
		
		List<Employee> s1=new ArrayList<Employee>();
		
		s1.add(e1);
		s1.add(e2);
		
		List<Employee> s2=new ArrayList<Employee>();
		s2.add(e3);
		s2.add(e4);
		s2.add(e2);
		p1.setMembers(s1);
		p2.setMembers(s2);
		
		Transaction tx=session.beginTransaction();
		session.save(e1);
		session.save(p1);
		session.save(p2);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		tx.commit();
		session.close();
	}
}