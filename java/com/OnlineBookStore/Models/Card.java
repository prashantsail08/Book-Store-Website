package com.OnlineBookStore.Models;

public class Card {

	private String payType ;
	private String customerName ;
	private	String bankName ;
	private	int cardNumber ;
	private String cardName ;
	private String date ;
	private int cardCvv;
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
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCardCvv() {
		return cardCvv;
	}
	public void setCardCvv(int cardCvv) {
		this.cardCvv = cardCvv;
	}
	@Override
	public String toString() {
		return "Card [payType=" + payType + ", customerName=" + customerName + ", bankName=" + bankName
				+ ", cardNumber=" + cardNumber + ", cardName=" + cardName + ", date=" + date + ", cardCvv=" + cardCvv
				+ "]";
	}
	
			
	
}
