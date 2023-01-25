package com.OnlineBookStore.Controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.OnlineBookStore.dao.CustomerDao;
import com.OnlineBookStore.dao.OrderDao;

@WebServlet("/logincontroller")
public class LoginController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		CustomerDao customerDao=ObjectFactory.getCustomerDaoInstance();
		OrderDao orderDao = ObjectFactory.getOrderDaoInstance();

		String action = request.getParameter("action");

		if(action != null && action.equalsIgnoreCase("Forgot"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("ForgetPassword.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equalsIgnoreCase("fromSignUp"))
		{
			RequestDispatcher rd = request.getRequestDispatcher("AddCustomer.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equalsIgnoreCase("Logout"))
		{
			HttpSession httpSession = request.getSession();
			httpSession.removeAttribute("loggedInUser");

			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		else if(action != null && action.equalsIgnoreCase("OrderList"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			List<Order> allOrders = orderDao.getAllOrder();
			request.setAttribute("allOrders", allOrders);

			RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
			rd.forward(request, response);
		}

		else if(action != null && action.equalsIgnoreCase("OrderStatus"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");
			if(username!=null)	
			{
//				List<Order> allOrders = orderDao.getAllOrder();
//				request.setAttribute("allOrders", allOrders);

				List<Order> allOrders = orderDao.getOrderByName(username);
				request.setAttribute("allOrders", allOrders);

				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.forward(request, response);
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{

		CustomerDao customerDao=ObjectFactory.getCustomerDaoInstance();
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		String action = request.getParameter("action");

		if(action != null && action.equalsIgnoreCase("fromLogin"))
		{
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("userPass");

			boolean isAdminLogged = customerDao.LoginAdmin(userName, userPass);
			if(isAdminLogged)
			{
				List<Category> allCategories = bookDao.getAllCategory();
				request.setAttribute("allCategories", allCategories);

				List<Publisher> allPublishers = bookDao.getAllPublisher();
				request.setAttribute("allPublishers", allPublishers);

				HttpSession httpSession =request.getSession();
				httpSession.setAttribute("loggedInUser", userName);

				List<Book> allBooks = bookDao.getAllBook();
				System.out.println("allBooks " + allBooks);
				request.setAttribute("allBooks", allBooks);

				RequestDispatcher rd = request.getRequestDispatcher("AddBook.jsp");
				rd.forward(request, response);
			}
			else {
				boolean isLogged = customerDao.LoginCustomer(userName, userPass);
				if(isLogged)
				{
					List<Category> allCategories = bookDao.getAllCategory();
					request.setAttribute("allCategories", allCategories);

					List<Publisher> allPublishers = bookDao.getAllPublisher();
					request.setAttribute("allPublishers", allPublishers);

					HttpSession httpSession =request.getSession();
					httpSession.setAttribute("loggedInUser", userName);

					List<Book> allBooks = bookDao.getAllBook();
					System.out.println("allBooks " + allBooks);
					request.setAttribute("allBooks", allBooks);

					RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
				}
				else {
					response.sendRedirect("Login.jsp");
				}
			}
		}

		else if(action != null && action.equalsIgnoreCase("fromForgot"))
		{
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("userPass");

			boolean isForgotPass = customerDao.ChangePasswrod(userPass,userName);
			if(isForgotPass)
			{
				HttpSession httpSession =request.getSession();
				httpSession.setAttribute("loggedInUser", userName);


				RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}

		}

	}

}

