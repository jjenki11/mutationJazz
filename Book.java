import java.util.ArrayList;

class Book
{
	private String bookTitle;
	private String serialNumber;
	private String authorName;
	private String publisher;
	private int publishedYear;
	private int bookQuantity;

	public Book(String bookTitle, String serialNumber, String authorName, String publisher, int publishedYear)
	{
		this.bookTitle = bookTitle;
		this.serialNumber = serialNumber;
		this.authorName = authorName;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
	}

	public String getBookTitle()
	{
		return this.bookTitle;
	}

	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}

	public String getSerialNumber()
	{
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber)
	{
		this.serialNumber = serialNumber;
	}

	public String getAuthorName()
	{
		return this.authorName;
	}

	public void setAuthorName(String authorName)
	{
		this.authorName = authorName;
	}

	public String getPublisher()
	{
		return this.publisher;
	}

	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}

	public int getBookQuantity()
	{
		return this.bookQuantity;
	}

	public void setBookQuantity(int bookQuantity)
	{
		this.bookQuantity = bookQuantity;
	}

	public int getPublishedDate()
	{
		return this.publishedYear;
	}

	public void setPublishedDate(int publishedYear)
	{
		this.publishedYear = publishedYear;
	}	
}

//class LibraryActions
//{
//	private final ArrayList<Book> books;
//
//	public LibraryActions(ArrayList<Book> books)
//	{
//		this.books = books;
//	}
//
//	public String insertSingleBook(Book singleBook)
//	{
//		boolean inLibrary = isAlreadyInLibrary(singleBook);
//		if(inLibrary)
//		{
//			checkInBook(singleBook);
//		}
//		else
//		{
//			this.validate(singleBook);
//			singleBook.setBookQuantity(1);
//			books.add(singleBook);
//		}
//		return singleBook.getSerialNumber();
//	}
//
//	public boolean isBookAvailable(Book book)
//	{
//		this.validate(book);
//		String serialNumber = book.getSerialNumber();
//
//		for(Book b : books)
//		{
//			if(serialNumber.equals(b.getSerialNumber()) && b.getBookQuantity() > 0)
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public Book checkoutBook(Book book)
//	{
//		this.validate(book);
//		String serialNumber = book.getSerialNumber();
//
//		for(Book b : books)
//		{
//			if(serialNumber.equals(b.getSerialNumber()))
//			{
//				int quantity = book.getBookQuantity();
//				if(quantity == 0)
//				{
//					return null;
//				}
//				else
//				{
//					b.setBookQuantity(quantity-1);
//				}
//			}
//		}
//		return book;
//	}
//
//	public boolean checkInBook(Book book)
//	{
//		this.validate(book);
//		String serialNumber = book.getSerialNumber();
//
//		for(Book b : books)
//		{
//			if(serialNumber.equals(b.getSerialNumber()))
//			{
//				int quantity = b.getBookQuantity();
//				b.setBookQuantity(quantity+1);
//				return true;
//			}
//		}
//		return false;
//	}
//	
//	public Book searchForBookByAuthorsName(String authorsName)
//	{
//		if(authorsName == null)
//		{
//			throw new NullPointerException();
//		}
//		for(Book book : books)
//		{
//			if (authorsName.equalsIgnoreCase(book.getAuthorName()))
//			{	
//				return book;
//			}
//		}
//		return null;
//	}
//	
//	public Book searchForBookByBookTitle(String bookTitle)
//	{
//		if(bookTitle == null)
//		{
//			throw new NullPointerException();
//		}
//		for(Book book : books)
//		{
//			if (bookTitle.equalsIgnoreCase(book.getBookTitle()))
//			{	
//				return book;
//			}
//		}
//		return null;
//	}
//	
//	public Book searchBySerialNumber(String serialNumber)
//	{
//		if(serialNumber == null)
//		{
//			throw new NullPointerException();
//		}
//		for(Book book : books)
//		{
//			if(serialNumber.equals(book.getSerialNumber()))
//			{
//				return book;
//			}
//		}
//		return null;
//	}
//	
//	public StringBuilder showAllBooks()
//	{
//		StringBuilder allBooks = new StringBuilder();
//		for (Book book : books)
//		{
//			allBooks.append("Serial Number: " +  book.getSerialNumber() + "\nBook Title: " +  book.getBookTitle() 
//			+ "\nAuthor's Name: " +  book.getAuthorName() + "\nPublisher: " + book.getPublisher() + "\nBooks Left: " + book.getBookQuantity()
//			+ "\nYear Published: " + book.getPublishedDate());
//		}
//		
//		return allBooks;
//	}
//	
//	public StringBuilder allBooksByYear(int publishedYear)
//	{
//		StringBuilder allBooksByYear = new StringBuilder();
//		for (Book book : books)
//		{
//			if(book.getPublishedDate() == publishedYear)
//			{
//				allBooksByYear.append("Serial Number: " +  book.getSerialNumber() + "\nBook Title: " +  book.getBookTitle() 
//				+ "\nAuthor's Name: " +  book.getAuthorName() + "\nPublisher: " + book.getPublisher() + "\nBooks Left: " + book.getBookQuantity()
//				+ "\nYear Published: " + book.getPublishedDate());
//			}	
//		}
//		return allBooksByYear;
//	}
//
//	/////////////////////////////////////////HELPER METHODS/////////////////////////////////////////
//	public boolean isAlreadyInLibrary(Book singleBook)
//	{
//		for(Book c : books)
//		{
//			if(singleBook.getSerialNumber().equals(c.getSerialNumber()))
//			{
//				return true;
//			}
//		}
//		return false;
//	}
//
//	public boolean validate(Book book)
//	{
//		if (book.getSerialNumber() == null || book.getBookTitle() == null || book.getAuthorName() == null)
//		{
//			throw new NullPointerException();
//		}
//		return true;
//	}
//}
