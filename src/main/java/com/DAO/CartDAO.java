package com.DAO;

import java.util.List;

import com.Entity.Cart;

public interface CartDAO {
	public boolean addCart(Cart cart);
	public List<Cart> getCartBooksById(int id);
	public boolean removeBookFromCart(int cartid, int bookid);
}
