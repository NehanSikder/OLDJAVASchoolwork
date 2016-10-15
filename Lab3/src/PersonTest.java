//smm7cb Scott Miller Ans2ur Arham Sikder
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PersonTest {
	
	private Person p;
	private Book b;
	private Book b2;
	private Book x;
	private Book x2;
	
	@Before
	public void setUp() {
		this.p = new Person("Alex", 14);  // Create a person
		this.b = new Book("some title", "some author");  // Create a Book
		this.b2 = new Book("HarryPotter", "JK");
		this.x = new Book("some title", "some author");  // Create a Book
		this.x2 = new Book("Lord of the rings", "Tolkien");
	}
	
	
	@Test(timeout = 100)
	public void testAddBook() {
		assertTrue(p.addBook(b));  // Does addBook() return true?
		ArrayList<Book> readList = p.getRead();  // Get Person p's ArrayList of Books (read)
		assertTrue(readList.contains(b));  // Is Book b contained in this ArrayList?
	}
	
	@Test(timeout = 100)
	public void testAddTwoBook() {
		assertTrue(p.addBook(b));  // Does addBook() return true?
		ArrayList<Book> readList = p.getRead();  // Get Person p's ArrayList of Books (read)
		assertTrue(p.addBook(b2));
		assertTrue(readList.size() == 2);  // Is Book b contained in this ArrayList?
	}
	
	@Test(timeout = 100)
	public void testEqualBooks() {
		assertTrue(p.addBook(b));  // Does addBook() return true?
		assertFalse(p.addBook(x));
	}
	
	@Test(timeout = 100)
	public void testForget() {
		p.addBook(b);
		p.addBook(b2);
		ArrayList<Book> readList = p.getRead();  // Get Person p's ArrayList of Books (read)
		assertTrue(p.forgetBook(b2)); //should return true
		assertTrue(readList.size() == 1); 
		assertFalse(p.forgetBook(x2)); //should return false
	}
	
	public int practiceTest(int x){
		x = 0;
		assertTrue(x ==0);
		return x;
		
		
	}

}
