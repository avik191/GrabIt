<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.Entity.UserModel"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="/Grab-It/home">Grab It</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li id="home_page"
					<c:if test="${isHome == true }"> class="active"</c:if>><a
					class="nav-link" href="/Grab-It/home">Home</a></li>
				<li id="about"
					<c:if test="${isAbout == true }"> class="active"</c:if>><a
					class="nav-link" href="/Grab-It/about">About</a></li>
				<li id="products"
					<c:if test="${isAllProducts == true }"> class="active"</c:if>>
					<a class="nav-link" href="/Grab-It/all/Products">Products</a>
				</li>
				<li id="contact"
					<c:if test="${isContact == true }"> class="active"</c:if>><a
					class="nav-link" href="/Grab-It/contact">Contact</a></li>

				<%
					UserModel user = (UserModel) session.getAttribute("loggedUser");
					if (user != null) {
						if (user.getRole().equals("ADMIN")) {
				%>

				<li id="contact"
					<c:if test="${userClickManageProduct == true }"> class="active"</c:if>>
					<a class="nav-link" href="/Grab-It/manage/products">Manage</a>
				</li>
				
				<li class="dropdown" id="userModel"><a
					class="btn btn-info dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown">
						<%= user.getFirstName()+" "+user.getLastName() %> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
					</ul>
					</li>

				<%
					}
						if (user.getRole().equals("USER")) {
				%>

				<li class="dropdown" id="userModel"><a
					class="btn btn-info dropdown-toggle" href="javascript:void(0)"
					id="dropdownMenu1" data-toggle="dropdown">
						<%= user.getFirstName()+" "+user.getLastName() %> <span class="caret"></span>
				</a>
					<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
						<li id="cart"><a href="${contextRoot}/cart/show"> <span
								class="glyphicon glyphicon-shopping-cart"></span>&#160;<span
								class="badge"><%=user.getCart().getCartLines() %></span> - &#8377;
								<%=user.getCart().getGrandTotal() %>
						</a></li>
						<li role="separator" class="divider"></li>
						<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
					</ul></li>

				<%
					}
					}
					if (user == null) {
				%>

				<li id="contact"
					<c:if test="${userClickSignIn == true }"> class="active"</c:if>>
					<a class="nav-link" href="/Grab-It/signIn">Login/Register</a>
				</li>

				<%
					}
				%>







			</ul>
		</div>
	</div>
	</nav>
	
	<script>
	<%
	 	if(user != null)
	 	{
	%>
	 		window.userRole = '<%= user.getRole()%>';
	<%	}
	 	else{
	%>
			window.userRole = 'user';
	<%
	 	}
	%>
		
	</script>

</body>
</html>