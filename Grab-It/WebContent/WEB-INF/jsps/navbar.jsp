<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li  id="home_page" <c:if test="${isHome == true }"> class="active"</c:if>>
              <a class="nav-link" href="/Grab-It/home">Home</a>
            </li>
            <li  id="about" <c:if test="${isAbout == true }"> class="active"</c:if>>
              <a class="nav-link" href="/Grab-It/about">About</a>
            </li>
            <li  id="products" <c:if test="${isAllProducts == true }"> class="active"</c:if>>
              <a class="nav-link" href="/Grab-It/all/Products">Products</a>
            </li>
            <li  id="contact" <c:if test="${isContact == true }"> class="active"</c:if>>
              <a class="nav-link" href="/Grab-It/contact">Contact</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

</body>
</html>