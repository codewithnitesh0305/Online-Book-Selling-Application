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
@WebServlet("/editBooks")
public class BooksEdit extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int id = Integer.parseInt(req.getParameter("editBook"));
			String bookName = req.getParameter("Books_name");
			String authorName = req.getParameter("Author_name");
			String price = req.getParameter("Price");
			String category = req.getParameter("Category");
			
			BookDAOImp dao = new BookDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			if(bookName.equals("")||authorName.equals("")||price.equals("")||category.equals("")) {
				//System.out.println("Please fill properly");
				session.setAttribute("missing_error", "Please fill all the details...");
				resp.sendRedirect("Admin/bookEdit.jsp");
	
			}else {
				Books book = new Books();
				book.setBook_id(id);
				book.setBook_Name(bookName);
				book.setAuthor(authorName);
				book.setPrice(price);				
				book.setBook_Category(category);
				boolean f = dao.editBook(book);
				if(f) {
					//System.out.print("Update Successfully");
					session.setAttribute("success", "Update successfully...");
					resp.sendRedirect("Admin/all_books.jsp");
				}else {
					//System.out.println("some thing wrong");
					session.setAttribute("error", "some thing went wrong....");
					resp.sendRedirect("Admin/all_books.jsp");
				}				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
