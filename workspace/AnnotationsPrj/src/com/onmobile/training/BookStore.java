package com.onmobile.training;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="BookStore_TBL")
public class BookStore implements Serializable{
	
	@Id
	@Column(name="BOOK_STORE_ID")
	private int bookStoreId;
	
	@Column(name="BOOK_STORE_NAME")
	private String bookStoreName;
	
	@OneToMany(cascade={javax.persistence.CascadeType.ALL})
	@JoinColumn(name="book_store")
	private Set<Book> books;
	
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	public int getBookStoreId() {
		return bookStoreId;
	}
	public void setBookStoreId(int bookStoreId) {
		this.bookStoreId = bookStoreId;
	}
	public String getBookStoreName() {
		return bookStoreName;
	}
	public void setBookStoreName(String bookStoreName) {
		this.bookStoreName = bookStoreName;
	}
	public BookStore(int bookStoreId, String bookStoreName) {
		super();
		this.bookStoreId = bookStoreId;
		this.bookStoreName = bookStoreName;
	}
	public BookStore() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
