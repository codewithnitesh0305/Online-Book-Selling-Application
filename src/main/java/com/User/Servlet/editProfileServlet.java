package com.User.Servlet;

import java.io.IOException;

import com.DAO.UserDAOImp;
import com.DB.DBConnection;
import com.Entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/editProfile")
public class editProfileServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String username = req.getParameter("name");
			String email = req.getParameter("email");
			String phoneNo = req.getParameter("phone");
			String password = req.getParameter("password");
			UserDAOImp userdao = new UserDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			if(username.equals("") || email.equals("") || phoneNo.equals("") || password.equals("")) {
				//System.out.println("Please fill properly");
				session.setAttribute("missing_field", "Please fill properly..");
				resp.sendRedirect("editProfile.jsp");
			}else {
				User user = new User();
				user.setId(id);
				user.setName(username);
				user.setEmail(email);
				user.setPhoneNo(phoneNo);
				user.setPassword(password);
				boolean f = userdao.updateProfile(user);
				if(f) {
					//System.out.println("Update Successfully");
					session.setAttribute("success_msg", "Update Successfully");
					resp.sendRedirect("editProfile.jsp");
				}else {
					//System.out.println("Incorrect Password");
					session.setAttribute("failed_msg", "Incorrect Password");
					resp.sendRedirect("editProfile.jsp");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
