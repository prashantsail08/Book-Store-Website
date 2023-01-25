package com.OnlineBookStore.dao;

import java.util.List;

import com.OnlineBookStore.Models.*;


public interface CartDao {

	
	boolean addToCart(Cart c);
	
	List<Cart> showCart(String cartUsername);
	
	boolean deleteFromCart(int id);
	
	
	boolean updateCart(Cart c);
	Cart getCartById(int id);

	List<Cart>getAllCart();
}
