package com.OnlineBookStore.dao;
//data access object

import java.util.List;
import com.OnlineBookStore.Models.*;

public interface BookDao {

	boolean addBook(Book b);
	boolean updateBook(Book b);
	boolean deleteBook(int id);
	int getBookByMaxId();
	boolean uploadBookImageById(String bookImageName);

	List<Book>getAllBook();
	Book getBookById(int id);

	List<Book>getBookByName(String name);

	List<Book>getBookByCategory(String category);
	List<Category>getAllCategory();

	List<Book>getBookByPublisher(String publisher);
	List<Publisher>getAllPublisher();
	
	boolean updateBook1(Book b);


}