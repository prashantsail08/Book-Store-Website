package com.OnlineBookStore.dao;

import java.util.List;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Models.Payment;

public interface PaymentDao {
//	boolean updatePayment(Payment p);
//	
//	Payment getPaymentById(String id);
//	
	boolean addPayment(Payment p);
	
	Payment getPaymentById(int id);
	
	Payment getPaymentByType(String payType);
	
	
	
	
}
