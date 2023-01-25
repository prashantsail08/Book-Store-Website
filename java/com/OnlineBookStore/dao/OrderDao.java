package com.OnlineBookStore.dao;
import java.util.List;


import com.OnlineBookStore.Models.*;

public interface OrderDao {

	public boolean placeOrder(String customeremail, double totalbill, String orderStatus);
	List<Order>getAllOrder();

	public boolean clearCart(String customeruseremail);
	String checkOrderStatus(int orderid);
	
	List<Order> getOrderByName(String customerName);
	boolean updateOrderStatus(Order o);
	Order getOderById(int id);
	
	
		
}
