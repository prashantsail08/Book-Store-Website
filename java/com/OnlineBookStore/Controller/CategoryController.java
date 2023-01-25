//package com.OnlineBookStore.Controller;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.OnlineBookStore.Models.Book;
//import com.OnlineBookStore.Models.Category;
//import com.OnlineBookStore.Util.ObjectFactory;
//import com.OnlineBookStore.dao.BookDao;
//import com.OnlineBookStore.dao.CategoryDao;
//@WebServlet("/categorycontroller")
//public class CategoryController extends HttpServlet{
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String action = request.getParameter("action");
//		BookDao bookDao = ObjectFactory.getBookDaoInstance();
//		CategoryDao categoryDao = ObjectFactory.getCategoryDaoInstance();
//		
//		if(action !=null  && action.equalsIgnoreCase("categories"))
//		{
//			HttpSession httpSession = request.getSession();
//			String categoryname = (String)httpSession.getAttribute("categoryName");
//			
//			
//			List<Category> allCategories = categoryDao.getBookByCategory(categoryname);
//			System.out.println("allCategories"+ allCategories);
//			request.setAttribute("allCategories", allCategories);
//			
//			RequestDispatcher rd = request.getRequestDispatcher("BookList.jsp");
//			rd.forward(request, response);
//
//		}
//		
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		BookDao bookDao = ObjectFactory.getBookDaoInstance();
//		CategoryDao categoryDao = ObjectFactory.getCategoryDaoInstance();
//
//		String action = request.getParameter("action");
//
//		if(action !=null && (action.equalsIgnoreCase("addBook") || action.equalsIgnoreCase("updateBook")))
//		{
//			
//			String bookCategory = request.getParameter("bookCategory");
//			
//			Category category = new Category();
//			category.setCategoryName(bookCategory);
//			boolean isCategory = categoryDao.addCategory(category);
//			if(isCategory)
//			{
//				
//			}
//		}
//	}
//}
