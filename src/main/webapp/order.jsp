<%@page import="com.Entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.Entity.User"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.BookOrderDAOImp"%>
<%@page import="com.DAO.BookDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body>
<%@include file="All_Component/navbar.jsp" %>
<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Order Id</th>		
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
			<%
				User user = (User) session.getAttribute("User_obj");
				String email = user.getEmail();
				BookOrderDAOImp bookOrderDAOImp = new BookOrderDAOImp(DBConnection.getConnection());
				List<Order> list = bookOrderDAOImp.getOrderBook(email);
				for(Order order : list){
			%>
				<tr>
					<th scope="row"><%=order.getOrderId() %></th>
					<td><%=order.getBookName() %></td>
					<td><%=order.getAuthor() %></td>
					<td><%=order.getPrice() %></td>
					<td><%=order.getPaymentType() %></td>
					
				</tr>
			
			<% 		
				}
			%>
			
			</tbody>
		</table>
	</div>
</body>
</html>