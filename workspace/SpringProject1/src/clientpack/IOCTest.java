package clientpack;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.Customer;
import com.onmobile.training.CustomerDAO;

public class IOCTest {
	public static void main(String[] args) {
		ApplicationContext ctx =new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		//Customer cust = (Customer)ctx.getBean("customer");
		//Address add = cust.getAddress();
		//System.out.println(cust.getCustomerId() + "\t" + cust.getCustomerName() + add.getLocation() + "\t" + add.getCity());
		CustomerDAO dao = (CustomerDAO)ctx.getBean("customerDAO");
		List <Customer> list = dao.getAllCustomers();
		for(Customer c : list)
		{
			System.out.println(c.getCustomerId() + "\t" + c.getCustomerName());
		}
	}
}