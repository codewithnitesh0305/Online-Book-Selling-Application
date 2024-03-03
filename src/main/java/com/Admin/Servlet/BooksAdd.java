package com.Admin.Servlet;

import java.io.File;
import java.io.IOException;

import com.DAO.BookDAOImp;
import com.DB.DBConnection;
import com.Entity.Books;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/add_books")
@MultipartConfig
public class BooksAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String bookName = req.getParameter("Books_name");
			String author = req.getParameter("Author_name");
			String price = req.getParameter("Price");
			String category = req.getParameter("Category");
			String status = req.getParameter("Status");
			Part part = req.getPart("bimg");
			String fileName = part.getSubmittedFileName();
			BookDAOImp dao = new BookDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();			
			if (bookName.equals("") || author.equals("") || price.equals("") || category.equals("") || status.equals("")|| fileName.equals("")) { // System.out.print("Please fill properly");
				session.setAttribute("missing_field", "Plese fill the information properly");
				resp.sendRedirect("Admin/add_books.jsp");
			} else {
				Books book = new Books(bookName, author, price, category, status, fileName, "admin");
				boolean f = dao.addBooks(book);
				if (f) { 
					//save the image of books in the books folder
					String path = getServletContext().getRealPath("") + "books";
					File file = new File(path);
					part.write(path + File.separator + fileName);
					// System.out.println("Books add successfully");
					session.setAttribute("bookAdd_msg", "Book add successfully");
					resp.sendRedirect("Admin/add_books.jsp");
				} else {
					// System.out.print("Books not add successfully");
					session.setAttribute("failed_msg", "Some thing went wrong in server");
					resp.sendRedirect("Admin/add_books.jsp");

				}

			}
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
