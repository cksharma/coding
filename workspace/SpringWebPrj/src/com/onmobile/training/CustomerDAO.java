package com.onmobile.training;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CustomerDAO 
{
	private SimpleJdbcTemplate template;

	public SimpleJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}
	
	public Customer getCustomer(int id)
	{
		String query = "select * from customer_tbl where customer_id = ?";
		Customer c = template.queryForObject(query, new CustomerRowMapper(), id); // queryForObject is expected to return one row..
		return c;
	}
}
