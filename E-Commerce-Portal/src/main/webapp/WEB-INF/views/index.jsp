<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%> --%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Retail Product Management</title>
<link rel="icon"
	href="https://cdn.icon-icons.com/icons2/2389/PNG/512/shopify_logo_icon_144894.png"
	type="image/x-icon">
<style>
html, body {
	height: 100%;
	margin: 0;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	background-color: #a4508b;
	background-image: linear-gradient(326deg, #a4508b 0%, #5f0a87 74%);
}

.form-inline {
	position: absolute;
	left: 50%;
	transform: translatex(-50%);
}

input[type="text"] {
	border: 0px;
	border-radius: 0%;
	outline: none;
}

.search-button {
	border-radius: 0%;
	border: 0%;
}

.form-group {
	width: 100%;
	padding: 0px;
}

.input-group {
	width: 90% !important;
}

.modeldata {
	width: 90% !important;
	margin-right: 10px;
	padding-left: 10px;
	padding-right: 10px;
}

.bg-custom-1 {
	background-color: #85144b;
}

.bg-custom-2 {
	background-image: linear-gradient(15deg, #13547a 0%, #80d0c7 100%);
}

body {
	margin: 0;
	font-family: Roboto, -apple-system, BlinkMacSystemFont, "Segoe UI",
		Roboto, "Helvetica Neue", Arial, sans-serif, "Apple Color Emoji",
		"Segoe UI Emoji", "Segoe UI Symbol", "Noto Color Emoji";
	font-size: .8125rem;
	font-weight: 400;
	line-height: 1.5385;
	color: #333;
	text-align: left;
	background-color: #f5f5f5
}

.mt-50 {
	margin-top: 50px
}

.mb-50 {
	margin-bottom: 50px
}

.bg-teal-400 {
	background-color: #26a69a
}

a {
	text-decoration: none !important
}

.ft {
	font-family: "Curlz MT", sans;
}



</style>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />

<link rel="stylesheet" href="/rating.css" />
<script src='https://kit.fontawesome.com/a076d05399.js'
	crossorigin='anonymous'></script>

<body class="mainPageBody">


	<!-- navbar for the pages -->
	<nav class="navbar navbar-expand-md navbar-dark"
		style="background-color: rgba(53, 57, 66, 255);">
		<h2 style="color: white;" class="ft">
			<i class="fab fa-shopify"></i>&nbsp;Shopper.com
		</h2>


		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			
			<form class="form-inline fixed-center my-2 my-lg-0"
				action="/searchByName" method="get">
				<input class="form-control mr-sm-2" type="text"
					placeholder="Search..." name="search" id="search" />
				<button class="btn btn-primary my-20 my-sm-0" type="submit">
					<i class="fa fa-search" style="color: white;"></i>
				</button>
			</form>
			
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a href="/getWishlist" class="nav-link"><i
						class="fas fa-heart"></i>&nbsp;Wish List</a></li>
				<li class="nav-item"><a href="/getCart" class="nav-link"><i
						class="fas fa-cart-arrow-down"></i>&nbsp;Cart</a></li>
				<li class="nav-item"><a href="/logout" class="nav-link"><i
						class="fa fa-power-off"></i>&nbsp;Logout</a></li>
			</ul>
		</div>
	</nav>
	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->
	<div class="container d-flex justify-content-center mt-50 mb-50">
		<div class="row">
			<c:forEach var="item" items="${list}">
				<div class="col-md-10">
					<div class="card card-body mt-2 mb-2">
						<div
							class="media align-items-center align-items-lg-start text-center text-lg-left flex-column flex-lg-row">
							<div class="mr-2 mb-2 mb-lg-0">
								<img src="${item.imageName}" width="300" height="220" alt="">
							</div>
							<div class="media-body">
								<br>
								<h6 class="media-title font-weight-bold">
									<a href="#" data-abc="true">${item.name}</a> <a href="#"
										class="badge badge-success"><span id="rating">${item.rating}</span></a>
								</h6>

								<p class="mb-3">${item.description}</p>
							</div>
							<div class="mt-3 mt-lg-0 ml-lg-3 text-center">
								<h3 class="mb-0 font-weight-bold">Rs. ${item.price}</h3>
								<section class="o-container">
									<ul class="c-rating-star u-text-center js-rating-star"
										data-name="test" id="${item.id}">
										<li class="c-rating-star__item" title="Poor" data-value="1">
											<i class="fa fa-star fa-fw c-rating-star__icon"></i>
										</li>
										<li class="c-rating-star__item" title="Fair" data-value="2">
											<i class="fa fa-star fa-fw c-rating-star__icon"></i>
										</li>
										<li class="c-rating-star__item" title="Good" data-value="3">
											<i class="fa fa-star fa-fw c-rating-star__icon"></i>
										</li>
										<li class="c-rating-star__item" title="Excellent"
											data-value="4"><i
											class="fa fa-star fa-fw c-rating-star__icon"></i></li>
										<li class="c-rating-star__item" title="WOW!!!" data-value="5">
											<i class="fa fa-star fa-fw c-rating-star__icon"></i>
										</li>
									</ul>
								</section>
								<button class="btn btn-primary btn-block addcart" id=""
									data-toggle="modal" data-target="#myModal"
									onClick="configureProductId(${item.id})">Add to Cart</button>
								<button class="btn btn-secondary btn-block addcart"
									id="${item.id}" data-toggle="modal"
									data-target="#wishListModal"
									onClick="configureProductId(${item.id})">Add to
									Wishlist</button>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- modal starts -->
	<div class="modal" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add to cart</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-btn"> </span><label>Quantity</label> <input
							type="number" name="quant[1]" id="quantity"
							class="form-control input-number modeldata" value="1" min="1">
						<br> <br> <span class="input-group-btn"> </span><label>Zip
							Code</label> <input type="number" id="zipcode"
							class="form-control input-number modeldata" value="1" min="1">
						<br> <br>

						<button class="btn btn-primary btn-block addcart"
							data-dismiss="modal" onClick="addToCart()">Add to Cart</button>
						<div id="messageSpanCart"></div>
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>
	<!-- modal ends -->
	<!-- modal starts -->
	<div class="modal" id="wishListModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Add to Wishlist</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>
				<div class="modal-body">
					<div class="input-group">
						<span class="input-group-btn"> </span> <label>Quantity</label> <input
							type="number" name="quant[1]" id="quantityWish"
							class="form-control input-number modeldata" value="1" min="1"
							max="10"> <br> <br>

						<button class="btn btn-secondary btn-block addcart"
							data-dismiss="modal" onClick="addToWishList()">Add to
							Wishlist</button>
						<div id="messageSpanWishlist"></div>
					</div>
					<br>
				</div>
			</div>
		</div>
	</div>

	</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
	<script src="rating.js"></script>
	<script>
	var productId;
	function configureProductId(id)
	{
		productId=id;
		document.getElementById("messageSpanWishlist").innerHTML = "";
		document.getElementById("messageSpanCart").innerHTML = "";
	}
	function addToWishList()
	{
		var response='';
		var x=document.getElementById("quantityWish").value;
		
		//alert(x);
		document.getElementById("messageSpanWishlist").innerHTML = "";
		var json={"customerId":1,"productId":productId,"quantity":x};
		$.ajax({
        type: "POST",
        url: "/addToCustomerWishlist",
        async: false,
        dataType : "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(json),
        success: function(data){   
            //alert("data "+data.message);
            $('#messageSpanWishlist').append(data.message);
        }
    });
	xhttp.send(JSON.stringify(json));
	}
	function addToCart()
	{
		var x=document.getElementById("quantity").value;
		var xhttp = new XMLHttpRequest();
		var response='';
		var zipCode=document.getElementById("zipcode").value;
		document.getElementById("messageSpanCart").innerHTML = "";
		//alert(zipCode);
		var json={"productId":productId,"customerId":1,"zipcode":zipCode,"quantity":x};
		$.ajax({
            type: "POST",
            url: "/addToCart",
            async: false,
            dataType : "json",
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(json),
            success: function(data){   
                //alert("data "+data.message);
                var obj=JSON.parse(data.message);
                //alert(obj.hasOwnProperty("message"));
                $('#messageSpanCart').append(data.message);
            }
        });
		
	}

      const date = document.getElementsByClassName("date");
      const myrating = document.getElementsByClassName("my-rating");
      var today = new Date();
      var tomorrow = new Date();
      tomorrow.setDate(today.getDate() + 7);
      tomorrow = JSON.stringify(tomorrow);
      tomorrow = tomorrow.slice(1, 11);
      tomorrow = tomorrow.split("-").reverse();
      console.log(tomorrow);
      tomorrow = tomorrow[0] + "-" + tomorrow[1] + "-" + tomorrow[2];
      for (i of date) {
        i.innerText = tomorrow;
      }

      const container = document.getElementsByClassName("o-container");
      for (let topElement = 0; topElement < container.length; topElement++) {
        container[topElement].addEventListener("click", function (e) {
          let parent = e.target.parentElement.parentElement;
        
          let url='/addProductRating/'+parent.id+"/"+val;
          $.ajax({
            url: url,
            type: "POST",
            data: val,
            success: function () {
              //alert("Save Complete");
            	window.location.reload();
            	},
          });
          $(document).ajaxStop(function(){
        	    window.location.reload();
        	});
        });
      }

      $(document).ready(function(){
    	    $("#search").focus(function() {
    	      $(".search-box").addClass("border-searching");
    	      $(".search-icon").addClass("si-rotate");
    	    });
    	    $("#search").blur(function() {
    	      $(".search-box").removeClass("border-searching");
    	      $(".search-icon").removeClass("si-rotate");
    	    });
    	    $("#search").keyup(function() {
    	        if($(this).val().length > 0) {
    	          $(".go-icon").addClass("go-in");
    	        }
    	        else {
    	          $(".go-icon").removeClass("go-in");
    	        }
    	    });
    	    $(".go-icon").click(function(){
    	      $(".search-form").submit();
    	    });
    	});
     </script>
</body>
</html>


