<%@page import="com.Entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.BookOrderDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="allCss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<c:if test="${empty userObj }">
		<c:redirect url="../login.jsp" />
	</c:if>
	<h3 class="text-center">Hello Admin</h3>
	<div class="container">
		<table class="table">
			<thead class="thead-dark">
			
				<tr>
					<th scope="col">Order Id</th>
					<th scope="col">Name</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone No</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Payment Type</th>
				</tr>
			</thead>
			<tbody>
			<%
				BookOrderDAOImp bookorderdao = new BookOrderDAOImp(DBConnection.getConnection());
				List<Order> list = bookorderdao.getAllOrderBook();
				for(Order order : list){
			%>
				<tr>
					<th scope="row"><%=order.getOrderId() %></th>
					<td><%=order.getUsername() %></td>
					<td><%=order.getEmail() %></td>
					<td><%=order.getFulladdress() %></td>
					<td><%=order.getPhoneNo() %></td>
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