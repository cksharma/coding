package com.onmobile.training;
import java.util.*;

public class CustomerDetails 
{
	private Map <Integer, Customer> map;
	
	public CustomerDetails()
	{
		
	}

	public Map<Integer, Customer> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Customer> map) {
		this.map = map;
	}
	
	public Customer getCustomerDetails(int id)
	{
		return map.get(id);
	}
}
