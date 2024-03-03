package com.User.Servlet;

import java.io.IOException;

import com.DAO.BookDAOImp;
import com.DAO.CartDAOImp;
import com.DB.DBConnection;
import com.Entity.Books;
import com.Entity.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			int bookId = Integer.parseInt(req.getParameter("book_Id"));
			int userId = Integer.parseInt(req.getParameter("user_Id"));
			BookDAOImp bookdao = new BookDAOImp(DBConnection.getConnection());
			Books book = bookdao.getBooksById(bookId);
			Cart cart = new Cart();
			cart.setBookId(bookId);
			cart.setUserId(userId);
			cart.setBookName(book.getBook_Name());
			cart.setAuthor(book.getAuthor());
			cart.setPrice(Double.parseDouble(book.getPrice()));
			cart.setTotal(Double.parseDouble(book.getPrice()));
			
			CartDAOImp cartdao = new CartDAOImp(DBConnection.getConnection());
			HttpSession session = req.getSession();
			boolean f = cartdao.addCart(cart);
			if(f) {
				//System.out.println("Add to cart Successfully");
				session.setAttribute("addCart", "Book Added to Cart");
				resp.sendRedirect("all_new_books.jsp");
			}else {
				//System.out.println("Something we worg");
				session.setAttribute("failed", "Some thing wrong");
				resp.sendRedirect("all_new_books.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
