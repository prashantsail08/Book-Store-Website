package com.OnlineBookStore.Models;

public class Cart {

	private int cartId;
	private int bookId;
	private int quantity;
	private String customerEmailid;
	private String bookName;
	private double bookPrice;
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getCustomerEmailid() {
		return customerEmailid;
	}
	public void setCustomEmailid(String customerEmailid) {
		this.customerEmailid = customerEmailid;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", bookId=" + bookId + ", quantity=" + quantity + ", customerEmailid="
				+ customerEmailid + ", bookName=" + bookName + ", bookPrice=" + bookPrice + "]";
	}
	
	
	
}
