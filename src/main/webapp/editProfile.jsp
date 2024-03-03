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
<body style="background-color:#f7f7f7">
<%@include file="All_Component/navbar.jsp" %>
<c:if test="${empty User_obj }">
		<c:redirect url="login.jsp" />
	</c:if>
<div class="container ">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card mt-3">
				<div class="card-body">
				<h4 class="text-center">Edit Profile</h4>
						<c:if test="${not empty success_msg}">
							<p class="text-center text-success">${success_msg}</p>
							<c:remove var="success_msg" scope="session" />
						</c:if>
						<c:if test="${not empty missing_field}">
							<p class="text-center text-success">${missing_field}</p>
							<c:remove var="missing_field" scope="session" />
						</c:if>
						<c:if test="${not empty failed_msg}">
							<p class="text-center text-success">${failed_msg}</p>
							<c:remove var="failed_msg" scope="session" />
						</c:if>
						
						<form action="editProfile" method="post" >
					<input type="hidden" name="id" value="${User_obj.id }">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="name" value="${User_obj.name}">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Email</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="email"  value="${User_obj.email }">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone Number</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="phone" value="${User_obj.phoneNo }">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Password to Verify</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="password">
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