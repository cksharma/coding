package clientpack;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.onmobile.training.spring.hibernate.Book;
import com.onmobile.training.spring.hibernate.BookDAO;

//psubbhu_in@yahoo.com
//9880372634
//Beginning Hibernate - Apress
//Spring in Action 3.0 - 

public class HibernateTest 
{
	public static void main(String[] args) 
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookDAO dao = (BookDAO)ctx.getBean("bookDAO");
		dao.addBook(new Book(1, "Head First Java", "Kathy Sierra", 450));
		dao.addBook(new Book(2, "Wings of Fire" , "Dr. Abdul Kalam", 150));
		dao.addBook(new Book(3, "Core J2EE Patterns", "Deepak Alur", 500));
		
		System.out.println("Book Added");
		Book book = dao.getBook(1);
		System.out.println("BOOK INFORMATION");
		System.out.println("Book Id : " + book.getIsbn() );
		System.out.println("Book Title : " + book.getTitle());
		System.out.println("Author : " + book.getAuthor());
		System.out.println("Price  :  " + book.getPrice());
		System.out.println();
		System.out.println("ALL BOOKS");
		List <Book> list = dao.getAllBooks();
		for(Book bk : list)
		{
			System.out.println("Book Id : " + bk.getIsbn() );
			System.out.println("Book Title : " + bk.getTitle());
			System.out.println("Author : " + bk.getAuthor());
			System.out.println("Price  :  " + bk.getPrice());
		}
	}
}
