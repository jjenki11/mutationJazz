import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.ArrayList;

public class LibraryTests 
{
	private LibraryActions libActions;
	private ArrayList<Book> books;
	private Book book1;
	private Book book2;
	private Book book3;
	private Book book4;
	private Book book5;
	private Book book6;
	private Book book7;
	private Book book8;
	
	@Before
	public void inputBooks()
	{	
		book1 = new Book("Peak", "12a347Pea", "Anders Ericcson", "Bell", 2014);
		book2 = new Book("The Hunger Games", "12a348Hun", "Suzanne Collins", "Donnelly and Sons Company", 2007);
		book3 = new Book("A Wrinkle in Time", "12a349Wri", "Madeleine L'Engle", "Donnelly and Sons Company", 2007);
		book4 = new Book("To Kill a Mockingbird", "12a350Tkm", "Harper Lee", "Harper Perennial Modern Classics", 2006);
		book5= new Book("The Book Thief", "12a351Tbt", "Markus Zusak", "Alfred A. Knopf", 2005);
		book6 = new Book("The Chronicles of Narnia", "12a352CoN", "C.S. Lewis", "HarperCollins", 1956);
		book7 = new Book("1000 Arabian Nights", "12a353ArN", null, "Donnelly and Sons Company", 2007);
		book8 = null;
		books = new ArrayList<>();
		libActions = new LibraryActions(books);
	}
	
	@Test
	public void insertSingleBook_ValidBook_ValidSerialNumber()
	{
		String serialNumberOfActual = libActions.insertSingleBook(book1);
		
		assumeTrue(serialNumberOfActual.equals("12a347Pea"));
		assertEquals(book1, libActions.searchBySerialNumber(serialNumberOfActual));	
	}
	
	@Test
	(expected = NullPointerException.class)
	public void insertSingleBook_InvalidBook_NPEThrown()
	{
		libActions.insertSingleBook(book7);
	}
	
	@Test
	(expected = NullPointerException.class)
	public void insertSingleBook_NullValue_ValidSerialNumber()
	{
		libActions.insertSingleBook(book8);
	}
	
	@Test
	public void isBookAvailable_AvailableBook_True()
	{
		libActions.insertSingleBook(book1);
		
		assertTrue(libActions.isBookAvailable(book1));	
	}
	
	@Test
	public void isBookAvailable_UnavailableBook_False()
	{
		libActions.insertSingleBook(book1);
		assertFalse(libActions.isBookAvailable(book2));
	}
	
	@Test
	(expected = NullPointerException.class)
	public void isBookAvailable_BookWithoutSerialNumber_ValidSerialNumber()
	{
		libActions.insertSingleBook(book7);
	}
	
	@Test
	public void checkoutBook_AvailableBook_True()
	{
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book1);
		Book peakBook = libActions.checkoutBook(book1);
		Book peakBook2 = libActions.checkoutBook(book1);
		int quant = peakBook.getBookQuantity();
		
		assertEquals(quant, 0);
		assertEquals(book1, peakBook);
	}
	
	@Test
	public void checkoutBook_UnavailableBook_NullValue()
	{		
		libActions.insertSingleBook(book5);
		libActions.checkoutBook(book5);
		Book secondCheckoutNull = libActions.checkoutBook(book5);
		assertNull(secondCheckoutNull);	
	}
	
	@Test
	(expected = NullPointerException.class)
	public void checkoutBook_NullBook_NPEThrown()
	{
		libActions.checkoutBook(book8);
	}
	
	@Test
	public void checkInBook_ValidBook_True()
	{
		libActions.insertSingleBook(book1);
		assumeTrue(libActions.checkInBook(book1));
		
		Book validCheckout = libActions.checkoutBook(book1);
		assertEquals(validCheckout.getBookQuantity(), book1.getBookQuantity());	
	}
	
	@Test
	public void checkInBook_InvalidBook_False()
	{		
		libActions.insertSingleBook(book5);
		assertFalse(libActions.checkInBook(book6));
	}
	
	@Test
	(expected = NullPointerException.class)
	public void checkInBook_NullBook_NPEThrown()
	{
		libActions.checkInBook(book8);
	}
	
	@Test
	public void searchForBookByAuthorsName_ValidAuthorsName_ReturnValidBook()
	{
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book2);
		Book bookSearched = libActions.searchForBookByAuthorsName("Anders Ericcson");
		
		assertEquals(bookSearched, book1);	
	}
	
	@Test
	public void searchForBookByAuthorsName_AllCapsAuthorsName_BookFound()
	{		
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book2);
		Book bookSearched = libActions.searchForBookByAuthorsName("ANDERS ERICCSON");
		
		assertEquals(bookSearched, book1);
	}
	
	@Test
	public void searchForBookByAuthorsName_InvalidAuthorsName_NullValueForNoBookFound()
	{		
		libActions.insertSingleBook(book1);
		Book bookSearchedNull = libActions.searchForBookByAuthorsName("Invalid Author");
		
		assertEquals(bookSearchedNull, null);	
	}
	
	@Test
	(expected = NullPointerException.class)
	public void searchForBookByAuthorsName_NullAuthor_NPEThrown()
	{
		libActions.searchForBookByAuthorsName(null);
	}
	
	@Test
	public void searchForBookByBookTitle_ValidBook_True()
	{
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book2);
		Book bookSearched = libActions.searchForBookByBookTitle("Peak");
		
		assertEquals(bookSearched, book1);	
	}
	
	@Test
	public void searchForBookByBookTitle_ValidBookInAllCaps_True()
	{
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book2);
		Book bookSearched = libActions.searchForBookByBookTitle("PEAK");
		
		assertEquals(bookSearched, book1);	
	}
	
	@Test
	public void searchForBookByBookTitle_InvalidName_NullValue()
	{		
		libActions.insertSingleBook(book1);
		Book bookSearchedNull = libActions.searchForBookByBookTitle("Invalid Title");
		
		assertEquals(bookSearchedNull, null);	
	}
	
	@Test
	(expected = NullPointerException.class)
	public void searchForBookByBookTitle_NullBook_NPEThrown()
	{
		libActions.searchForBookByBookTitle(null);
	}
	
	@Test
	public void searchBySerialNumber_ValidBook_True()
	{
		libActions.insertSingleBook(book1);
		libActions.insertSingleBook(book2);
		Book bookSearched = libActions.searchBySerialNumber("12a347Pea");
		
		assertEquals(bookSearched, book1);	
	}
	
	@Test
	public void searchBySerialNumber_InvalidCapitalNumbers_NullValue()
	{		
		libActions.insertSingleBook(book1);
		Book bookSearchedNull = libActions.searchBySerialNumber("12a347PEA");
		
		assertEquals(bookSearchedNull, null);	
	}
	
	@Test
	public void searchBySerialNumber_InvalidName_NullValue()
	{		
		libActions.insertSingleBook(book1);
		Book bookSearchedNull = libActions.searchBySerialNumber("Invalid Title");
		
		assertEquals(bookSearchedNull, null);	
	}
	
	@Test
	(expected = NullPointerException.class)
	public void searchBySerialNumber_NullBook_NPEThrown()
	{
		libActions.searchBySerialNumber(null);
	}
	
	@Test
	public void showAllBooks_OneBookInserted_OneBookListReturned()
	{		
		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append("Serial Number: 12a347Pea" + "\nBook Title: Peak" +  "\nAuthor's Name: Anders Ericcson" + "\nPublisher: Bell" + "\nBooks Left: 1" + "\nYear Published: 2014");
		libActions.insertSingleBook(book1);
		
		assertEquals(expectedResult.toString(), libActions.showAllBooks().toString());	
	}
	
	@Test
	public void allBooksByYear_BooksPublishedIn2007_StringOfBookListReturned()
	{		
		StringBuilder expectedResult = new StringBuilder();
		expectedResult.append("Serial Number: 12a348Hun" + "\nBook Title: The Hunger Games" +  "\nAuthor's Name: Suzanne Collins" + "\nPublisher: Donnelly and Sons Company" + "\nBooks Left: 1" + "\nYear Published: 2007");
		expectedResult.append("Serial Number: 12a349Wri" + "\nBook Title: A Wrinkle in Time" +  "\nAuthor's Name: Madeleine L'Engle" + "\nPublisher: Donnelly and Sons Company" + "\nBooks Left: 1" + "\nYear Published: 2007");
		libActions.insertSingleBook(book2);
		libActions.insertSingleBook(book3);
		
		assertEquals(expectedResult.toString(), libActions.allBooksByYear(2007).toString());	
	}	
}
