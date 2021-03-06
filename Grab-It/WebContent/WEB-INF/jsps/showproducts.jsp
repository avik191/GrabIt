<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="container">

		<div class="row">

			<div class="col-lg-3">
				<%@ include file="sidebar.jsp"%>
			</div>

			<div class="col-lg-9">
				</br>

				<!-- adding breadcrum component -->

				<div class="row">
					<div class="col-lg-12">

						<c:if test="${isAllProducts == true }">

							<script>
								window.categoryId = '';
							</script>


							<ol class="breadcrumb">
								<li><a href="/Grab-It/home">Home</a></li>
								<li class="active">/All Products</li>
							</ol>

						</c:if>

						<c:if test="${isCategoryProduct == true }">

							<script>
								window.categoryId = '${category.id}';
							</script>

							<ol class="breadcrumb">
								<li><a href="/Grab-It/home">Home</a></li>
								<li class="active">/Category</li>
								<li class="active">/${category.name }</li>
							</ol>

						</c:if>


					</div>
				</div>

				<div class="row">

					<div class="col-lg-12">

						<table id="tableProductList"
							class="table table-striped table-borderd">
							<thead>
								<tr>	
									<th></th>					
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Quantity</th>
									<th></th>
								</tr>
							</thead>
							
							<tfoot>
								<tr>		
									<th></th>					
									<th>Name</th>
									<th>Brand</th>
									<th>Price</th>
									<th>Quantity</th>
									<th></th>
								</tr>
							</tfoot>

						</table>

					</div>
				</div>
			</div>

		</div>
	</div>

</body>
</html>