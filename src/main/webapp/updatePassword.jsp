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
<body>
<%@include file="All_Component/navbar.jsp" %>
	<div class="container mt-5 mb-5">
		<div class="row mt-2">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center">Update Password</h3>
					
					<c:if test="${not empty update_success_msg}">
						<p class="text-center text-success">${update_success_msg}</p>
						<c:remove var="update_success_msg" scope="session"/>
					</c:if>
					<c:if test="${not empty update_faild_msg}">
						<p class="text-center text-danger">${update_faild_msg}</p>
						<c:remove var="update_faild_msg" scope="session"/>
					</c:if>
					<c:if test="${not empty miss_field}">
						<p class="text-center text-danger">${miss_field}</p>
						<c:remove var="miss_field" scope="session"/>
					</c:if>
					<c:if test="${not empty password_missmatch}">
						<p class="text-center text-danger">${password_missmatch}</p>
						<c:remove var="password_missmatch" scope="session"/>
					</c:if>
					
						<form action="updateServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									 name="password">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Confirm Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									 name="comfirm_password">
							</div>
							<div class="text-center">
								<button type="submit" class="btn btn-primary">Update</button><br>
								
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