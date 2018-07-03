<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

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

						<sf:form class="form-horizontal"
							action="/Grab-It/manage/addProduct" method="post"
							modelAttribute="product" enctype="multipart/form-data">

							<div class="form-group">
								<div class="row">
									<label for="name" class="col-lg-4 col-form-label">Product
										Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="name"
											placeholder="Product Name" />
										<sf:errors cssClass="help-block" path="name" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="brand" class="col-lg-4 col-form-label">Brand
										Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="brand"
											placeholder="Brand Name" />
										<sf:errors cssClass="help-block" path="brand" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="description" class="col-lg-4 col-form-label">Description:
									</label>
									<div class="col-lg-8">
										<sf:textarea class="form-control" path="description" rows="4"></sf:textarea>
										<sf:errors cssClass="help-block" path="description"
											element="em" style="color: red" />
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="unitPrice" class="col-lg-4 col-form-label">Unit
										Price: </label>
									<div class="col-lg-8">
										<sf:input type="number" class="form-control" path="unitPrice"
											placeholder="Price per unit" />

										<sf:errors cssClass="help-block" path="unitPrice" element="em"
											style="color: red" />
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="quantity" class="col-lg-4 col-form-label">Quantity:
									</label>
									<div class="col-lg-8">
										<sf:input type="number" class="form-control" path="quantity"
											placeholder="Quantity" />
									</div>
								</div>

							</div>


							<div class="form-group">
								<div class="row">
									<label for="file" class="col-lg-4 col-form-label">Upload
										an image: </label>
									<div class="col-lg-8">
										<sf:input type="file" class="form-control" path="file" />
										<sf:errors cssClass="help-block" path="file" element="em"
											style="color: red" />
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="category" class="col-lg-4 col-form-label">Category:
									</label>
									<div class="col-lg-8">
										<sf:select path="category_id" items="${categoryList}"
											itemLabel="name" itemValue="id" class="form-control" />

									</div>
								</div>

							</div>


							<c:if test="${product.id == 0 }">

								<div class="text-right">
									</br>
									<button type="button" data-toggle="modal"
										data-target="#myCategoryModal" class="btn btn-warning"
										style="height: 20px; padding: 0px">Add Category</button>

								</div>

							</c:if>

							<div class="form-group">
								<div class="row">
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="Submit" />
										<sf:input type="hidden" path="id" />
										<sf:input type="hidden" path="supplier_id" />
										<sf:input type="hidden" path="purchases" />
										<sf:input type="hidden" path="code" />
										<sf:input type="hidden" path="views" />
										<sf:input type="hidden" path="isActive" />


									</div>
								</div>

							</div>

						</sf:form>

					</div>
				</div>
			</div>
		</div>

		</br>
		</br>

		<div class="row">


			<div class='col-lg-12'>
				<h3>Available Products</h3>
				</hr>

			</div>

			<div class='col-lg-12'>

				<div style="overflow: auto">

					<table id="adminproductsTable"
						class="table table-striped table-bordered">

						<thead>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Qty. Avail</th>
								<th>Unit Price</th>
								<th>Activate</th>
								<th>Edit</th>
							</tr>
						</thead>

						<tfoot>
							<tr>
								<th>Id</th>
								<th>&#160;</th>
								<th>Name</th>
								<th>Brand</th>
								<th>Qty. Avail</th>
								<th>Unit Price</th>
								<th>Activate</th>
								<th>Edit</th>
							</tr>
						</tfoot>


					</table>
				</div>


			</div>


		</div>




			<!-- Modal -->
	<div class="modal fade" id="myCategoryModal" tabindex="-1" role="dialog">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">New Category</h4>
	      </div>
	      <div class="modal-body">
	        
	        <sf:form id="categoryForm" class="form-horizontal" modelAttribute="category" action="${contextRoot}/manage/category" method="POST">
	        	
       			<div class="form-group">
								<div class="row">
									<label for="category_name" class="col-lg-4 col-form-label">Category Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="name" />
									</div>
								</div>

				</div>
       			
       			<div class="form-group">
								<div class="row">
									<label for="category_description" class="col-lg-4 col-form-label">Description: </label>
									<div class="col-lg-8">
										<sf:textarea rows="4" class="form-control" path="description"></sf:textarea>
									</div>
								</div>

				</div>	        	        
	        
	        
				<div class="form-group">
								<div class="row">
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="save" />
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