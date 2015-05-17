package com.onmobile.training;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SalesDAO 
{
	
	private DataSource dataSource;
	
	public Configuration conf;
	
	public SalesDAO()
	{
		super();
		try
		{
			conf = new Configuration().configure();
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean addSales(int salesId, int itemId, int quantitySold)
	{
		boolean ok = false;
		try 
		{
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("select * from item_tbl where item_id = " + itemId);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next())
			{
				int quantityAvailable = rs.getInt(4);
				
				if(quantityAvailable >= quantitySold)
				{
					pst = con.prepareStatement("update item_tbl set quantity_available = ? where item_id = " + itemId);
					pst.setInt(1, (quantityAvailable - quantitySold));
					pst.executeUpdate();
					
					pst = con.prepareStatement("insert into sales_tbl values(?, ?, ?, ?)");
					
					pst.setInt(1, salesId);
					pst.setDate(2, new java.sql.Date(System.currentTimeMillis()));
					pst.setInt(3, itemId);
					pst.setInt(4, quantitySold);
					pst.executeUpdate();
					
					System.out.println("Ho gaya ");
					ok = true;
				}
				
				else
				{
					ok = false;
					throw new InsufficientItemException("Item Insufficient");
				}
			}
			else
			{
				ok = false;
				throw new ItemNotFoundException("Item Not Found");
			}
			
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		return ok;
	}
	
	public List <Sales> getSalesByDate(Date d)
	{
		String str = d.toString();
		String[] ans = str.split("-");
		System.out.println(d);
		int year = d.getYear();
		int month = d.getMonth();
		int day = d.getDate();
		
		System.out.println(year + "  " + month + "  " + day);
		
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		List <Sales> list = session.createQuery("from Sales").list();
		
		int cnt = list.size() - 1;
		
		List <Sales> list1 = new ArrayList <Sales> ();
		
		while(cnt >= 0)
		{
			Sales sales = (Sales) list.get(cnt);
			Date d1 = sales.getSalesTime();
			int year1 = d1.getYear() + 1900;
			int month1 = d1.getMonth() + 1;
			int day1 = d1.getDate();
			if(year1 == year && month == month1 && day == day1)
			{
				System.out.println(sales);
				list1.add(sales);
			}
			cnt--;
			System.out.println("DATE " + year1 + "  " + month1 + "  " + day1);
		}
		session.close();
		return list1;
	}
}
