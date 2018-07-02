<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	</br>
	<div class="container">


		<c:if test="${not empty message}">	
			<div class="row">	
				<div class="col-lg-2"></div>		
				<div class="col-lg-8">			
					<div id="alertCard" class="alert card bg-success text-white">${message}</div>				
				</div>
			</div>
		</c:if>
		
		<div class="row">
			<div class="col-lg-2"></div>

			<div class="col-lg-8">

				<div class="card">

					<div class="card-header bg-info text-white">

						<h4>Product Management</h4>

					</div>

					<div class="card-body">

						<sf:form class="form-horizontal" action="/Grab-It/manage/addProduct" method="post" modelAttribute="product">

							<div class="form-group">
								<div class="row">
									<label for="name" class="col-lg-4 col-form-label">Product
										Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control"  path="name"
											placeholder="Product Name" /> 
											<sf:errors cssClass="help-block" path="name" element="em"
											style="color: red"/>

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="brand" class="col-lg-4 col-form-label">Brand
										Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" 
											path="brand" placeholder="Brand Name" /> 
											<sf:errors cssClass="help-block" path="brand" element="em"
											style="color: red"/>

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="description" class="col-lg-4 col-form-label">Description:
									</label>
									<div class="col-lg-8">
										<sf:textarea class="form-control"
											path="description" rows="4"></sf:textarea>
											<sf:errors cssClass="help-block" path="description" element="em"
											style="color: red"/>
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="unitPrice" class="col-lg-4 col-form-label">Unit
										Price: </label>
									<div class="col-lg-8">
										<sf:input type="number" class="form-control" 
											path="unitPrice" placeholder="Price per unit" />
											
											<sf:errors cssClass="help-block" path="unitPrice" element="em"
											style="color: red"/>
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="quantity" class="col-lg-4 col-form-label">Quantity:
									</label>
									<div class="col-lg-8">
										<sf:input type="number" class="form-control" 
											path="quantity" placeholder="Quantity" />
									</div>
								</div>

							</div>
							
							<div class="form-group">
								<div class="row">
									<label for="category" class="col-lg-4 col-form-label">Category:
									</label>
									<div class="col-lg-8">
									<sf:select path="category_id" items="${categoryList}" itemLabel="name" itemValue="id" class="form-control"/>

									</div>
								</div>

							</div>

					

							<div class="form-group">
								<div class="row">
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="Submit" /> 
											
											
										<input type="hidden"  path="id">
										<input type="hidden"  path="supplier_id">
										<input type="hidden"  path="purchases"> 
										<input type="hidden"  path="code"> 
										<input type="hidden" path="views"> 
										<input type="hidden"  path="isActive">


									</div>
								</div>

							</div>

						</sf:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>