package com.Entity;

public class Books {
	private int Book_id;
	private String Book_Name;
	private String Author;
	private String Price;
	private String Book_Category;
	private String Status;
	private String Photo;
	private String User_Email;
	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Books(String book_Name, String author, String price, String book_Category, String status,
			String photo, String user_Email) {
		super();
		Book_Name = book_Name;
		Author = author;
		Price = price;
		Book_Category = book_Category;
		Status = status;
		Photo = photo;
		User_Email = user_Email;
	}
	public int getBook_id() {
		return Book_id;
	}
	public void setBook_id(int book_id) {
		Book_id = book_id;
	}
	public String getBook_Name() {
		return Book_Name;
	}
	public void setBook_Name(String book_Name) {
		Book_Name = book_Name;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public String getBook_Category() {
		return Book_Category;
	}
	public void setBook_Category(String book_Category) {
		Book_Category = book_Category;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getPhoto() {
		return Photo;
	}
	public void setPhoto(String photo) {
		Photo = photo;
	}
	public String getUser_Email() {
		return User_Email;
	}
	public void setUser_Email(String user_Email) {
		User_Email = user_Email;
	}
	@Override
	public String toString() {
		return "Booksbetails [Book_id=" + Book_id + ", Book_Name=" + Book_Name + ", Author=" + Author + ", Price="
				+ Price + ", Book_Category=" + Book_Category + ", Status=" + Status + ", Photo=" + Photo
				+ ", User_Email=" + User_Email + "]";
	}
	
	
}
