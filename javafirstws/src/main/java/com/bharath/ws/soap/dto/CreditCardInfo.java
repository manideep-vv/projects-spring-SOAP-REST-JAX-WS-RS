package com.bharath.ws.soap.dto;

import java.util.Date;

public class CreditCardInfo {

	String cardNumber;
	private Date expirtyDate;
	String firstName;
	String lastName;
	String secCode;
	String Address;

	public CreditCardInfo(String cardNumber, Date expirtyDate, String firstName, String lastName, String secCode, String address) {
		this.cardNumber = cardNumber;
		this.expirtyDate = expirtyDate;
		this.firstName = firstName;
		this.lastName = lastName;
		this.secCode = secCode;
		Address = address;
	}

	public CreditCardInfo() {
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public Date getExpirtyDate() {
		return expirtyDate;
	}

	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}

}
