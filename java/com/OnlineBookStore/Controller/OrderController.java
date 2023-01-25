package com.OnlineBookStore.Controller;

import java.io.IOException;

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
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Models.Payment;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.OnlineBookStore.dao.CartDao;
import com.OnlineBookStore.dao.CustomerDao;
import com.OnlineBookStore.dao.OrderDao;
import com.OnlineBookStore.dao.PaymentDao;

@WebServlet("/ordercontroller")
public class OrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action = request.getParameter("action");
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		OrderDao orderDao = ObjectFactory.getOrderDaoInstance();
		CartDao cartDao = ObjectFactory.getCartDaoInstance();
		CustomerDao customerDao = ObjectFactory.getCustomerDaoInstance();
		PaymentDao paymentDao = ObjectFactory.getPaymentDaoInstance();

		if(action !=null && action.equalsIgnoreCase("ClearCart"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			boolean isCartCleared = orderDao.clearCart(username);
			if(isCartCleared==true)
			{
				List<Cart> allCart = cartDao.showCart(username);	
				request.setAttribute("allCart", allCart);

				RequestDispatcher rd = request.getRequestDispatcher("Cart.jsp");
				rd.forward(request, response);
			}
		}
		else if(action !=null && action.equalsIgnoreCase("placeOrder"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			List<Cart> allCart1 = cartDao.showCart(username);

			double totalBill=0;
			for (int i = 0; i < allCart1.size(); i++) 
			{
				Cart cart = allCart1.get(i);
				totalBill=totalBill+(cart.getQuantity()*cart.getBookPrice());
			}
			System.out.println("totalBill" +totalBill);
			String orderStatus = "dispatched";
		
			boolean isOrdered = orderDao.placeOrder(username, totalBill,orderStatus);
			if(isOrdered)
			{		
				List<Cart> allCart = cartDao.showCart(username);
				request.setAttribute("allCart", allCart);

//				Customer customer =customerDao.getCustomerByName(username);
//				request.setAttribute("customer", customer);
				
				String paymentType =request.getParameter("paymentType");
				
//				Payment payment=paymentDao.getPaymentByType(paymentType);
//				request.setAttribute("payment", payment);
				List<Category> allCategories = bookDao.getAllCategory();
				request.setAttribute("allCategories", allCategories);

				List<Publisher> allPublishers = bookDao.getAllPublisher();
				request.setAttribute("allPublishers", allPublishers);
				
				List<Order> allOrders = orderDao.getOrderByName(username);
				request.setAttribute("allOrders", allOrders);
				
				
				
				RequestDispatcher rd = request.getRequestDispatcher("Payment.jsp");
				rd.include(request, response);
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String action = request.getParameter("action");
		OrderDao orderDao = ObjectFactory.getOrderDaoInstance();
		CartDao cartDao = ObjectFactory.getCartDaoInstance();
		if(action !=null && action.equalsIgnoreCase("UpdateStatus"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			int orderId = Integer.valueOf(request.getParameter("orderId"));
			String orderStatus = request.getParameter("UpdateStatus");

			Order order = orderDao.getOderById(orderId);
			order.setOrderStatus(orderStatus);

			boolean isOrderStatus = orderDao.updateOrderStatus(order);
			if(isOrderStatus==true)
			{
				List<Order> allOrders = orderDao.getAllOrder();	
				request.setAttribute("allOrders", allOrders);

				RequestDispatcher rd = request.getRequestDispatcher("OrderList.jsp");
				rd.include(request, response);
			}
		}
	}
}
