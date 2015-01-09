package edu.cksharma.designpatterns.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Employee implements Serializable{
	
	private int employeeId;
	private String employeeName;
	private transient Address address; // let's assume that Address clas is written by someone else.
	//it doesnit implement serializable, then i will make in transient and now override somemethoids... given 
	//below so that i can write it to file....
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Employee(int employeeId, String employeeName) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", address=" + address + "]";
	}	
	
	private void writeObject(ObjectOutputStream out) throws IOException
	{
		out.defaultWriteObject(); // this will write all the non-transient fields of employee into file..
		//deafulwWriteObject writes all non-transient objs. if Address is not made transient then we 
		//will get SerializationExcep. coz Address hasnot implemented Serilizable interface.
		out.writeUTF(address.getLocation());
		out.writeUTF(address.getCity());
	}
	
	private void readObject(ObjectInputStream oin) throws IOException, ClassNotFoundException
	{
		oin.defaultReadObject(); // reads the deafult non-transient members of the employee.;;;
		address = new Address();   
		address.setLocation(oin.readUTF());
		address.setCity(oin.readUTF());
	}
}
