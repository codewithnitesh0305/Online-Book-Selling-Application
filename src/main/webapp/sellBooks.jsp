<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body style="background-color:#f7f7f7">
<%@include file="All_Component/navbar.jsp" %>
<div class="container ">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-3">
				<div class="card-body">
				<h4 class="text-center">Sell Old Books</h4>
				<c:if test="${not empty bookAdd_msg}">
					<p class="text-center text-success">${bookAdd_msg}</p>
					<c:remove var="bookAdd_msg" scope="session"/>
				</c:if>
				<c:if test="${not empty failed_msg}">
					<p class="text-center text-danger">${failed_msg}</p>
					<c:remove var="failed_msg" scope="session"/>
				</c:if>
					<form action="addOldBook" method="post" enctype="multipart/form-data">
					<input type=hidden value="${User_obj.email }" name="user_email" >
							<div class="form-group">
								<label for="exampleInputEmail1">Book Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Books_name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Author Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Author_name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Price</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="Price">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Upload Photo</label> 
								<input name="bimg" type="file" class="form-control-file" id="exampleFormControlFile1">								
							</div>
							<button type="submit" class="btn btn-primary">Sell</button>
						</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
</html>