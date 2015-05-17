package com.onmobile.training.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class MyHandler1 extends DefaultHandler  
{
	String ans = "";
	int id = 0;
	String name = "";
	String designation = "";
	double salary = 0;
	
	//List <Employee> lst = new ArrayList <Employee> ();
	
	int max = 0;
	
	@Override
	public void characters(char[] ch, int start, int length) 
			throws SAXException {
		// TODO Auto-generated method stub
		String content = new String(ch, start, length).trim();
		if(content.length() > 0)
		{
			System.out.println("char content: " + content);
		}
	}
	
	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Starting document ");
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ending document ");
	}

	@Override
	public void startElement(String uri, String localName, String qName, // qName stands for qualified name
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("starting element " + localName);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		System.out.println("Ending element " + localName); // use localName only when we have namespace
		//System.out.println("Ending element1 " + qName);
		System.out.println();
	}
}

public class SAXTest
{
	public static void main(String[] args) 
	{
		MyHandler1 handler = new MyHandler1();
		File file = new File("emplist.xml");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		saxFactory.setNamespaceAware(true);
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
	}
}