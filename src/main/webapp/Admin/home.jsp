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
<style>
	a{
		text-decoration: none;
		color:black;
	}
	a:hover{
		text-decoration: none;
		color:black;
	}
</style>
</head>
<body>
<%@include file="navbar.jsp" %>

<!--If user not login the it will redirect to login page  -->
<c:if test="${empty userObj }">
	<c:redirect url="../login.jsp"/>
</c:if>


<div class="container p-5 mb-5">
	<div class="row p-5">
		<div class="col-md-3">
		<a href="add_books.jsp">
			<div class="card">
				<div class="card-body text-center">
					<i class="fa-solid fa-plus fa-3x text-primary"></i><br>
					<h4>Add Books</h4>
					--------
				</div>
			</div>
			</a>
		</div>		
		<div class="col-md-3">
		<a href="all_books.jsp">
			<div class="card">
				<div class="card-body text-center">
					<i class="fa-solid fa-book-open fa-3x text-danger"></i><br>
					<h4>All Books</h4>
					--------
				</div>
			</div>
			</a>
		</div>
		<div class="col-md-3">
		<a href="order_books.jsp">
			<div class="card">
				<div class="card-body text-center">
					<i class="fa-solid fa-box fa-3x text-warning"></i><br>
					<h4>Order</h4>
					--------
				</div>
			</div>
			</a>
		</div>
		<div class="col-md-3">
			<a data-toggle="modal"data-target="#exampleModalCenter">
				<div class="card">
				<div class="card-body text-center">
					<i class="fa-solid fa-right-from-bracket fa-3x text-primary"></i></i><br>
					<h4>Logout</h4>
					--------
				</div>
			</div>	
			</a>		
		</div>
	</div>
</div>
<!-- Modal -->
	<div class="modal fade" id="exampleModalCenter" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalCenterTitle"
		aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLongTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<div class="text-center">
						<h4>Do you want logout</h4>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						<a href="../Logout" class="btn btn-primary text-white"> Logout</a>
					</div>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>
<div style="margin-top:150px">
	<%@include file="footer.jsp" %>
</div>
</body>
</html>