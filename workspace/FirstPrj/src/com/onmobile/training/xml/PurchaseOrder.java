package com.onmobile.training.xml;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
class Order{
	int orderId;
	int itemId;
	int qtyRequired;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getQtyRequired() {
		return qtyRequired;
	}
	public void setQtyRequired(int qtyRequired) {
		this.qtyRequired = qtyRequired;
	}
	public Order(int orderId, int itemId, int qtyRequired) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.qtyRequired = qtyRequired;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
class PurchaseHandler extends DefaultHandler{
	String element="";
	List<Order> list= new ArrayList<Order>();
	Order o=null;
	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {

	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		element=localName;
		System.out.println(element);
		if(element.equals("Order")){
			o=new Order();
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(localName.equals("Order")){
			list.add(o);
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		String content = new String(ch, start, length).trim();
		if(content.length()>0){
			if(element.equals("orderId")){
				o.setOrderId(Integer.parseInt(content));
			}
			if(element.equals("itemId")){
				o.setItemId(Integer.parseInt(content));
			}
			if(element.equals("qtyRequired")){
				o.setQtyRequired(Integer.parseInt(content));
			}
		}
	}
	
}

public class PurchaseOrder {

	public static void main(String[] args) {
		PurchaseHandler purcHand=new PurchaseHandler();
		File file = new File("Order.xml");
		SAXParserFactory saxFactory = SAXParserFactory.newInstance();
		saxFactory.setNamespaceAware(true);
		try {
			SAXParser parser = saxFactory.newSAXParser();
			parser.parse(file, purcHand);
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "root");
			Statement st=con.createStatement();
			double price=0;
			System.out.println("Entering");
			for(Order q:purcHand.list){
				System.out.println(q.getItemId());
				PreparedStatement pst;
				ResultSet rs=st.executeQuery("select * from item where item_id="+q.getItemId());
				if(rs.next()){
					price=rs.getDouble(3);
					rs=st.executeQuery("select * from stock where item_id="+q.getItemId()+" and qty_available>="+q.getQtyRequired());
					if(rs.next()){
						st.executeUpdate("update stock set qty_available=qty_available-"+q.getQtyRequired()+" where item_id="+q.getItemId());
						pst=con.prepareStatement("insert into executedorders values(?,?,?)");
						pst.setInt(1,q.getOrderId());
						pst.setInt(2, q.getItemId());
						pst.setDouble(3, (q.getQtyRequired()*price));
					}
					else{
						pst=con.prepareStatement("insert into rejectedorders values(?,?,?)");
						pst.setInt(1,q.getOrderId());
						pst.setInt(2, q.getItemId());
						pst.setString(3, "The quantity required is not available");
					}
				}
				else{
					pst=con.prepareStatement("insert into rejectedorders values(?,?,?)");
					pst.setInt(1,q.getOrderId());
					pst.setInt(2, q.getItemId());
					pst.setString(3, "The item is not available");
				}
				pst.executeUpdate();
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
