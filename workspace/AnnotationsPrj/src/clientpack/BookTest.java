package clientpack;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.onmobile.training.Book;
import com.onmobile.training.BookKey;

public class BookTest
{
	public static void main(String[] args) 
	{
		Configuration conf =new AnnotationConfiguration().configure();
		SessionFactory factory = conf.buildSessionFactory();
		Session session = factory.openSession();
		Book b1 = new Book(1211, new BookKey("Core Java", "Deepak Alur"));
		Book b2 = new Book(12112, new BookKey("Let Us C", "Yashwant Kanetkar"));
		Book b3 = new Book(12112, new BookKey("Head First Java", "Kathy Sierra"));
		
		/*Set <Book> bookList = new HashSet <Book> ();
		bookList.add(b1);
		bookList.add(b2);
		BookStore bkStore = new BookStore(1, "Book Paradise");
		bkStore.setBooks(bookList);
		*/
		
		/*Transaction tx =session.beginTransaction();
		session.save(b1);
		session.save(b2);
		session.save(b3);
		
		tx.commit();
		*/
		
		/*
		 
		List <Book> list = query.list();
		for(Book b : list)
		{
			System.out.println(b.getIsbn() + "\t" + b.getTitle() + "\t" + b.getAuthor());
		}
		*/
		
		/*String hql = "select b.isbn, b.key from Book as b where b.isbn=:a";
		query = session.createQuery(hql);
		query.setParameter("a", 1211);
		List <Object[]> listArray = query.list();
		for(Object[] arr : listArray)
		{
			System.out.println("Isbn : " + arr[0]);
			BookKey b = (BookKey)arr[1];
			System.out.println("Title " + b.getTitle());
			System.out.println("Author " + b.getAuthor());
		}
		*/
		/*
		String sql = "select * from book_tbl where isbn_code =(select max(isbn_code) from book_tbl)";
		Query query = session.createSQLQuery(sql);
		List <Object[]> list = query.list();
		Object[] b = list.get(0);
		
		System.out.println(b[0] + "\t" + b[1] + "\t" + b[2]);		
		*/
		Query query = session.getNamedQuery("queryByAuthor");
		query.setParameter("author" , "Yashwant Kanetkar");
		List <Book> list = query.list();
		for(Book b : list)
		{
			System.out.println(b.getIsbn() + "\t" + b.getTitle() + "\t" + b.getAuthor());
		}
	}
}