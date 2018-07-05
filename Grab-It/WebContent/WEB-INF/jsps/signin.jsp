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
					<div id="alertCard" class="alert card bg-warning text-white">${message}</div>
				</div>
			</div>
		</c:if>


		<div class="row">
			<div class="col-lg-4"></div>

			<div class="col-lg-4">

				<div class="card">

					<div class="card-header bg-info text-white">

						<h4>Sign In</h4>

					</div>

					<div class="card-body">


						<sf:form class="form-horizontal" action="/Grab-It/handle/login"
							method="post" modelAttribute="login">

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
									<label class="col-lg-4 col-form-label"></label>
									<div class="col-lg-8">
										<input type="submit" class="btn bg-info text-white"
											value="Sign in" />

									</div>
								</div>

							</div>

							<div class="form-group">
								<div class="row">
									<label for="register" class="col-lg-4 col-form-label">
									</label>
									<div class="col-lg-8">
										<a href="/Grab-It/register/user" class="btn btn-warning"><span
											class="glyphicon glyphicon-registration-mark">Register</span></a>

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