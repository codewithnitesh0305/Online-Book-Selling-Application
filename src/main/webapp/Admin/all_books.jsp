<%@page import="com.DAO.BookDAOImp" %>
<%@page import="com.DB.DBConnection" %>
<%@page import="java.util.List" %>
<%@page import="com.Entity.Books" %>
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
<h3 class="text-center">Hello Admin</h3>
				<c:if test="${not empty missing_field}">
					<p class="text-center text-danger">${missing_field}</p>
					<c:remove var="missing_field" scope="session"/>
				</c:if>
		 		<c:if test="${not empty missing_error}">
					<p class="text-center text-danger">${missing_error}</p>
					<c:remove var="missing_error" scope="session"/>
				</c:if>
				<c:if test="${not empty success}">
					<p class="text-center text-success">${success}</p>
					<c:remove var="success" scope="session"/>
				</c:if>
				<c:if test="${not empty error}">
					<p class="text-center text-danger">${error}</p>
					<c:remove var="error" scope="session"/>
				</c:if> 
<div class="container">
	<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Id</th>
       <th scope="col">Image</th>     
      <th scope="col">Book Name</th>
      <th scope="col">Author Name</th>
      <th scope="col">Price</th>
      <th scope="col">Category</th>
      <th scope="col">Status</th>
      <th scope="col">Action</th>
    </tr>
  </thead>

  <tbody>
      	<%
  		BookDAOImp dao = new BookDAOImp(DBConnection.getConnection());
  		List<Books> list = dao.allBooks();
  		for(Books books : list){  		
  		%>
    <tr>
      
      <td><%=books.getBook_id() %></td>
      <td><img src="../books/<%=books.getPhoto()%>"style="width:50px ; height:50px"></td>
      <td><%=books.getBook_Name()%></td>
      <td><%=books.getAuthor()%></td>
      <td>Rs <%=books.getPrice()%></td>
      <td><%=books.getBook_Category()%></td>
      <td><%=books.getStatus()%></td>      
      <td>
      	<a href="bookEdit.jsp?BookId=<%=books.getBook_id()%>" class="btn btn-sm btn-primary"><i class="fa-solid fa-pen-to-square"></i> Edit</a>
      	<!-- Delete is the name of the servlet -->
      	<a href="../delete?Book_id=<%=books.getBook_id()%>" class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i> Delete</a>
      </td>      
    </tr>
   <%
  		}
    %>

  </tbody>
   
</table>


</div>
</body>
</html>