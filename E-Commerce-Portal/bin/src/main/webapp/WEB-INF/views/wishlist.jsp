<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link rel="stylesheet" href="./style.css" />
<body class="otherPageBody">
	<!-- navbar for the pages -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="/index">RetailProductManagement</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form action="/getCart" method="post">
				<a href="">
					<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">
						<i style="font-size: 30px" class="fa">&#xf07a;</i>
					</button>
				</a>
			</form>
		</div>
	</nav>
	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->
	<c:forEach var="item" items="${list}">
		<div class="container">
			<div class="row">
				<!-- add a single item fech from database  -->
				<div class="col-sm">
					<div class="card my-4 color" style="width: 18rem">
						<img src="${item.product.imageName}"
							class="card-img-top img-height" alt="..." />
						<div class="card-body">
							<h5 class="card-title">${item.product.name}</h5>
							<p class="card-text">${item.product.description}</p>

							<h5 class="price">
								<strong>Price :${item.product.price}</strong>
							</h5>
							<h5 class="price">
								<strong>Quantity :${item.quantity}</strong>
							</h5>
							<br> <span id="rating">Rating :
								${item.product.rating} <i style="font-size: 15px" class="fa">&#xf005;</i>
							</span> <br>
							<button class="btn btn-warning addcart" id="${item.product.id}">Add
								to Cart</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</c:forEach>
	<c:set var="error" value="${errorMEssage}" />
	<c:set var="errorHead" value="${errorHead}" />
	<div class="errorDiv" >
	<div class="alert">
  <strong>${errorHead}</strong><br>${error}</div>
  </div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script>
		$('.addcart').click(function(e) {
			var tomorrow = new Date();
			tomorrow = JSON.stringify(tomorrow);
			tomorrow = tomorrow.slice(1, 11);
			tomorrow = tomorrow.split("-").reverse();
			console.log(tomorrow);
			tomorrow = tomorrow[0] + "-" + tomorrow[1] + "-" + tomorrow[2];

			const id = e.target.id;
			console.log(id);
			console.log(tomorrow);
			const url = 'addProductToCart/' + id + '/' + tomorrow;
			console.log(url);
			console.log(typeof url);
			$.ajax({
				url : url,
				type : "POST",
				data : {
					expectedDeliveryDate : tomorrow
				},
				success : function() {
					// alert("Save Complete");
				},
			});

		});
	</script>
</body>
</html>

