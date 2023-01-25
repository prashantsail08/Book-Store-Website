package com.OnlineBookStore.clients;
import java.util.Scanner;

import com.OnlineBookStore.impl.CartDaoImpl;
public class CartClient {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	CartDaoImpl cartDaoImpl = new CartDaoImpl();
	System.out.println("1 Add to Cart");
	System.out.println("2 show Cart");
	System.out.println("3 Delete From Cart");
	
	System.out.println("Enter Choice");
	int choice = sc.nextInt();
	switch(choice) 
	{
	case 1:
		System.out.println("Add To Cart");
	
	}
}
}
