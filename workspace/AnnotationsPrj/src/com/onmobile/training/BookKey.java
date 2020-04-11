package com.onmobile.training;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class BookKey implements Serializable{
	private String title;
	private String author;
	
	public String getTitle() {
		return title;
	}	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public BookKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookKey(String title, String author) {
		super();
		this.title = title;
		this.author = author;
	}
	@Override
	public int hashCode() {
		return title.hashCode() ^ author.hashCode();
	}
	@Override
	public boolean equals(Object o) {
		boolean eqFlag = false;
		if(o instanceof BookKey)
		{
			BookKey key=(BookKey)o;
			if(title.equals(key.title) && author.equals(key.author))
			{
				eqFlag = true;
			}
		}
		return eqFlag;
	}
	
}
