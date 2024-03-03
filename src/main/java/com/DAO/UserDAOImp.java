package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.xml.transform.Result;

import com.Entity.User;

public class UserDAOImp implements UserDAO{
	private Connection connection;

	public UserDAOImp(Connection connection) {
		super();
		this.connection = connection;
	}


	@Override
	//Take user details for registration
	public boolean UserRegister(User user) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "INSERT INTO User(Name,Email,PhoneNo,Password) VALUES(?,?,?,?)";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, user.getName());
			preparedstatement.setString(2, user.getEmail());
			preparedstatement.setString(3, user.getPhoneNo());
			preparedstatement.setString(4, user.getPassword());
			int a = preparedstatement.executeUpdate();
			if(a == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	//Check user is already register or not
	public boolean checkUser(String email) {
		boolean f = false;
		try {
			String query = "SELECT * FROM user WHERE Email = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			ResultSet resultset = preparedstatement.executeQuery();
			if(resultset.next()) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//Login module
	public User UserLogin(String email,String password) {
		User user = null;
		try {
			String query = "SELECT * FROM user WHERE email = ? AND password = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, email);
			preparedstatement.setString(2,password);
			ResultSet resultset = preparedstatement.executeQuery();
			while(resultset.next()) {
				user = new User();
				user.setId(resultset.getInt(1));
				user.setName(resultset.getString(2));
				user.setEmail(resultset.getString(3));
				user.setPhoneNo(resultset.getString(4));
				user.setPassword(resultset.getString(5));
				user.setAddress(resultset.getString(6));
				user.setLandmarks(resultset.getString(7));
				user.setCity(resultset.getString(8));
				user.setState(resultset.getString(9));
				user.setPincode(resultset.getString(10));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	//Update password module
	public boolean updatePassword(User user) {
		boolean f = false;
		try {
			String query = "UPDATE user SET password = ? WHERE email = ?";
			PreparedStatement preparedstatement = connection.prepareStatement(query);
			preparedstatement.setString(1, user.getPassword());
			preparedstatement.setString(2, user.getEmail());
			int i = preparedstatement.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public boolean updateProfile(User user) {
		// TODO Auto-generated method stub
		boolean f = false;
		try {
			String query = "UPDATE user SET Name = ? , Email = ? ,PhoneNo = ? WHERE Password = ? AND Id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getPhoneNo());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setInt(5, user.getId());
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
