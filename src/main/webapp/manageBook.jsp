<%@page import="java.util.List"%>
<%@page import="com.DAO.BookDAOImp"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.BookDAO"%>
<%@page import="com.Entity.User"%>
<%@page import="com.Entity.Books"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Books</title>
<%@include file="All_Component/allCss.jsp"%>
</head>
<body>
	<%@include file="All_Component/navbar.jsp"%>
	<c:if test="${empty User_obj }">
		<c:redirect url="login.jsp" />
	</c:if>
	<c:if test="${not empty success_msg}">
		<p class="text-center text-success">${success_msg}</p>
		<c:remove var="success_msg" scope="session" />
	</c:if>
	<c:if test="${not empty failed_msg}">
		<p class="text-center text-danger">${failed_msg}</p>
		<c:remove var="failed_msg" scope="session" />
	</c:if>
	<div class="container p-5">
		<table class="table table-striped">
			<thead class="thead-dark">

				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Price</th>
					<th scope="col">Action</th>
				</tr>

			</thead>
			<tbody>
				<%
				User user = (User) session.getAttribute("User_obj");
				String email = user.getEmail();
				BookDAO bookdao = new BookDAOImp(DBConnection.getConnection());
				List<Books> list = bookdao.getBooksDetailsByOld(email, "Old");
				for (Books books : list) {
				%>
				<tr>
					<th><%=books.getBook_Name()%></th>
					<td><%=books.getAuthor()%></td>
					<td><%=books.getPrice()%></td>
					<td><a href="removeProduct?productId=<%=books.getBook_id()%>"
						class="btn btn-small btn-danger">Delete</a></td>
				</tr>

				<%
				}
				%>


			</tbody>
		</table>


	</div>
</body>
</html>