<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>GrabIt - ${title }</title>

<script>
	window.menu = '${title}';
	window.contextRoot = '${contextRoot}';
</script>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/./resources/css/bootstrap.min.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/./resources/css/shop-homepage.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/./resources/css/bootstrap-theme.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/./resources/css/dataTables.bootstrap4.css'/>" />
<link rel="stylesheet" type="text/css"
	href="<c:url value='/./resources/css/bootstrap-glyphicons.css'/>" />




</head>

<body>


	<div class="wrapper">

		<!-- Navigation -->

		<%@ include file="navbar.jsp"%>

		<!-- Page Content -->


</br></br>

		<div class="container">
			<div class="row">


				<div class="col-lg-12">

					<div class="jumbotron">
						<h1>${errorTitle}</h3>
							</hr>

							<blockquote style="word-wrap:break-word">${description}</blockquote>
							</hr>
					</div>

				</div>
			</div>

		</div>






		<!-- /.container -->

		</br> </br>
		<!-- Footer -->
		<%@ include file="footer.jsp"%>


		<script src="<c:url value='/./resources/js/jquery.js'/>"></script>
		<script
			src=" <c:url value='/./resources/js/bootstrap.bundle.min.js'/>"></script>

		<!-- including JQUERY DATA TABLES -->
		<script src="<c:url value='/./resources/js/jquery.dataTables.js'/>"></script>
		<script
			src="<c:url value='/./resources/js/dataTables.bootstrap4.js'/>"></script>

		<!-- including custom js file -->
		<script src="<c:url value='/./resources/js/myapp.js'/>"></script>


	</div>
</body>

</html>
