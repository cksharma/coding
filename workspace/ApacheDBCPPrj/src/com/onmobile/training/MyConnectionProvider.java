package com.onmobile.training;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.hibernate.HibernateException;
import org.hibernate.cfg.Environment;
import org.hibernate.connection.ConnectionProvider;

public class MyConnectionProvider implements ConnectionProvider{

	private BasicDataSource dataSource;
	
	
	@Override
	public void close() throws HibernateException {
		// TODO Auto-generated method stub
		try {
			dataSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void closeConnection(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		con.close();
	}

	@Override
	public void configure(Properties prop) throws HibernateException {
		// TODO Auto-generated method stub
		String driverClass = prop.getProperty(Environment.DRIVER);
		String connectionUrl = prop.getProperty(Environment.URL);
		String userName = prop.getProperty(Environment.USER);
		String password = prop.getProperty(Environment.PASS);
		
		int maxActive = 100;
		Properties dsProperties = new Properties();
		dsProperties.setProperty("driverClassName", driverClass);
		dsProperties.setProperty("url", connectionUrl);
		dsProperties.setProperty("username", userName);
		dsProperties.setProperty("password", password);
		dsProperties.setProperty("maxActive", "100");
		
		try {
			dataSource = (BasicDataSource) BasicDataSourceFactory.createDataSource(dsProperties);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("data source created");
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return dataSource.getConnection();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}
}
