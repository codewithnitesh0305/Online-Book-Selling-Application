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
<style>
	a{
		text-decoration: none;
		color: black;
	}
	a:hover{
		text-decoration:none;
	}
</style>
</head>
<body style="background-color:#f7f7f7">
<%@include file="All_Component/navbar.jsp" %>
<c:if test="${empty User_obj }">
	<c:redirect url="login.jsp"/>
</c:if>
<div class="container mb-5">
<h3 class="text-center ">Hello ${User_obj.name }</h3>
	<div class="row p-5">
		<div class="col-md-4">
			<a href="sellBooks.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class="text-primary ">
						<i class="fa-solid fa-book-open fa-3x"></i>
					</div>
						<h3>Sell Old Books</h3>
						
					</div>			
				</div>
			</a>		
		</div>	
		<div class="col-md-4">
			<a href="manageBook.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class="text-primary ">
						<i class="fa-solid fa-book-open fa-3x"></i>
					</div>
						<h3>Manage Books</h3>
						
					</div>			
				</div>
			</a>		
		</div>	
		<div class="col-md-4">
			<a href="editProfile.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class="text-primary ">
						<i class="fa-solid fa-pen-to-square fa-3x"></i>
					</div>
						<h4>Edit Profile</h4>
						
					</div>			
				</div>
			</a>		
		</div>	
			
			<div class="col-md-6 mt-3">
			<a href="order.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class="text-danger ">
						<i class="fa-solid fa-parachute-box fa-3x"></i>
					</div>
						<h4>My Order</h4>
						<p>Track Your Order</p>					
					</div>			
				</div>
			</a>		
		</div>	
			<div class="col-md-6 mt-3">
			<a href="help.jsp">
				<div class="card">
					<div class="card-body text-center">
					<div class="text-primary ">
						<i class="fa-solid fa-user fa-3x"></i>
					</div>
						<h4>Help Center</h4>
						<p>24*7 Service</p>
						
					</div>			
				</div>
			</a>		
		</div>	
	</div>

</div>
<%@include file="All_Component/footer.jsp" %>
</body>
</html>