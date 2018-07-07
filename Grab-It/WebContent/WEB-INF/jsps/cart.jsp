<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="org.springframework.beans.factory.annotation.Autowired,com.Service.ProductService,com.Entity.Product,com.Entity.UserModel,com.Entity.CartLine"%>
    <%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%
 	UserModel cartuser = (UserModel) session.getAttribute("loggedUser");
%>
</br>
<div class="container">



		<c:if test="${not empty message}">
					<div class="row">
						<div class="col-lg-2"></div>
						<div class="col-lg-8">
							<div id="alertCard" class="alert card bg-warning text-white">${message}</div>
						</div>
					</div>
				</c:if>
	<c:choose>
		
		<c:when test="${not empty cartLines }">
		
			<table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
					<% 
					List<CartLine> list = (List<CartLine>)request.getAttribute("cartLines"); 
					List<Product> productList = (List<Product>)request.getAttribute("productList"); 

					for(int i =0;i<list.size();i++)
					{
						CartLine cartLine = list.get(i);
						Product product = productList.get(i);

					%>
						
						
						<tr>
							<td data-th="Product">
								<div class="row">
									<div class="col-sm-2 hidden-xs"><img src="${contextRoot }/resources/images/<%=product.getCode() %>.png" alt="<%= product.getName() %>" class="img-responsive" style="width:80px;height:80px"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin"><%= product.getName() %>
										
										<c:if test="${cartLine.available == 0 }">
											<strong class="unavailable">(Not Available)</strong>
										</c:if>
										</h4>
										<p>Brand - <%= product.getBrand() %></p>
										<p>Description - <%= product.getDescription() %></p>
									</div>
								</div>
							</td>
							<td data-th="Price">&#8377; <%= cartLine.getBuyingPrice() %></td>
							<td data-th="Quantity">
								<input type="number" id="count_<%=cartLine.getId() %>" class="form-control text-center" value="<%= cartLine.getProductCount()%>">
							</td>
							<td data-th="Subtotal" class="text-center">&#8377; <%= cartLine.getTotal() %></td>
							<td class="actions" data-th="">
								<button class="btn btn-info btn-sm" type="button" name="refreshCartbtn" value="<%= cartLine.getId()%>"><span class="glyphicon glyphicon-refresh"></span></button>
								<a href="${contextRoot }/cart/<%= cartLine.getId() %>/delete" class="btn btn-danger btn-sm"><span class="glyphicon glyphicon-trash"></span></a>								
							</td>
						</tr>
						
						
					<%
						
					}
					%>

						
					</tbody>
					<tfoot>
						<tr class="visible-xs">
							<td class="text-center"><strong>Total &#8377; <%= cartuser.getCart().getGrandTotal() %></strong></td>
						</tr>
						<tr>
							<td><a href="/Grab-It/all/Products" class="btn btn-warning"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							<td class="hidden-xs text-center"><strong>Total &#8377; <%= cartuser.getCart().getGrandTotal() %></strong></td>
							<td><a href="/Grab-It/cart/review" class="btn btn-success btn-block">Checkout <span class="glyphicon glyphicon-chevron-right"></span></a></td>
						</tr>
					</tfoot>
				</table>
		
		</c:when>
		
		<c:otherwise>
				<div class="jumbotron">
					<div class="text-center">
						<h1>Your cart is empty!</h1>
					</div>
				
				</div>
		
		</c:otherwise>
		
	</c:choose>

	
	
	
</div>
</body>
</html>