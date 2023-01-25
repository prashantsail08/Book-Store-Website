package com.OnlineBookStore.Models;

public class Payment {

	private int payId;
	private String payType;
	private	String customerName;
	
	public int getPayId() {
		return payId;
	}
	public void setPayId(int payId) {
		this.payId = payId;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	@Override
	public String toString() {
		return "Payment [payId=" + payId + ", payType=" + payType + ", customerName=" + customerName + "]";
	}

		
	
}
