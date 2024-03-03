<%@page import="com.Entity.User"%>
<%@page import="com.DB.DBConnection" %>
<%@page import="java.sql.Connection" %>
<%@page import="com.DAO.BookDAOImp" %>
<%@page import="java.util.List" %>
<%@page import="com.Entity.Books" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Resent Books</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body>
<%@include file="All_Component/navbar.jsp" %>
<%
	User user  = (User) session.getAttribute("User_obj");
%>
<div class="container" >
	<h3 class="text-center">Recent Books</h3>
	<div class="row">
	<%
			BookDAOImp bookdao1 = new BookDAOImp(DBConnection.getConnection());
			 List<Books> list1 = bookdao1.getAllRecentBooks();
			 for(Books books1 : list1){
		%>
			<div class="col-md-3">
			<br>
			<div class="card crd-ho">
				<div class="card-body text-center">
				<img alt="Java" src="books/<%=books1.getPhoto() %>" style="height:200px; width:150px">
				<p><%=books1.getBook_Name() %></p>
				<p><%=books1.getAuthor() %></p>
				<p>
				<%
					if(books1.getStatus().equals("Old")){
				%>
				<!-- For old books -->
					Category:- <%=books1.getStatus()%></p>
					<div class="row ">
					<a href="view.jsp?bid=<%=books1.getBook_id() %>" class="btn btn-success btn-small ml-5">Details</a>
					<a href="" class="btn btn-danger btn-small ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=books1.getPrice() %></a>	
					</div>
				<%		
					}else{
				%>
				
				<!-- For new books -->
					Category:- <%=books1.getStatus()%></p>
				<div class="row ">
					<%
					if(user == null){
				%>
					<a href="login.jsp" class="btn btn-danger btn-small ml-3"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
				<% 		
					}else{			
				%>
					<!--Get the bookid and userid to add product in cart  -->
					<a href="cartServlet?book_Id=<%=books1.getBook_id()%>&&user_Id=<%=user.getId()%>" class="btn btn-danger btn-small ml-3"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
				<%}%>
					<a href="view.jsp?bid=<%=books1.getBook_id() %>" class="btn btn-success btn-small ml-1">Details</a>
					<a href="" class="btn btn-danger btn-small ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=books1.getPrice() %></a>	
				</div>
				
				<% 	
					}
				%>
				
			</div>
			</div>
		</div>
		<%  
			 }
		%>		
				
				
	</div>

</div>
<!-- End Recent Books -->	
</body>
</html>