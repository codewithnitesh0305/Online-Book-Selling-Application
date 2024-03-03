package com.User.Servlet;

import java.io.IOException;

import com.Entity.User;
import com.DAO.UserDAOImp;
import com.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try	{
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			UserDAOImp dao = new UserDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			
			if("admin123@gmail.com".equals(email) && "admin123".equals(password)) {
				User user = new User();
				user.setName("Admin");
				session.setAttribute("userObj", user);
				resp.sendRedirect("Admin/home.jsp");
			}
			else {
				User user =  dao.UserLogin(email, password);
				if(user != null) {
					session.setAttribute("User_obj", user);
					resp.sendRedirect("index.jsp");
				}
				else {
					session.setAttribute("failed_mag", "Invalid Email id and Password");
					resp.sendRedirect("login.jsp");
				}
			}
		}catch(Exception e) {
			
		}
	}
	
}
