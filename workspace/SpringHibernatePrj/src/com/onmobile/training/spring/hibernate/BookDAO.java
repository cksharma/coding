package com.onmobile.training.spring.hibernate;

import java.util.List;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class BookDAO 
{
	private HibernateTemplate hibernateTemplate; // what ever the hibernate id we have used it should be the same here..

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public void addBook(Book b)
	{
		hibernateTemplate.save(b); // does entire things, start the transaction, close the session and all works..
	}
	
	public Book getBook(int isbn)
	{
		return hibernateTemplate.get(Book.class, isbn);
	}
	
	public List <Book> getAllBooks()
	{
		return hibernateTemplate.find("from Book");
	}
}
