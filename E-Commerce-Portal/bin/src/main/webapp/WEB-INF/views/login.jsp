<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Retail Products</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/style.css" />
<body class="img-background">
	<!-- navbar for the pages -->

	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="index.html">RetailProductManagement</a>
	</nav>
	<!-- login form for the user -->
	<div class="center">
		<form:form method="post" action="/authenticate" modelAttribute="login">
			<div class="text-danger">${error}</div>
			<div class="form-group">
				<form:label path="username">User Name</form:label>
				<form:input type="text" class="form-control" path="username" />
				<small id="username" class="form-text text-muted"> We'll
					never share your details with anyone else.</small>
			</div>
			<div class="form-group">
				<form:label path="password">Password</form:label>
				<form:input type="password" class="form-control" id="password"
					path="password" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary">Submit</button>
			</div>
		</form:form>
	</div>
</body>
</html>
