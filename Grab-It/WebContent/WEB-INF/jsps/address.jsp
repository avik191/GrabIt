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

						<h4>Billing Address</h4>

					</div>

					<div class="card-body">


						<sf:form class="form-horizontal" action="/Grab-It/handle/address"
							method="post" modelAttribute="address">

							<div class="form-group">
								<div class="row">
									<label for="addressLineOne" class="col-lg-4 col-form-label">
										Address line 1: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control"
											path="addressLineOne" placeholder="Address line 1" />
										<sf:errors cssClass="help-block" path="addressLineOne"
											element="em" style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="addressLineTwo" class="col-lg-4 col-form-label">
										Address line 2: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control"
											path="addressLineTwo" placeholder="Enter address line 2" />
										<sf:errors cssClass="help-block" path="addressLineTwo"
											element="em" style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="city" class="col-lg-4 col-form-label">
										City: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="city"
											placeholder="Enter city" />
										<sf:errors cssClass="help-block" path="city" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="state" class="col-lg-4 col-form-label">State:
									</label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="state"
											placeholder="Enter state" />
										<sf:errors cssClass="help-block" path="state" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="country" class="col-lg-4 col-form-label">
										country: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="country"
											placeholder="Enter country" />
										<sf:errors cssClass="help-block" path="country" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="postalCode" class="col-lg-4 col-form-label">
										Postal Code: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="postalCode"
											placeholder="Enter Postal Code" />
										<sf:errors cssClass="help-block" path="postalCode"
											element="em" style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="Add Address" />
										<sf:input type="hidden" path="userID" />
										<sf:input type="hidden" path="billing" />
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