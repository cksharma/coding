package clientpack;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.onmobile.training.Account;
import com.onmobile.training.Address;
import com.onmobile.training.Customer;

public class CustomerTest 
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
		Customer customer = (Customer)ctx.getBean("customer");
		System.out.println("Customer Id : " + customer.getCustomerId());
		System.out.println("Customer Name : " + customer.getCustomerName());
		
		Address address = customer.getAddress();
		System.out.println("Location: " + address.getLocation());
		System.out.println("City: " + address.getCity());
		
		List <Account> accounts = customer.getAccounts();
		System.out.println("Accounts Information");
		for(Account acc : accounts)
		{
			System.out.println(acc.getAccountNo() + "\t" + acc.getAccountType() + "\t" + acc.getBalance());
		}
	}
}