package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Order;

public class BookOrderDAOImp implements BookOrderDAO{

	private Connection connection;
	
	public BookOrderDAOImp(Connection connection) {
		super();
		this.connection = connection;
	}



	@Override
	public boolean saveOrder(List<Order> orderlist) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "INSERT INTO ORDER_BOOKS(Order_id,User_name,Email,Address,PhoneNo,Book_Name,Author,Price,Payment) VALUES(?,?,?,?,?,?,?,?,?)";
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			for(Order order : orderlist) {
				preparedStatement.setString(1, order.getOrderId());
				preparedStatement.setString(2, order.getUsername());
				preparedStatement.setString(3, order.getEmail());
				preparedStatement.setString(4, order.getFulladdress());
				preparedStatement.setString(5, order.getPhoneNo());
				preparedStatement.setString(6, order.getBookName());
				preparedStatement.setString(7, order.getAuthor());
				preparedStatement.setString(8, order.getPrice());
				preparedStatement.setString(9, order.getPaymentType());
				preparedStatement.addBatch();
				
			}
			int[] count =  preparedStatement.executeBatch();
			connection.commit();
			f = true;
			connection.setAutoCommit(true);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}



	@Override
	public List<Order> getOrderBook(String email) {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		try {
			String query = "SELECT * FROM ORDER_BOOKS WHERE EMAIL = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				order = new Order();
				order.setId(resultset.getInt(1));
				order.setOrderId(resultset.getString(2));
				order.setUsername(resultset.getString(3));
				order.setEmail(resultset.getString(4));
				order.setFulladdress(resultset.getString(5));
				order.setPhoneNo(resultset.getString(6));
				order.setBookName(resultset.getString(7));
				order.setAuthor(resultset.getString(8));
				order.setPrice(resultset.getString(9));
				order.setPaymentType(resultset.getString(10));
				list.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	@Override
	public List<Order> getAllOrderBook() {
		// TODO Auto-generated method stub
		List<Order> list = new ArrayList<Order>();
		Order order = null;
		try {
			String query = "SELECT * FROM ORDER_BOOKS ";
			PreparedStatement preparedStatement = connection.prepareStatement(query);			
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				order = new Order();
				order.setId(resultset.getInt(1));
				order.setOrderId(resultset.getString(2));
				order.setUsername(resultset.getString(3));
				order.setEmail(resultset.getString(4));
				order.setFulladdress(resultset.getString(5));
				order.setPhoneNo(resultset.getString(6));
				order.setBookName(resultset.getString(7));
				order.setAuthor(resultset.getString(8));
				order.setPrice(resultset.getString(9));
				order.setPaymentType(resultset.getString(10));
				list.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
