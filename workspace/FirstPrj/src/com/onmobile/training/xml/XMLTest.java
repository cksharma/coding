package com.onmobile.training.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLTest 
{
	public static void main(String[] args) 
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		File f = new File("emplist.xml");
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
					Element e = (Element)node;
					if(e.getLocalName().equals("Employee"))
					{
						processEmployee(e);
					}
				}
			}
		} catch (SAXException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void processEmployee(Element e)
	{
		NodeList empElements = e.getChildNodes();
		for(int i = 0; i < empElements.getLength(); i++)
		{
			Node node = empElements.item(i);
			if(node instanceof Element)
			{
				Element elt = (Element)node;
				System.out.println(elt.getLocalName() + ":" + elt.getTextContent());
			}
		}
	}
}
	