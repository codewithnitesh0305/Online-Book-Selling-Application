<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EBooks Login</title>
<%@include file="All_Component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="All_Component/navbar.jsp"%>
	<div class="container mb-5 p-5">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center">Login Form</h3>
						
						<c:if test="${not empty failed_mag}">
							<p class="text-center text-danger">${failed_mag}</p>
							<c:remove var="failed_mag" scope="session"/>
						</c:if>
						<!--Logout Success Msg  -->
						<c:if test="${not empty success_msg}">
							<p class="text-center text-success">${success_msg}</p>
							<c:remove var="success_msg" scope="session"/>
						</c:if>
					
						<form action="loginservlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" required="required" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									required="required" name="password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Login</button><br>
								<a href="register.jsp">Create Account</a><br><hr>
								<a href="updatePassword.jsp">Forget password....</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@include file="All_Component/footer.jsp" %>
</body>
</html>