package com.onmobile.training.spring.jdbc;

import java.util.List;

import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class CustomerDAO {
	private SimpleJdbcTemplate template;

	public SimpleJdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(SimpleJdbcTemplate template) {
		this.template = template;
	}

	public void addCustomer(Customer c) {
		String sql = "insert into Customer_tbl values(?, ?, ?)";
		template.update(sql, c.getCustomerId(), c.getCustomerName(), c.getBalance());
	}

	public Customer getCustomer(int id) {
		String query = "select * from customer_tbl where customer_id = ?";
		Customer c = template.queryForObject(query, new CustomerRowMapper(), id); // queryForObject is expected to return one row..
		return c;
	}

	public List<Customer> getAllCustomer() {
		String query = "select * from customer_tbl";
		List<Customer> list = template.query(query, new CustomerRowMapper());
		return list;
	}

	public Customer customerDetails(int id) {
		String query = "select c.customer_id , c.customer_name, c.balance , a.address_id, a.location, a.city from customer_tbl as c, address as a where c.customer_id = a.address_id and c.customer_id = ?";
		Customer cust = template.queryForObject(query, new CustomerRowMapper(), id);
		return cust;
	}
}
