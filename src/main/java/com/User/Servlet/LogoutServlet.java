package com.User.Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			HttpSession session = req.getSession();
			session.removeAttribute("userObj");
			
			HttpSession session2 = req.getSession();
			session.removeAttribute("User_obj");
			
			HttpSession session1 = req.getSession();
			session1.setAttribute("success_msg", "Logout Successfully");
			resp.sendRedirect("login.jsp");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
