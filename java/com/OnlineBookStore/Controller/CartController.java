package com.OnlineBookStore.Controller;

import java.io.IOException;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Cart;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.OnlineBookStore.dao.CartDao;
@WebServlet("/cartcontroller")
public class CartController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action = request.getParameter("action");
		CartDao cartDao = ObjectFactory.getCartDaoInstance();
		BookDao bookDao = ObjectFactory.getBookDaoInstance(); 

		if(action.equalsIgnoreCase("addCart"))
		{
			int bookId = Integer.valueOf(request.getParameter("bookId"));
			String bookName = request.getParameter("bookName");
			double bookPrice = Double.valueOf(request.getParameter("bookPrice"));
//			int bookQuantity =
			int bookQuantity =0; 

			//int quantity = Integer.valueOf(request.getParameter("quantity"));


			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			Cart cart = new Cart();

			cart.setBookId(bookId); 
			cart.setBookName(bookName);
			cart.setBookPrice(bookPrice); 
			cart.setQuantity(bookQuantity);
			cart.setCustomEmailid(username);


			boolean isCartAdded = cartDao.addToCart(cart);	
			if(isCartAdded)
			{
				List<Category> allCategories = bookDao.getAllCategory();
				request.setAttribute("allCategories", allCategories);

				List<Publisher> allPublishers = bookDao.getAllPublisher();
				request.setAttribute("allPublishers", allPublishers);

				List<Book> allBooks = bookDao.getAllBook();
				//System.out.println("allBooks" + allBooks);
				request.setAttribute("allBooks", allBooks);
			
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);	
			}

		}



		else if(action.equalsIgnoreCase("ShowCart"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			if(username != null)
			{
				List<Category> allCategories = bookDao.getAllCategory();
				request.setAttribute("allCategories", allCategories);

				List<Publisher> allPublishers = bookDao.getAllPublisher();
				request.setAttribute("allPublishers", allPublishers);

				List<Cart> allCart = cartDao.showCart(username);	
				request.setAttribute("allCart", allCart);

				RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
				rd.forward(request, response);
			}
			else
			{
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}

		else if(action.equalsIgnoreCase("DeleteCart"))
		{
			int cartId = Integer.valueOf(request.getParameter("cartId"));
			boolean isCartDeleted = cartDao.deleteFromCart(cartId);
			if(isCartDeleted)
			{
				HttpSession httpSession = request.getSession();
				String username = (String)httpSession.getAttribute("loggedInUser");

				List<Cart> allCart = cartDao.showCart(username);	
				request.setAttribute("allCart", allCart);

				RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
				rd.forward(request, response);
			}

		}
		else if(action.equalsIgnoreCase("quantity"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			int bookQuantity = Integer.valueOf(request.getParameter("quantity"));
			int cartId = Integer.valueOf(request.getParameter("cartId"));
			/*
			 * Book book = bookDao.getBookById(bookId); book.setBookQuantity(bookQuantity);
			 */

			Cart cart = cartDao.getCartById(cartId);
			cart.setQuantity(bookQuantity);
			
				boolean isBookUpdated = cartDao.updateCart(cart);
			if(isBookUpdated)
			{
				//				List<Cart> allCart = cartDao.getAllCart();
				//				request.setAttribute("allCart", allCart);

				List<Cart> allCart = cartDao.showCart(username);	
				request.setAttribute("allCart", allCart);

				RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
				rd.include(request, response);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action = request.getParameter("action");

	}

}
