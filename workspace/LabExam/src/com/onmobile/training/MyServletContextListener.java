package com.onmobile.training;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MyServletContextListener implements ServletContextListener {
	
	@Override
	public void contextDestroyed(ServletContextEvent e) {
		
	}
  
	public void contextInitialized(ServletContextEvent e) 
	{
		// TODO Auto-generated method stub
		ServletContext ctx = e.getServletContext();
		String file = ctx.getInitParameter("ItemsFile");
		System.out.println(file);
		System.out.println("*********Context Attribute Created************");
		
		ItemDAO itemdao = new ItemDAO();
		
		//DELETING THE PREVIOUS RECORDS
		itemdao.deleteItemTable();	
		
		//NOW PARSING THE XML FILE
		itemdao.parseXML(file);
		
		//SalesDAO salesdao = new SalesDAO();
		
		//SALES DOING
		//salesdao.addSales(1, 1, 2);
		
		
	}
	
	
}