<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Component/allCss.jsp" %>
</head>
<body style="background-color:#f0f1f2">
<%@include file="All_Component/navbar.jsp" %>
<c:if test="${empty User_obj }">
		<c:redirect url="login.jsp" />
</c:if>
<div class="container text-center mt-3">
	<i class="fa-solid fa-circle-check" style="color: #15cb2b;"></i>
	<h1>Thank You</h1>
	<h2>Your Order Successfully</h2>
	<h5>With in 7 Days Your Product will be Delivered in your address</h5>
	<a href="index.jsp" class="btn btn-primary mt-3">Home</a>
	<a href="order.jsp" class="btn btn-danger mt-3">View Order</a>

</div>
</body>
</html>