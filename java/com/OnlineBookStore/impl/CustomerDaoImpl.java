package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.Dbutil;
import com.OnlineBookStore.dao.CustomerDao;

public class CustomerDaoImpl implements CustomerDao{

	@Override
	public boolean addCustomer(Customer s) {


		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("INSERT INTO "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" (customerName,customerAddress,customerEmailid,customerContactno,customerPassword) values(?,?,?,?,?)");
			ps.setString(1, s.getCustomerName());
			ps.setString(2, s.getCustomerAddress());
			ps.setString(3, s.getCustomerEmailid());
			ps.setString(4, s.getCustomerContactno());
			ps.setString(5, s.getCustomerPassword());

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
	public boolean updateCustomer(Customer s) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("update "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" set customerName=?,customerAddress=?,customerEmailid=?,customerContactno=?,customerPassword=? where customerId=?");
			ps.setString(1, s.getCustomerName());
			ps.setString(2, s.getCustomerAddress());
			ps.setString(3, s.getCustomerEmailid());
			ps.setString(4, s.getCustomerContactno());
			ps.setString(5, s.getCustomerPassword());
			ps.setInt(6, s.getCustomerId());

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
	public boolean deleteCustomer(int id) {


		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("DELETE FROM "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" where customerId=?");
			ps.setInt(1, id);

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
	public boolean LoginCustomer(String email, String password) {


		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement
					("select customerEmailid,customerPassword from "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" where customerEmailid=?");
			ps.setString(1, email);
			ResultSet rs =ps.executeQuery();
			String UserEmail=null;
			String UserPassword =null;
			while(rs.next()) 
			{
				UserEmail=rs.getString("customerEmailid");
				UserPassword = rs.getString("customerPassword");

			}
			if(email.equals(UserEmail) & password.equals(UserPassword))
			{
				return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean LoginAdmin(String username, String password) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement
					("select customerEmailid,customerPassword from "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" where customerEmailid=?");
			ps.setString(1, username);
			ResultSet rs =ps.executeQuery();
			String UserEmail=null;
			String UserPassword =null;
			while(rs.next()) 
			{
				UserEmail=rs.getString("customerEmailid");
				UserPassword = rs.getString("customerPassword");

			}
			if(username.equals("admin") & password.equals("admin"))
			{
				return true;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean ChangePasswrod(String newpassword,String email) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("update "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" set customerPassword=? where customerEmailid=?");
			
			ps.setString(1, newpassword);
			ps.setString(2, email);
		

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
	public List<Customer> getAllCustomer() {


		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+"");
		
			ResultSet rs =ps.executeQuery();
			List<Customer> customers = new ArrayList<>();
			while(rs.next()) {
				Customer customer = new Customer();
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerAddress(rs.getString("customerAddress"));
				customer.setCustomerEmailid(rs.getString("customerEmailid"));
				customer.setCustomerContactno(rs.getString("customerContactno"));
				customer.setCustomerPassword(rs.getString("customerPassword"));

				customers.add(customer);
			}
			return customers;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerById(int id) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" where customerId=?");
			ps.setInt(1, id);
			ResultSet rs =ps.executeQuery();
			
			Customer customer = new Customer();
			while(rs.next()) {
				customer.setCustomerId(rs.getInt("customerId"));
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerAddress(rs.getString("customerAddress"));
				customer.setCustomerEmailid(rs.getString("customerEmailid"));
				customer.setCustomerContactno(rs.getString("customerContactno"));
				customer.setCustomerPassword(rs.getString("customerPassword"));
			}
			return customer;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomerByName(String Custusername) {


		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("select * from "+Constant.DBCONSTANT.get(Constant.CUSTOMER_TABLE)+" where customerName=?");
			ps.setString(1, Custusername);
			ResultSet rs =ps.executeQuery();
			Customer customer = new Customer();
			while(rs.next()) {
				customer.setCustomerName(rs.getString("customerName"));
				customer.setCustomerAddress(rs.getString("customerAddress"));
				customer.setCustomerEmailid(rs.getString("customerEmailid"));
				customer.setCustomerContactno(rs.getString("customerContactno"));
				customer.setCustomerPassword(rs.getString("customerPassword"));
			}
			return customer;

		}catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}




}
