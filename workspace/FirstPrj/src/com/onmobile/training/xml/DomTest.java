package com.onmobile.training.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class DomTest {

	public static void main(String[] args) 
	{

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of employee");
		int no = Integer.parseInt(sc.nextLine());
		String root = "EmployeeList";
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		try 
		{
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			Element rootElement = doc.createElement(root);
			doc.appendChild(rootElement);
			for (int i = 1; i <= no; i++) 
			{
				Element employee = doc.createElement("Employee");
				System.out.println("Enter the empid");
				String empIdValue = sc.nextLine();
				Element empId = doc.createElement("EmployeeId");
				empId.appendChild(doc.createTextNode(empIdValue));
				System.out.println("Enter the Name");
				String empNameValue = sc.nextLine();
				Element empName = doc.createElement("EmployeeName");
				empName.appendChild(doc.createTextNode(empNameValue));
				System.out.println("Enter the desgination: ");
				String designationValue = sc.nextLine();
				Element designation = doc.createElement("designation");
				designation.appendChild(doc.createTextNode(designationValue));
				System.out.println("Enter the salary");
				String salaryValue = sc.nextLine();
				Element salary = doc.createElement("salary");
				salary.appendChild(doc.createTextNode(salaryValue));
				employee.appendChild(empId);
				employee.appendChild(empName);
				employee.appendChild(designation);
				employee.appendChild(salary);
				rootElement.appendChild(employee);
			}
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = null;
			try 
			{
				transformer = transformerFactory.newTransformer();

			}
			catch (TransformerConfigurationException e) 
			{
				e.printStackTrace();
			}
			DOMSource source = new DOMSource(doc);
			try 
			{
				StreamResult result = new StreamResult(new FileOutputStream(
						"empListTest.xml"));
				System.out.println(source);
				transformer.transform(source, result);
			}
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}