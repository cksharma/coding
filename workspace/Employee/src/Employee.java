public class Employee {
	
	private String number;
	private int hours;
	private int rate;
	private int pay;
	private String name;
	private String department;
	private String emailId;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		if(number.length() == 9)
			this.number = number;
		else
			throw new InvalidEmployeeNumberException("Employee Number has to be 9 characters long");
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		if(rate >= 0)
			this.rate = rate;
		else 
			throw new RateNegativeException("Rate cannot be negative");
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		if(EmailValidator.isValidEmailId(emailId))
			this.emailId = emailId;
		else
			throw new InvalidEmailIdException("Email ID has to be name@domainname e.g.  example@gmail.com");
	}	
}

