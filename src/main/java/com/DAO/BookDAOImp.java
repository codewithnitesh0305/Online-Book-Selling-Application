package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Books;

public class BookDAOImp implements BookDAO{
	private Connection connection;
	
	public BookDAOImp(Connection connection) {
		super();
		this.connection = connection;
	}
	//Insert all the books in the database
	public boolean addBooks(Books books) {
		// TODO Auto-generated method stub
		
		boolean f = false;
		try {
			String query = "INSERT INTO books(Book_Name,Author_Name,Price,Book_Category,Status,Photo,Email) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, books.getBook_Name());
			preparedstatement.setString(2, books.getAuthor());
			preparedstatement.setString(3, books.getPrice());
			preparedstatement.setString(4, books.getBook_Category());
			preparedstatement.setString(5, books.getStatus());
			preparedstatement.setString(6, books.getPhoto());
			preparedstatement.setString(7, books.getUser_Email());
			int i = preparedstatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//Reterive all the books to show in all_books.jsp page
	@Override
	public List<Books> allBooks() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = "SELECT * FROM BOOKS";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Edit the that is stored in the database
	@Override
	public boolean editBook(Books book) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "UPDATE Books SET Book_Name = ?, Author_Name = ?, Price = ?, Book_Category = ? WHERE Book_Id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, book.getBook_Name());
			preparedStatement.setString(2, book.getAuthor());
			preparedStatement.setString(3, book.getPrice());
			preparedStatement.setString(4, book.getBook_Category());
			preparedStatement.setInt(5, book.getBook_id());
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//Reterive the data form databases to be edit
	public Books getBooksById(int id) {
		Books book = null;
		try {
			String query = "SELECT * FROM Books WHERE Book_Id = ? ";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	@Override
	public boolean deleteBook(int id) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "DELETE FROM Books WHERE Book_Id = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			int i = preparedstatement.executeUpdate();
			if(i==1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
		//Show books according to category or status
	
	@Override
	public List<Books> getNewBook() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books  WHERE Book_Category = ? AND Status = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "Active");
			preparedstatement.setString(2, "New");
			ResultSet resultset = preparedstatement.executeQuery();
			int i=1;
			while(resultset.next() && i<=4) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Books> getRecentBook() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books  WHERE Book_Category = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "Active");
			ResultSet resultset = preparedstatement.executeQuery();
			int i=1;
			while(resultset.next() && i<=4) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Books> getOldBook() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books  WHERE Status = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "Old");
			ResultSet resultset = preparedstatement.executeQuery();
			int i=1;
			while(resultset.next() && i<=4) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				i++;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	@Override
	public List<Books> getAllRecentBooks() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books  WHERE Book_Category = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "Active");
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next() ) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Books> getAllOldBooks() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books  WHERE Status = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "Old");
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next() ) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;

	}
	@Override
	public List<Books> getAllNewBooks() {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = " SELECT * FROM Books WHERE Status = ? ORDER BY Book_Id DESC";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, "New");
			ResultSet resultset = preparedstatement.executeQuery();
			
			while(resultset.next() ) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public List<Books> getBooksDetailsByOld(String email, String status) {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = "SELECT * FROM Books WHERE Email = ? AND status = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, status);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public boolean removeBook(int id) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "DELETE FROM Books WHERE Book_id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int i =  preparedStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	@Override
	public List<Books> getBookBySearch(String search) {
		// TODO Auto-generated method stub
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try {
			String query = "SELECT * FROM Books WHERE BOOK_NAME LIKE ? OR AUTHOR_NAME LIKE ? OR STATUS LIKE ? AND BOOK_CATEGORY = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, "%" + search + "%");
			preparedStatement.setString(2, "%" + search + "%");
			preparedStatement.setString(3, "%" + search + "%");
			preparedStatement.setString(4, "Active");
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				book = new Books();
				book.setBook_id(resultset.getInt(1));
				book.setBook_Name(resultset.getString(2));
				book.setAuthor(resultset.getString(3));
				book.setPrice(resultset.getString(4));
				book.setBook_Category(resultset.getString(5));
				book.setStatus(resultset.getString(6));
				book.setPhoto(resultset.getString(7));
				book.setUser_Email(resultset.getString(8));
				list.add(book);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
		

}
