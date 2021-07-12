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
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="./style.css" />
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<body >
	<!-- navbar for the pages -->
	<nav class="navbar navbar-expand-md navbar-dark" style="background-color:rgba(53,57,66,255);">
            <a class="navbar-brand" href="/index"><i class="fa fa-arrow-circle-left"></i>&nbsp;Wish List</a>
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
	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->
	<c:forEach var="item" items="${list}">
		 <div class="col-md-10" >
            <div class="card card-body mt-2 mb-2">
                <div class="media align-items-center align-items-lg-start text-center text-lg-left flex-column flex-lg-row">
                    <div class="mr-2 mb-2 mb-lg-0"> <img src="${item.product.imageName}" width="300" height="220" alt=""> </div>
                    <div class="media-body">
                    	<br>
                        <h6 class="media-title font-weight-bold"> <a href="#" data-abc="true">${item.product.name}</a> </h6>
                        <p class="mb-3">${item.product.description}</p>
                    </div>
                    <div class="mt-3 mt-lg-0 ml-lg-3 text-center"><br><br><br>
                        <h3 class="mb-0 font-weight-bold">Rs. ${item.product.price}</h3>
					</div>
                </div>
            </div>
        </div>
	</c:forEach>
	<c:set var="error" value="${errorMEssage}" />
	<c:set var="errorHead" value="${errorHead}" />
	<div class="errorDiv" >
	<div style="color:white;">
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
	
</body>
</html>

