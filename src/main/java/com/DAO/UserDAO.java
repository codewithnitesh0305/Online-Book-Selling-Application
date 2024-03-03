package com.DAO;

import com.Entity.User;

public interface UserDAO {
	public boolean UserRegister(User user);
	public User UserLogin(String email,String password);
	public boolean updateProfile(User user);
}
