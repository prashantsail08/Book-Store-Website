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
import com.OnlineBookStore.Models.Card;
import com.OnlineBookStore.Models.Category;
import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Models.Payment;
import com.OnlineBookStore.Models.Publisher;
import com.OnlineBookStore.Util.ObjectFactory;
import com.OnlineBookStore.dao.BookDao;
import com.OnlineBookStore.dao.CardDao;
import com.OnlineBookStore.dao.CartDao;
import com.OnlineBookStore.dao.CustomerDao;
import com.OnlineBookStore.dao.OrderDao;
import com.OnlineBookStore.dao.PaymentDao;
@WebServlet("/paymentcontroller")
public class PaymentController  extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		OrderDao orderDao = ObjectFactory.getOrderDaoInstance();
		CartDao cartDao = ObjectFactory.getCartDaoInstance();
		CustomerDao customerDao = ObjectFactory.getCustomerDaoInstance();
		PaymentDao paymentDao = ObjectFactory.getPaymentDaoInstance();

		if(action !=null && action.equalsIgnoreCase("payment"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");

			String paymentType =request.getParameter("paymentType");

			Payment payment = new Payment();
			payment.setPayType(paymentType);
			payment.setCustomerName(username);

			boolean isPaymentAdded = paymentDao.addPayment(payment);
			if(isPaymentAdded)
			{
			String paymentType1 =request.getParameter("paymentType");
//
//				Payment payment1 = paymentDao.getPaymentByType(paymentType1);
//				request.setAttribute("payment1", payment1);

				Customer customer =customerDao.getCustomerByName(username);
				request.setAttribute("customer", customer);


				if(payment.getPayType().equals("DebitCard"))
				{
					List<Category> allCategories = bookDao.getAllCategory();
					request.setAttribute("allCategories", allCategories);

					List<Publisher> allPublishers = bookDao.getAllPublisher();
					request.setAttribute("allPublishers", allPublishers);
					
					Payment payment1 = paymentDao.getPaymentByType(paymentType1);
					request.setAttribute("payment1", payment1);

					RequestDispatcher rd = request.getRequestDispatcher("DebitCard.jsp");
					rd.include(request, response);
				}
				if(payment.getPayType().equals("CreditCard"))
				{
					List<Category> allCategories = bookDao.getAllCategory();
					request.setAttribute("allCategories", allCategories);

					List<Publisher> allPublishers = bookDao.getAllPublisher();
					request.setAttribute("allPublishers", allPublishers);
					
					Payment payment1 = paymentDao.getPaymentByType(paymentType1);
					request.setAttribute("payment1", payment1);

					RequestDispatcher rd = request.getRequestDispatcher("CreditCard.jsp");
					rd.include(request, response);
				}

			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		BookDao bookDao = ObjectFactory.getBookDaoInstance();
		OrderDao orderDao = ObjectFactory.getOrderDaoInstance();
		CartDao cartDao = ObjectFactory.getCartDaoInstance();
		CustomerDao customerDao = ObjectFactory.getCustomerDaoInstance();
		PaymentDao paymentDao = ObjectFactory.getPaymentDaoInstance();
		CardDao cardDao = ObjectFactory.getcardDaoInstance();
		
		if(action !=null && action.equalsIgnoreCase("addCards"))
		{
			HttpSession httpSession = request.getSession();
			String username = (String)httpSession.getAttribute("loggedInUser");
			
			String payType = request.getParameter("payType");
			
			String bankName = request.getParameter("bankName");
			int cardNumber = Integer.valueOf(request.getParameter("cardNumber"));
			String cardName = request.getParameter("cardName");
			String date = request.getParameter("date");
			int cardCvv = Integer.valueOf(request.getParameter("cardCvv"));
			
			Card card = new Card();
			card.setPayType(payType);
			card.setCustomerName(username);
			card.setBankName(bankName);
			card.setCardNumber(cardNumber);
			card.setCardName(cardName);
			card.setDate(date);
			card.setCardCvv(cardCvv);
			
			boolean isCardAdded = cardDao.addCard(card);
			if(isCardAdded)
			{
				List<Category> allCategories = bookDao.getAllCategory();
				request.setAttribute("allCategories", allCategories);

				List<Publisher> allPublishers = bookDao.getAllPublisher();
				request.setAttribute("allPublishers", allPublishers);

				
				RequestDispatcher rd = request.getRequestDispatcher("Thankyou.jsp");
				rd.include(request, response);	
			}
		}
	}
}

