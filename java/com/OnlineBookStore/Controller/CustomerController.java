package com.OnlineBookStore.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.OnlineBookStore.dao.CustomerDao;

public class CustomerController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action = request.getParameter("action");
		CustomerDao customerDao=ObjectFactory.getCustomerDaoInstance();
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		
		if(action !=null && action.equalsIgnoreCase("DeleteCustomerList"))
		{
			int customerId=Integer.valueOf(request.getParameter("customerId"));

			boolean isCustomerDeleted = customerDao.deleteCustomer(customerId);
			if(isCustomerDeleted)
			{
				List<Customer> allcustomers=customerDao.getAllCustomer();
				request.setAttribute("allCustomers", allcustomers);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomerList.jsp");
				rd.forward(request, response);

			}
		}else if(action !=null  && action.equalsIgnoreCase("customerById"))
		{
			int customerId=Integer.valueOf(request.getParameter("customerId"));

			Customer customer = customerDao.getCustomerById(customerId);
			request.setAttribute("customer", customer);

			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}

		else if(action !=null  && action.equalsIgnoreCase("ShowCustomer"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser"); 
			
			List<Category> allCategories = bookDao.getAllCategory();
			request.setAttribute("allCategories", allCategories);

			List<Publisher> allPublishers = bookDao.getAllPublisher();
			request.setAttribute("allPublishers", allPublishers);

			List<Customer> allCustomers=customerDao.getAllCustomer();
			request.setAttribute("allCustomers", allCustomers);

			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomerList.jsp");
			rd.forward(request, response);
		}

		else if(action !=null  && action.equalsIgnoreCase("UpdateCustomerList"))
		{
			int customerId=Integer.valueOf(request.getParameter("customerId"));
			Customer customer = customerDao.getCustomerById(customerId);
			request.setAttribute("customer", customer);

			RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomer.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		CustomerDao customerDao=ObjectFactory.getCustomerDaoInstance();
		String action = request.getParameter("action");
		if(action !=null && (action.equalsIgnoreCase("addCustomer")))
		{
			String customerName = request.getParameter("customerName");
			String customerAddress = request.getParameter("customerAddress");
			String customerEmailid = request.getParameter("customerEmailid");
			String customerContactno = request.getParameter("customerContactno");
			String customerPassword = request.getParameter("customerPassword");

			Customer customer = new Customer();
			customer.setCustomerName(customerName);
			customer.setCustomerAddress(customerAddress);
			customer.setCustomerEmailid(customerEmailid);
			customer.setCustomerContactno(customerContactno);
			customer.setCustomerPassword(customerPassword);

			boolean isAddCustomer = customerDao.addCustomer(customer);
			if(isAddCustomer == true)
			{
				response.sendRedirect("Login.jsp");
			}
		}
		else if(action !=null &&  action.equalsIgnoreCase("updateCustomer"))
		{
			String customerName = request.getParameter("customerName");
			String customerAddress = request.getParameter("customerAddress");
			String customerEmailid = request.getParameter("customerEmailid");
			String customerContactno = request.getParameter("customerContactno");
			String customerPassword = request.getParameter("customerPassword");

			int customerId1= Integer.valueOf(request.getParameter("customerId"));
			Customer customer = customerDao.getCustomerById(customerId1);

			customer.setCustomerName(customerName);
			customer.setCustomerAddress(customerAddress);
			customer.setCustomerEmailid(customerEmailid);
			customer.setCustomerContactno(customerContactno);
			customer.setCustomerPassword(customerPassword);

			if(action !=null && action.equalsIgnoreCase("updateCustomer"))
			{
				int customerId=Integer.valueOf(request.getParameter("customerId"));
				customer.setCustomerId(customerId);

				boolean isCustomerUpdated = customerDao.updateCustomer(customer);
				if(isCustomerUpdated)
				{

					List<Customer> allCustomers = customerDao.getAllCustomer();
					request.setAttribute("allCustomers", allCustomers);

					RequestDispatcher rd = request.getRequestDispatcher("UpdateCustomerList.jsp");
					rd.forward(request, response);
				}
			}
		}
	}}
