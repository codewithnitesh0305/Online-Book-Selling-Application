package com.Admin.Servlet;

import java.io.IOException;

import com.DAO.BookDAOImp;
import com.DB.DBConnection;
import com.Entity.Books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/delete")
public class BooksDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("Book_id"));
			BookDAOImp dao = new BookDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			boolean f = dao.deleteBook(id);
			if(f) {
				//System.out.println("Book Delete Successfully");
				session.setAttribute("success", "Delete successfully...");
				resp.sendRedirect("Admin/all_books.jsp");
			}else {
				//System.out.println("Something wrong in server");
				session.setAttribute("error", "some thing went wrong....");
				resp.sendRedirect("Admin/all_books.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
