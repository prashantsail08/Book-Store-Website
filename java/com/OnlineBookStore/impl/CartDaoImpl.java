package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Cart;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.Dbutil;
import com.OnlineBookStore.dao.CartDao;

public class CartDaoImpl implements CartDao{

	@Override
	public boolean addToCart(Cart c) {
		
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("INSERT INTO "+Constant.DBCONSTANT.get(Constant.CART_TABLE)+"(cartId,bookId,quantity,customerEmailid,bookName,bookPrice) values(?,?,?,?,?,?)");
			ps.setInt(1, c.getCartId());
			ps.setInt(2, c.getBookId());
			ps.setInt(3, c.getQuantity());
			ps.setString(4, c.getCustomerEmailid());
			ps.setString(5, c.getBookName());
			ps.setDouble(6, c.getBookPrice());
			
			
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> showCart(String cartUsername) {
		
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+Constant.DBCONSTANT.get(Constant.CART_TABLE)+" where customerEmailid=?");
			ps.setString(1, cartUsername);
			
			ResultSet rs =ps.executeQuery();
			
			List<Cart> carts = new ArrayList<>(); 
			
			while(rs.next()) 
			{
				Cart cart = new Cart();
				cart.setBookId(rs.getInt("bookId"));
				cart.setCartId(rs.getInt("cartId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCustomEmailid(rs.getString("customerEmailid"));
				cart.setBookName(rs.getString("bookName"));
				cart.setBookPrice(rs.getDouble("bookPrice"));
				carts.add(cart);
			}
			return carts;

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteFromCart(int id) {
		
		try {
			Connection con = Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("Delete from "+ Constant.DBCONSTANT.get(Constant.CART_TABLE)+" where cartId=?");
			ps.setInt(1,id);

			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateCart(Cart c) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("update "+Constant.DBCONSTANT.get(Constant.CART_TABLE)+" set quantity=? where cartId=?");
		
			ps.setInt(1, c.getQuantity());
			ps.setInt(2, c.getCartId());
			
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Cart getCartById(int id1) {

		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+Constant.DBCONSTANT.get(Constant.CART_TABLE)+" where cartId=?");
			ps.setInt(1, id1);
			ResultSet rs =ps.executeQuery();
			
			Cart cart = new Cart();
			while(rs.next()) {
				
				cart.setBookId(rs.getInt("bookId"));
				cart.setCartId(rs.getInt("cartId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCustomEmailid(rs.getString("customerEmailid"));
				cart.setBookName(rs.getString("bookName"));
				cart.setBookPrice(rs.getDouble("bookPrice"));
			}
			return cart;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Cart>getAllCart() {
		try {
			Connection con = Dbutil.getDbConnection();
			PreparedStatement ps= con.prepareStatement("select * from "+ Constant.DBCONSTANT.get(Constant.CART_TABLE)+"");
			
			ResultSet rs =ps.executeQuery();

			List<Cart> carts = new ArrayList<>();

			while(rs.next()) {
				Cart cart = new Cart();
				cart.setCartId(rs.getInt("cartId"));
				cart.setBookId(rs.getInt("bookId"));
				cart.setQuantity(rs.getInt("quantity"));
				cart.setCustomEmailid(rs.getString("customerEmailid"));
				cart.setBookName(rs.getString("bookName"));
				cart.setBookPrice(rs.getDouble("bookPrice"));

				carts.add(cart);
			}

			return carts;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}


}
