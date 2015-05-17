package data.mining;

public class Employee implements Comparable
{
	int employeeId;
	String employeeName;
	String designation;
	double salary;
	
	public Employee(int employeeId, String employeeName, String designation, double salary) 
	{
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.designation = designation;
		this.salary = salary;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Employee)
		{
			Employee e = (Employee)o;
			return employeeName.compareTo(e.employeeName);
		}
		return 0;
	}

	
	@Override
	public String toString() 
	{
		return employeeId + " " + employeeName + "  " + designation + "  " + salary;
	}
	
	
}
