package com.OnlineBookStore.dao;
import java.util.List;


import com.OnlineBookStore.Models.*;

public interface CustomerDao
{
	boolean addCustomer(Customer s);
	boolean updateCustomer(Customer s);
	boolean deleteCustomer(int id);
	boolean LoginCustomer(String email, String password);
	boolean LoginAdmin(String username, String password);
	boolean ChangePasswrod( String newpassword,String email);
	
	
	List<Customer>getAllCustomer();
	Customer getCustomerById(int id);
	
	
	Customer getCustomerByName(String Custusername);
	

}