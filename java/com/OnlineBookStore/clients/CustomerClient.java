package com.OnlineBookStore.clients;

import java.util.Scanner;

import com.OnlineBookStore.Models.Customer;
import com.OnlineBookStore.impl.CustomerDaoImpl;

public class CustomerClient {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	CustomerDaoImpl customerDaoImpl= new CustomerDaoImpl();

	System.out.println("1: Add Customer");
	System.out.println("2: Update Customer");
	System.out.println("3: Delete Customer");
	System.out.println("4: LoginCustomer");
	System.out.println("5: LoginAdmin");
	System.out.println("6: ChangePasswrod");
	System.out.println("7: Show All Customers");
	System.out.println("8: get customer by id");
	System.out.println("9: get customer by name");
	
	System.out.println("Enter Your Choice: ");
	int c1=sc.nextInt();
	switch(c1) {
	
	case 1:
		Customer customer = new Customer();
		
		System.out.println("Enter Customer Name= ");
		String name=sc.next();
		customer.setCustomerName(name);
		
		System.out.println("Enter Customer Address= ");
		String address=sc.next();
		customer.setCustomerAddress(address);
		
		System.out.println("Enter Customer Email ID= ");
		String email=sc.next();
		customer.setCustomerEmailid(email);
		
		System.out.println("Enter Customer Contact No= ");
		String no=sc.next();
		customer.setCustomerContactno(no);
		
		System.out.println("Enter Customer Password= ");
		String pass=sc.next();
		customer.setCustomerPassword(pass);
		
		customerDaoImpl.addCustomer(customer);
		
		break;
		
	case 2:
		//Update
	case 3:
		System.out.println("Enter Customer ID= ");
		int id=sc.nextInt();
		
		Customer customer2 = new Customer();
		customer2.setCustomerId(id);
		customerDaoImpl.deleteCustomer(id);
		break;
		
	case 4:
		System.out.println("4 LoginCustomer");
		
		System.out.println("Enter Email Id");
		String email1 =sc.next();
		
		System.out.println("Enter Password");
		String password =sc.next();
		
		customerDaoImpl.LoginCustomer(email1,password);
		break;


	case 5:
		System.out.println("5 LoginAdmin");
		break;
	case 6:
		System.out.println("6 ChangePasswrod");
		break;
		
		
	case 7:
		System.out.println("show all Customer");
		customerDaoImpl.getAllCustomer();
		break;
		
	case 8:
		System.out.println("get customer by id");
		int id3 =sc.nextInt();
		
		Customer customer3 = new Customer();
		
		customer3.setCustomerId(id3);
		customerDaoImpl.getCustomerById(id3);
		
		break;

	case 9:
		System.out.println("get customer by name");
		String Customername =sc.next();
		
		Customer customer4 = new Customer();
		
		customer4.setCustomerName(Customername);
		customerDaoImpl.getCustomerByName(Customername);
		break;
	}
}
}
