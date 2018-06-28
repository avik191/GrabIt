<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GrabIt - ${title } </title>
    
    <script> window.menu= '${title}' </script>

    <!-- Bootstrap core CSS -->
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./resources/css/shop-homepage.css" rel="stylesheet">
    
    <!-- Bootstrap theme -->
    <link href="./resources/css/bootstrap-theme.css" rel="stylesheet">

  </head>

  <body>


	<div class="wrapper">
	
    <!-- Navigation -->

	<%@ include file="navbar.jsp" %>
	
    <!-- Page Content -->
    
    <div class="content">
    
	    <c:if test="${isHome == true }">
	    	<%@ include file="home_page.jsp" %>
	    </c:if>
	    
	    <c:if test="${isAbout == true }">
	    	<%@ include file="about_page.jsp" %>
	    </c:if>
	    
	    <c:if test="${isProducts == true }">
	    	<%@ include file="allproduct_page.jsp" %>
	    </c:if>
	    
	    <c:if test="${isContact == true }">
	    	<%@ include file="contact_page.jsp" %>
	    </c:if>
   
   </div>
    <!-- /.container -->

    <!-- Footer -->
    <%@ include file="footer.jsp" %>

    <!-- Bootstrap core JavaScript -->
    <script src="./resources/js/jquery.js"></script>
    <script src="./resources/js/bootstrap.bundle.min.js"></script>
    
    </div>
  </body>

</html>
