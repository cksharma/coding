
public class Customer {
	int customerId;
	String name;
	double salary;
	public Customer(int customerId, String name, double salary) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name
				+ ", salary=" + salary + "]";
	}
}
