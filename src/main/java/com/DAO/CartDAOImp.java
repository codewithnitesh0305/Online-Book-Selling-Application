package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Entity.Cart;

public class CartDAOImp implements CartDAO{
	private Connection connection;
	
	public CartDAOImp(Connection connection) {
		super();
		this.connection = connection;
	}

	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "INSERT INTO Cart(Book_Id,User_Id,Book_Name,Author,Price,Total) VALUES(?,?,?,?,?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, cart.getBookId());
			preparedstatement.setInt(2, cart.getUserId());
			preparedstatement.setString(3, cart.getBookName());
			preparedstatement.setString(4, cart.getAuthor());
			preparedstatement.setDouble(5, cart.getPrice());
			preparedstatement.setDouble(6, cart.getTotal());
			int i =  preparedstatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public List<Cart> getCartBooksById(int id) {
		// TODO Auto-generated method stub
		List<Cart> list = new ArrayList<>();
		Cart cart = null;
		Double totalPrice = 0.0;
		try {
			String query = "SELECT * FROM Cart WHERE User_Id = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setInt(1, id);
			ResultSet resultSet = preparedstatement.executeQuery();
			while(resultSet.next()) {
				cart = new Cart();
				cart.setCartId(resultSet.getInt(1));
				cart.setBookId(resultSet.getInt(2));
				cart.setUserId(resultSet.getInt(3));
				cart.setBookName(resultSet.getString(4));
				cart.setAuthor(resultSet.getString(5));
				cart.setPrice(resultSet.getDouble(6));
				totalPrice=totalPrice + resultSet.getDouble(7);
				cart.setTotal(totalPrice);
				list.add(cart);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean removeBookFromCart(int cartid,int bookid) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "DELETE FROM Cart WHERE Cart_Id = ? AND Book_Id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, cartid);
			preparedStatement.setInt(2, bookid);
			int i = preparedStatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
