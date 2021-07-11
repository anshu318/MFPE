<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Retail Product Management</title>
<style>
    html,body
        {
            height: 100%;
            margin: 0;
            background-attachment: fixed;
			background-position: center;
			background-repeat: no-repeat;
			background-size: cover;   
			background-color: #a4508b;
			background-image: linear-gradient(326deg, #a4508b 0%, #5f0a87 74%);
        }
        
.bg-custom-1 {
  background-color: #85144b;
}

.bg-custom-2 {
background-image: linear-gradient(15deg, #13547a 0%, #80d0c7 100%);
}
</style>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="./style.css" />
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<body >
	<!-- navbar for the pages -->
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color:rgba(53,57,66,255);">
            <a class="navbar-brand" href="/index"><i class="fa fa-arrow-circle-left"></i>&nbsp;Cart</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>  
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
    				<li class="nav-item">
      					<a class="nav-link" href="/getWishlist"><i class="fas fa-heart"></i>&nbsp;Wish List</a>
    				</li>
    				<li class="nav-item">
      					<a class="nav-link" href="/getCart"><i class="fas fa-cart-arrow-down"></i>&nbsp;Cart</a>
    				</li>
    				<li class="nav-item">
    	  				<a class="nav-link" href="/logout"><i class="fa fa-power-off"></i>&nbsp;Logout</a>
    				</li>
				</ul>
            </div>   
        </nav>
	<div class="container">
		<div class="row">
			<c:set var="totalPrice" value="${0}" />
			<c:set var="delivery" value="${0}" />
			<c:forEach var="item" items="${cartList}">
				<c:set var="totalPrice"
					value="${totalPrice+(item.product.price*item.quantity)}" />
				<c:set var="delivery"
					value="${delivery+(item.vendor.deliveryCharge*item.quantity)}" />
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
							<h5 id="price">
								Rating : ${item.product.rating} <i style="font-size: 15px"
									class="fa">&#xf005;</i>
							</h5>
							<div class="form-group edit-rating">
								<div class="right">
									<h5>
										Quantity:<span class="" value="${item.quantity}">${item.quantity}</span>
									</h5>
								</div>
							</div>
							<div>
								<span id="vendor_id">Vendor Id:${item.vendor.vendorId}</span><br>
								<span id="vendor_name">Vendor Name:${item.vendor.vendorName}</span><br>
								<span id="zipCode">Delivering to ZipCode:${item.zipCode}
								</span> <br> <span id="expectedDeliveryDate">Expected
									Delivery Date:${item.deliveryDate} </span>
							</div>
						</div>

					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<c:set var="error" value="${errorMessage}" />
	<c:set var="errorHead" value="${errorHead}" />

	<div class="errorDiv">
		<div class="alert">
			<strong>${errorHead}</strong><br>${error}</div>
	</div>

	<div class="table" style="background-color: white">
		<table id="example" style="width: 100%; color:black">
			<thead>
				<tr>
					<th id="price">Price</th>
					<th id="delivery">Delivery Charge</th>
					<th id="total">Total</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${totalPrice}</td>
					<td>${delivery}</td>
					<td>${totalPrice+delivery}</td>
				</tr>
			</tbody>
			<tfoot>

			</tfoot>
		</table>
	</div>

	<!-- close the loop  -->



	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

	
</body>

</html>
