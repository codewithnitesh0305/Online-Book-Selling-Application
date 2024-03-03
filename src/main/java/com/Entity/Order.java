package com.Entity;

public class Order {

	private int id;
	private String orderId;
	private String username;
	private String email;
	private String phoneNo;
	private String fulladdress;
	private String paymentType;
	
	private String bookName;
	private String author;
	private String price;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Order(int id, String orderId, String username, String email, String phoneNo, String fulladdress,
			String paymentType, String bookName, String author, String price) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.username = username;
		this.email = email;
		this.phoneNo = phoneNo;
		this.fulladdress = fulladdress;
		this.paymentType = paymentType;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getFulladdress() {
		return fulladdress;
	}

	public void setFulladdress(String fulladdress) {
		this.fulladdress = fulladdress;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
}
