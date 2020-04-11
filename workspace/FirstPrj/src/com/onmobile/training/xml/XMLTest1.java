package com.onmobile.training.xml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class Employee
{
	int employeeId;
	String name;
	String designation;
	double salary;
	public Employee(int employeeId, String name, String designation,
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
}

class MyHandler extends DefaultHandler 
{

	String ans = "";
	int id = 0;
	String name = "";
	String designation = "";
	double salary = 0;
	
	List <Employee> lst = new ArrayList <Employee> ();
	
	int max = 0;
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch, start, length);
		if(content.trim().length() > 0)
		{
			System.out.println("Content : " + content);
		}
		
		if(ans.equals("name"))
		{
			name = content;
		}
		if(ans.equals("designation"))
		{
			designation = content;
			
		}
		if(ans.equals("salary"))
		{
			salary = Double.parseDouble(content);
		}
		if(ans.equals("EmployeeId"))
		{
			id = Integer.parseInt(content);
		}
		
		if(ans.equals("salary") && max < Integer.parseInt(content))
		{
			max = Math.max(max, Integer.parseInt(content));
			lst.clear();
			System.out.println("Hello **************");
			lst.add(new Employee(id, name, designation, salary));
		}
		else if(ans.equals("salary") && max == Integer.parseInt(content))
		{
			lst.add(new Employee(id, name, designation, salary));
			
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Starting document ");
		ans = "";
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ending document ");
		ans = "";
	}

	@Override
	public void startElement(String uri, String localName, String qName, // qName stands for qualified name
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("starting element " + qName);
		
		ans = qName;
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ending element " + qName);
		ans = "";
	}

}

public class XMLTest1
{
	public static void main(String[] args) 
	{
		MyHandler handler = new MyHandler();
		File file = new File("first.xml");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = saxFactory.newSAXParser();
			parser.parse(file, handler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(handler.max);
		System.out.println(handler.lst);
	}
}