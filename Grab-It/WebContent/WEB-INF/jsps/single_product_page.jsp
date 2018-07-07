<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.Entity.UserModel"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	</br>
	<div class="container">

		<!-- adding breadcrum component -->

		<div class="row">
			<div class="col-lg-12">

				<ol class="breadcrumb">
					<li><a href="/Grab-It/home">Home</a></li>
					<li><a href="/Grab-It/all/Products">/Products</a></li>
					<li>/${product.name }</li>
				</ol>

			</div>
		</div>

		<div class="row">
			<div class="col-lg-4">

				<img src="${contextRoot }/resources/images/${product.code }.png"
					style="width: 400px; height: 300px" />

			</div>

			<div class="col-lg-8">
				<h3>${product.name}</h3>
				</hr>
				<p>${product.description}</p>
				</hr>
				<h4>
					Price : <strong>&#8377; ${product.unitPrice } /-</strong>
				</h4>
				</hr>


				<c:choose>
					<c:when test="${product.quantity<1 }">
						<h6>
							Qty.Available : <span style="color: red">Out Of Stock</span>
						</h6>
						</hr>
					</c:when>
					<c:otherwise>
						<h6>Qty.Available : ${product.quantity }</h6>
						</hr>
					</c:otherwise>
				</c:choose>


				<%
					UserModel user1 = (UserModel) session.getAttribute("loggedUser");
					if (user1 != null) {
						if (user1.getRole().equals("ADMIN")) {
				%>

				<a href="/Grab-It/manage/${product.id }/product"
					class="btn btn-warning"><span
					class="glyphicon glyphicon-pencil"></span></a>
				<%
					} else {
				%>

				<c:choose>
					<c:when test="${product.quantity<1 }">
						<a href="javascript:void(0)" class="btn btn-success disabled"><span
							class="glyphicon glyphicon-shopping-cart"><strike>cart</strike></span></a>
					</c:when>
					<c:otherwise>
						<a href="/Grab-It/cart/add/${product.id }/product" class="btn btn-success"><span
							class="glyphicon glyphicon-shopping-cart">cart</span></a>

					</c:otherwise>
				</c:choose>

				<%
					}
					} else {
				%>
				<c:choose>
					<c:when test="${product.quantity<1 }">
						<a href="javascript:void(0)" class="btn btn-success disabled"><span
							class="glyphicon glyphicon-shopping-cart"><strike>cart</strike></span></a>
					</c:when>
					<c:otherwise>
						<a href="/Grab-It/cart/add/${product.id }/product" class="btn btn-success"><span
							class="glyphicon glyphicon-shopping-cart">cart</span></a>

					</c:otherwise>
				</c:choose>

				<%
					}
				%>



				&#160; <a href="/Grab-It/all/Products" class="btn btn-primary">Back</a>
			</div>
		</div>

	</div>
</body>
</html>