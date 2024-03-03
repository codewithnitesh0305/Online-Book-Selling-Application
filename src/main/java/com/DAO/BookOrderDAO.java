package com.DAO;

import java.util.List;

import com.Entity.Order;

public interface BookOrderDAO {
	
	public boolean saveOrder(List<Order> orderlist);
	public List<Order> getOrderBook(String email);
	public List<Order> getAllOrderBook();
}
