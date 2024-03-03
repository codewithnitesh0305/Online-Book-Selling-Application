package com.DAO;

import java.util.List;

import com.Entity.Books;

public interface BookDAO {
	public boolean addBooks(Books books);
	public List<Books> allBooks();
	public boolean editBook(Books book);
	public Books getBooksById(int id);
	public boolean deleteBook(int id);
	public List<Books> getNewBook();
	public List<Books> getRecentBook();
	public List<Books> getOldBook();
	public List<Books> getAllRecentBooks();
	public List<Books> getAllOldBooks();
	public List<Books> getAllNewBooks();
	public List<Books> getBooksDetailsByOld(String email,String status);
	public boolean removeBook(int id);
	public List<Books> getBookBySearch(String serarch);
	
	
}
