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
			<div class="col-lg-4"></div>

			<div class="col-lg-4">

				<div class="card">

					<div class="card-header bg-info text-white">

						<h4>Register Here</h4>

					</div>

					<div class="card-body">


						<sf:form class="form-horizontal" action="/Grab-It/handle/register"
							method="post" modelAttribute="user">
							
							<div class="form-group">
								<div class="row">
									<label for="firstName" class="col-lg-4 col-form-label">
										First Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="firstName"
											placeholder="Enter first name" />
										<sf:errors cssClass="help-block" path="firstName" element="em"
											style="color: red" />

									</div>
								</div>

							</div>
							
							<div class="form-group">
								<div class="row">
									<label for="lastName" class="col-lg-4 col-form-label">
										Last Name: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="lastName"
											placeholder="Enter last name" />
										<sf:errors cssClass="help-block" path="lastName" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="email" class="col-lg-4 col-form-label">
										Email: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="email"
											placeholder="Enter email" />
										<sf:errors cssClass="help-block" path="email" element="em"
											style="color: red" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="password" class="col-lg-4 col-form-label">Password
									</label>
									<div class="col-lg-8">
										<sf:input type="password" class="form-control" path="password"
											placeholder="Enter password" />
										<sf:errors cssClass="help-block" path="password" element="em"
											style="color: red" />

									</div>
								</div>

							</div>
							
							<div class="form-group">
								<div class="row">
									<label for="contactNumber" class="col-lg-4 col-form-label">
										Phone: </label>
									<div class="col-lg-8">
										<sf:input type="text" class="form-control" path="contactNumber"
											placeholder="Enter contact" />
										<sf:errors cssClass="help-block" path="contactNumber" element="em"
											style="color: red" />

									</div>
								</div>

							</div>
							
							<div class="form-group">
								<div class="row">
									<label for="role" class="col-lg-4 col-form-label">
										Select Role: </label>
									<div class="col-lg-8">
										<sf:radiobutton path="role" value="USER" label = "User" checked="chceked"/> 
  										<sf:radiobutton path="role" value="SUPPLIER" label = "Supplier"/> 
									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="Register" />

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