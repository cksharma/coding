package com.onmobile.training.xml;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

class Employee1
{
	int employeeId;
	String name;
	String designation;
	double salary;
	public Employee1(int employeeId, String name, String designation,
			double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.designation = designation;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name
				+ ", designation=" + designation + ", salary=" + salary + "]";
	}
	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public String getName() {
		return name;
	}
	public String getDesignation() {
		return designation;
	}
	public double getSalary() {
		return salary;
	}
	
}


public class XMLTest2 
{
	static Connection con;
	static PreparedStatement pst;
	
	public static void main(String[] args) 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root"); 
			pst = con.prepareStatement("insert into employee values(?, ?, ?, ?)");
		
			DocumentBuilder domBuilder = factory.newDocumentBuilder();
			File file = new File("first.xml");
			Document doc = domBuilder.parse(file);
			Element element = doc.getDocumentElement();
			System.out.println("Root element " + element.getTagName());
			NodeList list = element.getChildNodes();
			int count = 1;
			for(int i = 0; i < list.getLength(); i++)
			{
				Node node = list.item(i);
				//System.out.println("1");
				if(node instanceof Element)
				{
					Element elt = (Element)node;
					if(elt.getTagName().equals("Employee"))
					{
						System.out.println("Employee " + count);
						Employee1 e1 = processEmployee(elt);
						pst.setInt(1, e1.getEmployeeId());
						pst.setString(2, e1.getName());
						pst.setString(3, e1.getDesignation());
						pst.setDouble(4, e1.getSalary());
						pst.addBatch();
						count++;
					}
				}
				
			}
			pst.executeBatch();
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static Employee1 processEmployee(Element elt)
	{
		NodeList list = elt.getChildNodes();
		
		int id = 0; String name = ""; String designation = ""; double salary = 0.;
		for(int i = 0; i < list.getLength(); i++)
		{
			Node node = list.item(i);
			if(node instanceof Element)
			{
				Element e = (Element)node;
				System.out.println(e.getTagName() + "=" + e.getTextContent());
				if(e.getTagName().equals("EmployeeId"))
				{
					id = Integer.parseInt(e.getTextContent());
				}
				if(e.getTagName().equals("name"))
				{
					name = e.getTextContent();
				}
				if(e.getTagName().equals("designation"))
				{
					designation = e.getTextContent();
				}
				if(e.getTagName().equals("salary"))
				{
					salary = Double.parseDouble(e.getTextContent());
				}
			}
		}
		return new Employee1(id, name, designation, salary);
			
	}
}
