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

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			// Take the details of user from server
			String name = req.getParameter("User_name");
			String email = req.getParameter("User_email");
			String phoneNo = req.getParameter("User_phoneNo");
			String password = req.getParameter("User_password");
			String check = req.getParameter("checkBox");
			HttpSession session = req.getSession();
			
			//Checked that user will fill proper details of registration form
			if(name.equals("")|| email.equals("")|| phoneNo.equals("") || password.equals("")) {
				
				/* System.out.println("Please fill details properly"); */
				session.setAttribute("messing_mag", "Please fill the details properly..");
				resp.sendRedirect("register.jsp");
			}
			else {
				//Stored details in object of user
				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPhoneNo(phoneNo);
				user.setPassword(password);
				
				//User must check the check box
				if(check != null) {
					//Stored object details in databases
					UserDAOImp userdao1 = new UserDAOImp(DBConnection.getConnection());
					boolean c = userdao1.checkUser(email);
					//Check that the user is already register with same email id or not
					if(c) {
						/* System.out.println("Email id already exist.."); */
						session.setAttribute("email_msg", "Email id already exist..");
						resp.sendRedirect("register.jsp");
					}
					else {
						 UserDAOImp userdao = new UserDAOImp(DBConnection.getConnection());
							boolean f = userdao.UserRegister(user);
							if(f) {
								/* System.out.println("Registered Successfully"); */
								session.setAttribute("success_msg", "Registation success..");
								resp.sendRedirect("register.jsp");
							}
							else {
								/* System.out.println("Something went wrong...."); */
								session.setAttribute("failed_msg", "Something went wrong..");
								resp.sendRedirect("register.jsp");
								
							}
						}
				}
					else {
						/* System.out.print("Please accept the term and condition"); */
						session.setAttribute("checkbox_msg", "Pleace agree the term and condition..");
						resp.sendRedirect("register.jsp");
							
						}					

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
