package com.User.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DAO.BookOrderDAO;
import com.DAO.BookOrderDAOImp;
import com.DAO.CartDAOImp;
import com.DB.DBConnection;
import com.Entity.Cart;
import com.Entity.Order;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class orderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			String landmark = req.getParameter("landmark");
			String city = req.getParameter("city");
			String state = req.getParameter("state");
			String pincode = req.getParameter("pincode");
			String paymentType = req.getParameter("paymenttype");
			String fulladdress = address+", "+city+", "+state+", "+pincode;
			
			CartDAOImp cartdao = new CartDAOImp(DBConnection.getConnection());
			BookOrderDAOImp bookorderbao = new BookOrderDAOImp(DBConnection.getConnection());
			Order order = null;
			HttpSession session = req.getSession();
			
			Random random = new Random();
			List<Cart> list = cartdao.getCartBooksById(id);
			// Check Is cart is empty or not
			if(list.isEmpty()) {
				//System.out.println("There is no product in your cart");
				session.setAttribute("empty_msg", "There is no product in your cart");
				resp.sendRedirect("cart.jsp");
			}else {
				List<Order> orderlist = new ArrayList<Order>();
				
				for(Cart cart :list) {
					order = new Order();
					//System.out.println(cart.getBookName());
					order.setOrderId("BOOK-ORD-00"+random.nextInt(1000));
					order.setUsername(name);
					order.setEmail(email);
					order.setPhoneNo(phone);
					order.setFulladdress(fulladdress);
					order.setBookName(cart.getBookName());
					order.setAuthor(cart.getAuthor());
					order.setPrice(cart.getPrice()+" ");
					order.setPaymentType(paymentType);
					orderlist.add(order);
					
					
				}
				//System.out.println(name+" "+email+" "+phone+" "+address+" "+landmark+" "+fulladdress +" "+paymentType);
				
				
				if(name.equals("") || email.equals("") || phone.equals("") || address.equals("") || landmark.equals("") || state.equals("") || pincode.equals("") || city.equals("")) {
					//System.out.println("Please fill all details");
					session.setAttribute("missig_msg", "Please fill all details");
					resp.sendRedirect("cart.jsp");
				}
				else {
					if("noselect".equals(paymentType)) {
						//System.out.print("Please select the Payment mode");
						session.setAttribute("payment_msg", "Please Select the payment mode");
						resp.sendRedirect("cart.jsp");
						
					}else {
						boolean f = bookorderbao.saveOrder(orderlist);
						if(f) {
							//System.out.print("Order Success");
							session.setAttribute("success_msg", "Ordered Successfully");
							resp.sendRedirect("order_success.jsp");
						}else {
							//System.out.println("Order Failed");
							session.setAttribute("failed_msg", "Some thing wrong...");
							resp.sendRedirect("cart.jsp");
						}
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
