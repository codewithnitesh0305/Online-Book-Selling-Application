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
<title>Online Book Selling</title>
<%@include file="All_Component/allCss.jsp" %>
<style type="text/css">
.back-img{
	background: url("img/img1.jpg");
	height:50vh;
	widht: 100%;
	background-repeat:no-repeat;
	background-position: center;
	background-size: cover;
}
.crd-ho:hover{
	background-color:#fcf7f7;
}
</style>
</head>
<body style="background-color: #f7f7f7">
<%@include file="All_Component/navbar.jsp" %>
<%
	User user  = (User) session.getAttribute("User_obj");
%>


<div class="container-fluid back-img">
	<h2 class="text-center text-light p-3"><i class="fa-solid fa-book"></i> EBook Management System</h2>
</div>
<%-- 	<%
	 Connection connection = DBConnection.getConnection();
	 out.print(connection);
	%> --%>
<!-- Start Recent Books -->
<div class="container" >
	<h3 class="text-center">Recent Books</h3>
	<div class="row">
	<%
			BookDAOImp bookdao1 = new BookDAOImp(DBConnection.getConnection());
			 List<Books> list1 = bookdao1.getRecentBook();
			 for(Books books1 : list1){
		%>
		<div class="col-md-3">
			<div class="card crd-ho">
				<div class="card-body text-center">
				<img alt="Java" src="books/<%=books1.getPhoto() %>" style="height:200px; width:150px">
				<p><%=books1.getBook_Name() %></p>
				<p><%=books1.getAuthor() %></p>
				<p>
				<%
					if(books1.getStatus().equals("Old")){
				%>
					Category:- <%=books1.getStatus()%></p>
					<div class="row ">
					<a href="view.jsp?bid=<%=books1.getBook_id() %>" class="btn btn-success btn-small ml-5">Details</a>
					<a href="" class="btn btn-danger btn-small ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=books1.getPrice() %></a>	
					</div>
				<%		
					}else{
				%>
				
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
	<div class="text-center mt-2">
		<a href="all_resent_books.jsp" class="btn btn-danger btn-small text-white">View All</a>
	</div>
</div>
<!-- End Recent Books -->
	<hr>
<!-- Start New Books -->
<div class="container" >
	<h3 class="text-center">New Books</h3>
	<div class="row">
		
		<%
			BookDAOImp bookdao = new BookDAOImp(DBConnection.getConnection());
			 List<Books> list = bookdao.getNewBook();
			 for(Books books : list){
		%>	
				<div class="col-md-3">
				<div class="card crd-ho">
				<div class="card-body text-center">
				<img alt="Java" src="books/<%=books.getPhoto() %>" style="height:200px; width:150px">
				<p><%=books.getBook_Name() %></p>
				<p><%=books.getAuthor() %></p>
				<p>Category:- <%=books.getStatus()%></p>
				<div class="row ">
					<%
					if(user == null){
				%>
					<a href="login.jsp" class="btn btn-danger btn-small ml-3"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
				<% 		
					}else{			
				%>
					<!--Get the bookid and userid to add product in cart  -->
					<a href="cartServlet?book_Id=<%=books.getBook_id()%>&&user_Id=<%=user.getId()%>" class="btn btn-danger btn-small ml-3"><i class="fa-solid fa-cart-shopping"></i>Cart</a>
				<%}%>
					<a href="view.jsp?bid=<%=books.getBook_id() %>" class="btn btn-success btn-small ml-1">Details</a>
					<a href="" class="btn btn-danger btn-small ml-1"><i class="fa-solid fa-indian-rupee-sign"></i> <%=books.getPrice() %></a>	
				</div>
			</div>
			</div>
			</div>
			
		<%  
			 }
		%>				
	</div>
	<div class="text-center mt-2">
		<a href="all_new_books.jsp" class="btn btn-danger btn-small text-white">View All</a>
	</div>
</div>
<!-- End New Books -->
	<hr>
<!-- Start Old Books -->
<div class="container" >
	<h3 class="text-center">Old Books</h3>
	<div class="row">
		<%
			BookDAOImp bookdao2 = new BookDAOImp(DBConnection.getConnection());
			 List<Books> list2 = bookdao2.getOldBook();
			 for(Books books2 : list2){
		%>	
		<div class="col-md-3">
			<div class="card crd-ho">
				<div class="card-body text-center">
				<img alt="Java" src="books/<%=books2.getPhoto() %>" style="height:200px; width:150px">
				<p><%=books2.getBook_Name() %></p>
				<p><%=books2.getAuthor() %></p>
				<p>Category:- <%=books2.getStatus()%></p>
				<div class="row ">
				<!-- Taking book id and show in view page -->
					<a href="view.jsp?bid=<%=books2.getBook_id() %>" class="btn btn-success btn-small ml-5">Details</a> 	
				<a href="" class="btn btn-danger btn-small ml-1"><i class="fa-solid fa-indian-rupee-sign"></i><%=books2.getPrice() %></a>	
				</div>
			</div>
			</div>
		</div>
	<%  
			 }
	%>

	</div>
	<div class="text-center mt-2">
		<a href="all_old_books.jsp" class="btn btn-danger btn-small text-white">View All</a>
	</div>
</div>
<!-- End Old Books -->
 
 <!--Footer -->
 <%@include file="All_Component/footer.jsp" %>
</body>
</html>