package com.onmobile.training;

import java.io.Serializable;

public class Name implements Serializable{
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
		
	public Name(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Name() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int hashCode()
	{
		return firstName.hashCode() ^ lastName.hashCode();	
	}
	
	public boolean equals(Object o)
	{
		boolean equalsFlag = false;
		if(o instanceof Name)
		{
			Name n1 = (Name) o;
			if(firstName.equals(n1.firstName) && lastName.equals(n1.lastName))
			{
				equalsFlag = true;
			}
		}
		return equalsFlag;
	}	
}
