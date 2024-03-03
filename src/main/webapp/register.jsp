<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EBooks Register</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body style="background-color:#f0f1f2">
<%@include file="All_Component/navbar.jsp" %>
<div class="container p-2">
	<div class="row">
		<div class="col-md-4 offset-md-4">
			<div class="card">
				<div class="card-body">
				<h4 class="text-center">Registration Form</h4>
				
				<c:if test="${not empty success_msg}">
					<p class="text-center text-success">${success_msg}</p>
					<c:remove var="success_msg" scope="session"/>
				</c:if>
				<c:if test="${not empty messing_mag}">
					<p class="text-center text-danger">${messing_mag}</p>
					<c:remove var="messing_mag" scope="session"/>
				</c:if>
				<c:if test="${not empty email_msg }">
					<p class="text-center text-danger">${email_msg}</p>
					<c:remove var="email_msg" scope="session"/>
				</c:if>
					<c:if test="${not empty checkbox_msg }">
					<p class="text-center text-danger">${checkbox_msg}</p>
					<c:remove var="checkbox_msg" scope="session"/>
				</c:if>
				<c:if test="${not empty failed_msg}">
					<p class="text-center text-danger">${failed_msg}</p>
					<c:remove var="failed_msg" scope="session"/>
				</c:if>
				
						<form action="registerServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Enter Name</label> <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="User_name">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="User_email">
							</div>
							<div class="form-group">
								<label for="exampleInputEmail1">Phone number</label> <input
									type="number" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp"  name="User_phoneNo">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									 name="User_password">
							</div>
							<div class="form-check">
								<input type="checkbox" class="form-check-input" name="checkBox"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Accept the terms and condition</label>
							</div>
							<button type="submit" class="btn btn-primary">Register</button>
						</form>
					</div>
			</div>
		</div>
	</div>
</div>
<%@include file="All_Component/footer.jsp" %>
</body>
</html>