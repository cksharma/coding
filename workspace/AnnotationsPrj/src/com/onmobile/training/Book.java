package com.onmobile.training;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="Book_TBL")
//@IdClass(BookKey.class)

@NamedQuery(name="queryByAuthor", query="select b from Book as b where b.key.author=:author")
public class Book implements Serializable{

	@Column(name="ISBN_CODE")
	private int isbn;
	
	/*&@Column(name="TITLE")
	@Id
	private String title;
	
	@Column(name="AUTHOR_NAME")
	@Id
	private String author;
	*/
	@EmbeddedId
	private BookKey key;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return key.getTitle();
	}
	public void setTitle(String title) {
		key.setTitle(title);
	}
	public String getAuthor() {
		return key.getAuthor();
	}
	public void setAuthor(String author) {
		key.setAuthor(author);
	}
	/*public Book(int isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}
	*/
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int isbn, BookKey key) {
		super();
		this.isbn = isbn;
		this.key = key;
	}	
}
