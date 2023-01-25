package com.OnlineBookStore.Models;

public class Customer {
	
	private int customerId;
	private String customerName;
	private String customerAddress;
	private String customerEmailid;
	private String customerContactno;
	private String customerPassword;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerEmailid() {
		return customerEmailid;
	}
	public void setCustomerEmailid(String customerEmailid) {
		this.customerEmailid = customerEmailid;
	}
	public String getCustomerContactno() {
		return customerContactno;
	}
	public void setCustomerContactno(String customerContactno) {
		this.customerContactno = customerContactno;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerAddress="
				+ customerAddress + ", customerEmailid=" + customerEmailid + ", customerContactno=" + customerContactno
				+ ", customerPassword=" + customerPassword + "]";
	}
	
	
}
