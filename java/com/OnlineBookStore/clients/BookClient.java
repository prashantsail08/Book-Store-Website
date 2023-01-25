package com.OnlineBookStore.clients;
import java.util.Scanner;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.impl.BookDaoImpl;
public class BookClient {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		BookDaoImpl bookDaoImpl = new BookDaoImpl();

		System.out.println("1 Add Book");
		System.out.println("2 Update Book");
		System.out.println("3 Delete Book");
		System.out.println("4 ShowAll Book");
		System.out.println("5 Get Book By ID");
		System.out.println("6 Get Book By Name");
		System.out.println("7 Get Book By Category");
		System.out.println("8 Get All Book By Category");
		System.out.println("9 Get Book By Publisher");
		System.out.println("10 Get All Book  Publisher");
		System.out.println("Enter Choice");
		int choice = sc.nextInt();

		switch(choice) 
		{
		case 1:
			Book book = new Book();
			System.out.println("Enter Book Name");
			String bookName = sc.next();
			book.setBookName(bookName);

			System.out.println("Enter Book Auther");
			String bookAuthor = sc.next();
			book.setBookAuthor(bookAuthor);

			System.out.println("Enter Book Price");
			Double bookPrice = sc.nextDouble();
			book.setBookPrice(bookPrice);

			System.out.println("Enter Book Publisher");
			String bookPublisher = sc.next();
			book.setBookPublisher(bookPublisher);

			System.out.println("Enter Book Quantity");
			int bookQuantity = sc.nextInt();
			book.setBookQuantity(bookQuantity);

			System.out.println("Enter Book Category");
			String bookCategory = sc.next();
			book.setBookCategory(bookCategory);

			System.out.println("Enter Book Img");
			String bookImg = sc.next();
			book.setBookImg(bookImg);

			System.out.println("Enter Book Desc");
			String bookDesc = sc.next();
			book.setBookDesc(bookDesc);			

			bookDaoImpl.addBook(book);

			break;

		case  2:
			break;
		case 3:
			System.out.println("Enter Book ID= ");
			int id=sc.nextInt();
			
			Book book1 = new Book();
			book1.setBookId(id);
			bookDaoImpl.deleteBook(id);
			break;
			
		case 4:
			System.out.println("Show All Book are");
			bookDaoImpl.getAllBook();
			break;
			
		case 5:
			System.out.println("Get Book By ID");
			int id1 =sc.nextInt();
			Book book2 = new Book();
			book2.setBookId(id1);
			bookDaoImpl.getBookById(id1);
			
			break;
		case 6:
			System.out.println("Get Book By Name");
			String name =sc.next();
			Book book3 = new Book();
			book3.setBookName(name);
			bookDaoImpl.getBookByName(name);
			break;
		case 7:
			System.out.println("Get Book By Category");
			String category =sc.next();
			Book book4 = new Book();
			book4.setBookCategory(category);
			bookDaoImpl.getBookByCategory(category);
			break;
		case 8:
			System.out.println("Get Book By all Category");
			bookDaoImpl.getAllCategory();
			break;
		case 9:
			System.out.println("Get Book By Publisher");
			String publisher =sc.next();
			Book book5 = new Book();
			book5.setBookCategory(publisher);
			bookDaoImpl.getBookByPublisher(publisher);
			break;
		case 10:
			System.out.println("Get Book All Publisher");
			bookDaoImpl.getAllPublisher();
			break;
		}


	}
}
