package com.OnlineBookStore.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.OnlineBookStore.Models.Book;
import com.OnlineBookStore.Models.Order;
import com.OnlineBookStore.Models.Payment;
import com.OnlineBookStore.Util.Constant;
import com.OnlineBookStore.Util.Dbutil;
import com.OnlineBookStore.dao.PaymentDao;

public class PaymentDaoImpl implements PaymentDao {
	@Override
	public boolean addPayment(Payment p) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("INSERT INTO "+ Constant.DBCONSTANT.get(Constant.PAYMENT_TABLE)+" (payType,customerName) values(?,?) ");
		
			ps.setString(1, p.getPayType());
			ps.setString(2, p.getCustomerName());
			
			int x=ps.executeUpdate();
			if(x != 0) {
				return true;
			}


		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	@Override
//	public Payment getPaymentById(int id) {
//		try {
//			Connection con=Dbutil.getDbConnection();
//
//			PreparedStatement ps= con.prepareStatement("SELECT * FROM payment where payId=?");
//			ps.setInt(1, id);
//			ResultSet rs =ps.executeQuery();
//			
//			Payment payment = new Payment();
//			while(rs.next()) {
//				payment.setPayId(rs.getInt("payId"));
//				payment.setPayType(rs.getString("payType"));
//				payment.setCustomerName(rs.getString("customerName"));
//			
//			}
//			return payment;
//
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	@Override
	public Payment getPaymentByType(String payType) {
		try {
			Connection con=Dbutil.getDbConnection();

			PreparedStatement ps= con.prepareStatement("SELECT * FROM "+ Constant.DBCONSTANT.get(Constant.PAYMENT_TABLE)+" where payType=?");
			ps.setString(1, payType);
			ResultSet rs =ps.executeQuery();
			
			Payment payment = new Payment();
			while(rs.next()) {
				payment.setPayId(rs.getInt("payId"));
				payment.setPayType(rs.getString("payType"));
				payment.setCustomerName(rs.getString("customerName"));
			
			}
			return payment;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public Payment getPaymentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
