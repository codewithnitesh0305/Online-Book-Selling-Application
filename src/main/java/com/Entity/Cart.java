package com.Entity;

public class Cart {
	private int cartId;
	private int bookId;
	private int userId;
	private String bookName;
	private String author;
	private double price;
	private double total;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartId, int bookId, int userId, String bookName, String author, double price, double total) {
		super();
		this.cartId = cartId;
		this.bookId = bookId;
		this.userId = userId;
		this.bookName = bookName;
		this.author = author;
		this.price = price;
		this.total = total;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
}
