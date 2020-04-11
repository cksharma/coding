package clientpack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.spring.jdbc.Customer;
import com.onmobile.training.spring.jdbc.CustomerDAO;

public class JdbcTest {

	public static void main(String[] args) {
		// similarly do through Hibernate 
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		CustomerDAO dao = (CustomerDAO)ctx.getBean("dao");
		dao.addCustomer(new Customer(8, "Rajesh", 6000));
		System.out.println("Record added");
		/*Customer c = dao.getCustomer(1);
		System.out.println("Customer Id : " + c.getCustomerId());
		System.out.println("Customer Name " + c.getCustomerName());
		System.out.println("Balance " + c.getBalance());
		System.out.println();
		*/
		/*System.out.println("Listing all the Customers");
		List <Customer> list = dao.getAllCustomer();
		for(Customer cust : list)
		{
			System.out.println(cust.getCustomerId() + "\t" + cust.getCustomerName() + "\t" + cust.getBalance());
		}
		*/
		/*
		Customer c = dao.customerDetails(1);
		System.out.println("Customer Id : " + c.getCustomerId());
		System.out.println("Customer Name " + c.getCustomerName());
		System.out.println("Balance " + c.getBalance());
		System.out.println("Address Id " + c.getAddress().getAddressId());
		System.out.println("Location " + c.getAddress().getLocation());
		System.out.println("city " + c.getAddress().getCity());		
		*/
	}
}
