package com.onmobile.training;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>
{
	@Override
	public Customer mapRow(ResultSet rs, int rowId) throws SQLException {
		// TODO Auto-generated method stub
		Customer c = new Customer();
		c.setCustomerId(rs.getInt(1));
		c.setCustomerName(rs.getString(2));
		c.setBalance(rs.getDouble(3));
		return c;
	} 
}
