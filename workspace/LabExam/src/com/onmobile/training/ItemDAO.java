package com.onmobile.training;

import java.io.File;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ItemDAO 
{
	private DataSource dataSource;
	
	public ItemDAO()
	{
		super();
		try
		{
			Context ctx = new InitialContext();
			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB");
		}
		catch(NamingException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean updateItem(int itemId, int quantityToBeAdded)
	{
		boolean ok = false;
		Configuration conf = new Configuration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		
		Session session = factory.openSession();
		
		List <Item> list = session.createQuery("from Item").list();
		
		boolean flag = false;
		
		Item item = null;
		
		for(Item c : list)
		{
			System.out.println("I am here  " + c);
			if(c.getItemId() == itemId)
			{
				item = c;
				
			}
		}
		
		if(item == null)
		{
			throw new ItemNotFoundException("Item not found for this Item ID");
		}
		
		else
		{
			ok = true;
			Transaction tx = session.beginTransaction();
			int currentQuantity = item.getQuantityAvailable();
			item.setQuantityAvailable(currentQuantity + quantityToBeAdded);
			session.update(item);
			tx.commit();
		}
		
		session.close();
		return ok;
	}
	
	public void addItem(int itemId, String itemName, double price)
	{
		try
		{
			Connection con = dataSource.getConnection();
			CallableStatement cst = con.prepareCall("{call add_Item(?,?,?)}");
			
			cst.setInt(1, itemId);
			cst.setString(2, itemName);
			cst.setDouble(3, price);
			
			cst.execute();
			
			System.out.println("Item added");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public void deleteItemTable()
	{
		try
		{
			System.out.println("Hello1");
			Connection con = dataSource.getConnection();
			PreparedStatement pst = con.prepareStatement("delete from item_tbl");
			pst.addBatch();
			pst.executeBatch();
			System.out.println("Hello2");
		}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void parseXML(String file)
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		System.out.println("Hello2");
		File f = new File(file);
		System.out.println();
		try {
			Document doc = builder.parse(f);
			Element elt = doc.getDocumentElement();
			System.out.println(elt.getLocalName());
			NodeList list = elt.getChildNodes();
			for(int i = 0; i < list.getLength(); i++)
			{
				Node node = list.item(i);
				if(node instanceof Element)
				{
					elt = (Element)node;
					if(elt.getLocalName().equals("Item"))
					{
						processItem(elt);
					}
				}
			}
			//itemdao.updateItem(1, 5);
		} catch (SAXException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void processItem(Element elt)
	{
		NodeList empElements = elt.getChildNodes();
		
		String[] ans = new String[3]; 
		int index = 0;
		
		for(int i = 0; i < empElements.getLength(); i++)
		{
			Node node = empElements.item(i);
			if(node instanceof Element)
			{
				elt = (Element)node;
				System.out.println(elt.getLocalName() + ":" + elt.getTextContent());
				ans[index++] = (String) elt.getTextContent();
			}
		}
		int itemId = Integer.parseInt(ans[0]);
		String itemName = ans[1];
		
		double price = Double.parseDouble(ans[2]);
		
		addItem(itemId, itemName, price);
	}
}
