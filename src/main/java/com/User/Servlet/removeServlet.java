package com.User.Servlet;

import java.io.IOException;

import com.DAO.CartDAOImp;
import com.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/remove")
public class removeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			 int cartid = Integer.parseInt(req.getParameter("cartid"));
			 int bookid = Integer.parseInt(req.getParameter("bookid"));
			 CartDAOImp cartdao = new CartDAOImp(DBConnection.getConnection());
			 HttpSession session = req.getSession();
			 boolean f = cartdao.removeBookFromCart(cartid,bookid);
			 if(f) {
				 //System.out.println("Rmove from cart Successfully");
				 session.setAttribute("success", "Remove Item Successfully");
				 resp.sendRedirect("cart.jsp");
				 
			 }else {
				 //System.out.println("Remove from cart Unsuccessfully");
				 session.setAttribute("failur", "Something went wrong..");
				 resp.sendRedirect("cart.jsp");
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
