<%@page import="com.Entity.Books"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.BookDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body style="background-color=#f0f1f2">
<%@include file="All_Component/navbar.jsp" %>

<%
	 int bid = Integer.parseInt(request.getParameter("bid"));
	 BookDAOImp bookdao = new BookDAOImp(DBConnection.getConnection());
	 Books book = bookdao.getBooksById(bid);
%>

<div class="container p-3">
	<div class="row ">
		<div class="col-md-6 text-center p-5 border bg-white">
			<img src="books/<%=book.getPhoto() %>" style="height:170px; width:150px"><br>
			<h4 class="mt-3">Book Name:- <span class="text-success"><%=book.getBook_Name() %></span></h4>
			<h4>Author Name:- <span class="text-success"><%=book.getAuthor() %></span></h4>
			<h4>Category:- <span class="text-success"><%=book.getStatus() %></span></h4>
		</div>	
		<div class="col-md-6 text-center p-5 border bg-white ">
			<h2 class="mt-3"><%=book.getBook_Name() %></h2>
			<%
				if("Old".equals(book.getStatus())){
			%>
				<h6 class="text-primary">Contact to seller</h6>
				<h5 class="text-primary"><i class="fa-solid fa-envelope"></i> Email:- <%=book.getUser_Email() %></h5>
			<%		
				}
			%>
			<div class="row ">
			<div class="col-md-4 text-danger text-center p-2">
				<i class="fa-solid fa-money-bill fa-2x"></i>
				<p>Cash On Delivery</p>
			</div>
			<div class="col-md-4 text-danger text-center p-2 ">
				<i class="fa-solid fa-rotate-left fa-2x"></i>
				<p>Return Available</p>
			</div>
			<div class="col-md-4 text-danger text-center p-2">
				<i class="fa-solid fa-truck fa-2x"></i>
				<p>Free Shipping</p>
			</div>
						
			</div>
			<%
				if("Old".equals(book.getStatus())){
			%>
				<div class="text-center p-3">
				<a href="index.jsp" class="btn btn-success"><i class="fa-solid fa-cart-plus"></i> Coutinue Shopping</a>
				<a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i> <%=book.getPrice() %></a>
				</div>	
				
			<%
				}else{		
			%>
			
			<div class="text-center p-3">
				<a href="" class="btn btn-primary"><i class="fa-solid fa-cart-plus"></i> Add Card</a>
				<a href="" class="btn btn-danger"><i class="fa-solid fa-indian-rupee-sign"></i> <%=book.getPrice() %></a>
			</div>	
			<%} %>
		</div>
	</div>
</div>
</body>
</html>