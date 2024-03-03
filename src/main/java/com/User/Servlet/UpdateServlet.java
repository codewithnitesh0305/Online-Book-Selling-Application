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

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			String comfirm_password = req.getParameter("comfirm_password");
			UserDAOImp userdao = new UserDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			if(email.equals("") || password.equals("")) {
				//System.out.print("Please enter email and password properly");
				session.setAttribute("miss_field", "Please enter email and password properly");
				resp.sendRedirect("updatePassword.jsp");
			}else {
				if(password.equals(comfirm_password)) {
					boolean f = userdao.updatePassword(user);
					//System.out.println(f);
					if(f) {
						session.setAttribute("update_success_msg", "Password update successfully");
						resp.sendRedirect("updatePassword.jsp");
						//System.out.println("Password update successfully");
					}
					else {
						//System.out.println("Password not update successfully");
						session.setAttribute("update_faild_msg", "Password not update successfully");
						resp.sendRedirect("updatePassword.jsp");
					}
				}
				else {
					//System.out.println("Password mis match");
					session.setAttribute("password_missmatch", "Password mismatch");
					resp.sendRedirect("updatePassword.jsp");
				}
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
