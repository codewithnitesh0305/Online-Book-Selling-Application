<%@page import="java.util.List"%>
<%@page import="com.Entity.Cart"%>
<%@page import="com.Entity.User"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.CartDAOImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<%@include file="All_Component/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2">
	<%@include file="All_Component/navbar.jsp"%>

	<c:if test="${empty User_obj }">
		<c:redirect url="login.jsp" />
	</c:if>

	<div class="container">
		<div class="row p-2">
			<div class="col-md-6">

				<div class="cart bg-white">
					<div class="card-body">
						<h3 class="text-center text-success">Your Selected Item</h3>
						<c:if test="${not empty success}">
							<p class="text-center text-success">${success}</p>
							<c:remove var="success" scope="session" />
						</c:if>
						<c:if test="${not empty failur}">
							<p class="text-center text-danger">${failur}</p>
							<c:remove var="failur" scope="session" />
						</c:if>

						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Book Name</th>
									<th scope="col">Author</th>
									<th scope="col">Price</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								User user = (User) session.getAttribute("User_obj");
								CartDAOImp cartdao = new CartDAOImp(DBConnection.getConnection());
								List<Cart> list = cartdao.getCartBooksById(user.getId());
								Double totalPrice = 0.0;
								for (Cart cart : list) {
									totalPrice = cart.getTotal();
								%>
								<tr>
									<th scope="row"><%=cart.getBookName()%></th>
									<td><%=cart.getAuthor()%></td>
									<td>RS.<%=cart.getPrice()%></td>
									<td><a
										href="remove?cartid=<%=cart.getCartId()%>&&bookid=<%=cart.getBookId()%>"
										class="btn btn-sm btn-danger"><i class="fa-solid fa-trash"></i>
											Remove</a></td>
								</tr>
								<%
								}
								%>
								<tr>
									<td>Total Price</td>
									<td></td>
									<td></td>
									<td>Rs.<%=totalPrice%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
						<form action="order" method="post">
							<input type="hidden" value="${User_obj.id}" name="id">
							<h3 class="text-center text-success">Your Details for Order</h3>
							
							<c:if test="${not empty empty_msg}">
								<p class="text-center text-success">${empty_msg}</p>
								<c:remove var="empty_msg" scope="session" />
							</c:if>
							<c:if test="${not empty missig_msg}">
								<p class="text-center text-success">${missig_msg}</p>
								<c:remove var="missig_msg" scope="session" />
							</c:if>
							<c:if test="${not empty payment_msg}">
								<p class="text-center text-success">${payment_msg}</p>
								<c:remove var="payment_msg" scope="session" />
							</c:if>
							<c:if test="${not empty failed_msg}">
								<p class="text-center text-danger">${failed_msg}</p>
								<c:remove var="failed_msg" scope="session" />
							</c:if>
							
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Name</label> <input type="text"
										name="name" class="form-control" id="inputEmail4"
										placeholder="Name" readOnly="readonly"
										value="${User_obj.name }">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Email</label> <input name="email"
										type="email" class="form-control" id="inputPassword4"
										placeholder="Email" value="${User_obj.email }"
										readOnly="readonly">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Phone No.</label> <input type="number"
										name="phone" class="form-control" id="inputEmail4"
										value="${User_obj.phoneNo }" readOnly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Address</label> <input
										name="address" type="text" class="form-control"
										id="inputPassword4">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">Landmark</label> <input type="text"
										name="landmark" class="form-control" id="inputEmail4">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">City</label> <input name="city"
										type="text" class="form-control" id="inputPassword4">
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputEmail4">State</label> <input type="text"
										name="state" class="form-control" id="inputEmail4">
								</div>
								<div class="form-group col-md-6">
									<label for="inputPassword4">Zip</label> <input name="pincode"
										type="text" class="form-control" id="inputPassword4">
								</div>
							</div>
							<div class="form-group">
								<label>Payment Mode</label> <select class="form-control"
									name="paymenttype">
									<option value="noselect">--Select--</option>
									<option value="COD">Cash On Delivery</option>
								</select>

							</div>
							<div class="text-center">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue
									Shopping</a>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>