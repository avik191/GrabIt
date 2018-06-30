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
    
     <link rel="stylesheet" type="text/css" href="<c:url value='/./resources/css/bootstrap.min.css'/>" />
     <link rel="stylesheet" type="text/css" href="<c:url value='/./resources/css/shop-homepage.css'/>" />
     <link rel="stylesheet" type="text/css" href="<c:url value='/./resources/css/bootstrap-theme.css'/>" />

    <!-- Bootstrap core CSS 
    <link href="./resources/css/bootstrap.min.css" rel="stylesheet">-->

    <!-- Custom styles for this template 
    <link href="./resources/css/shop-homepage.css" rel="stylesheet">-->
    
    <!-- Bootstrap theme 
    <link href="./resources/css/bootstrap-theme.css" rel="stylesheet">-->

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
	    
	    <c:if test="${isAllProducts == true}">
	    	<%@ include file="showproducts.jsp" %>
	    </c:if>
	    
	     <c:if test="${isCategoryProduct == true }">
	    	<%@ include file="showproducts.jsp" %>
	    </c:if>
	    
	    <c:if test="${isContact == true }">
	    	<%@ include file="contact_page.jsp" %>
	    </c:if>
   
   </div>
    <!-- /.container -->

    <!-- Footer -->
    <%@ include file="footer.jsp" %>

    
    <script src="<c:url value='/./resources/js/jquery.js'/>"></script>
    <script src=" <c:url value='/./resources/js/bootstrap.bundle.min.js'/>"></script>
    
    <!-- including JQUERY DATA TABLES -->
        <script src="<c:url value='/./resources/js/jquery.dataTables.js'/>"></script>
        
     <!-- including custom js file -->
        <script src="<c:url value='/./resources/js/myapp.js'/>"></script>
    
    </div>
  </body>

</html>
