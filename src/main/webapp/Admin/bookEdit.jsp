<%@page import="com.DAO.BookDAOImp"  %>
<%@page import="com.Entity.Books" %>
<%@page import="com.DB.DBConnection" %>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allCss.jsp" %>
</head>
<body>
<%@include file="navbar.jsp" %>
<c:if test="${empty userObj }">
	<c:redirect url="../login.jsp"/>
</c:if>
<div class="container ">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Edit Books</h4>
				
		
			<%
				/* Take the book id from the url */
					int id = Integer.parseInt(request.getParameter("BookId"));
					BookDAOImp dao = new BookDAOImp(DBConnection.getConnection());
					Books book =  dao.getBooksById(id); 					 
			%>
					<form action="../editBooks" method="post">
					<!-- take the id of the book and use to edit in BooksEdit.java servlet -->
					<input type="hidden" name="editBook" value="<%=book.getBook_id()%>">
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Books_name" value="<%=book.getBook_Name()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Author_name" value="<%=book.getAuthor()%>">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Price" value="<%=book.getPrice()%>">
							</div>	
								<div class="form-group">
									<label for="exampleInputPassword1">Book Status</label> 
									<select id="inputState" name="Category" class="form-control" >
									<%
										if("Active".equals(book.getBook_Category())){
									%>
											 <option value="Active">Active</option> 
											<option value="Inactive">Inactive</option>
									<%}
										else{
									%>
										<option value="Active">Active</option>
										<option value="Inactive">Inactive</option>	
									<% 
									}
									%>
								</select>
							</div>
							<button type="submit" class="btn btn-primary">Edit</button>
						
						</form>
						
				</div>
			</div>
			
		</div>
	</div>
</div>

</body>
</html>