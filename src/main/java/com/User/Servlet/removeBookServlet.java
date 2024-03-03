package com.User.Servlet;

import java.io.IOException;

import com.DAO.BookDAOImp;
import com.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/removeProduct")
public class removeBookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int bookId = Integer.parseInt(req.getParameter("productId"));
			BookDAOImp bookdao = new BookDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			boolean f = bookdao.removeBook(bookId);
			if(f) {
				//System.out.println("Book removed");
				session.setAttribute("success_msg", "Book Remove Successfully");
				resp.sendRedirect("manageBook.jsp");
			}
			else {
				//System.out.print("Book not removed");
				session.setAttribute("failed_msg", "Something went wrong....");
				resp.sendRedirect("manageBook.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
