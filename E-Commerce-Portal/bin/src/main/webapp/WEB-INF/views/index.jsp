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
<title>Retails Product</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="/style.css" />
<link rel="stylesheet" href="/rating.css" />

<body class="mainPageBody" >

	<!-- navbar for the pages -->
	<nav class="navbar navbar-expand-lg navbar-dark ">
		<a class="navbar-brand" href="/index">RetailProductMangement</a>
		<button class="navbar-toggler btn-danger" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon btn-danger"></span>
		</button>
		<div class="collapse navbar-collapse buttom-danger" id="navbarSupportedContent">
			<form class="form-inline my-2 my-lg-0" action="/searchByName"
				method="get">
				<input class="form-control mr-sm-2" type="text" placeholder="Search"
					name="search" id="search" /> <input
					class="btn btn-outline-danger my-2 my-sm-0" type="submit"
					value="Submit">
			</form>
			<a href="/getWishlist">
				<button class="btn btn-outline-danger my-2 mx-5 my-sm-0"
					type="submit">
					<i style="font-size: 20px" class="fa">WishList</i>
				</button>
			</a>
			<form action="/getCart" method="post">
				<a href="">
					<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">
						<i style="font-size: 30px" class="fa">&#xf07a;</i>
					</button>

				</a>
			</form>
			<a href="/logout">
				<button class="btn btn-outline-danger my-2 mx-5 my-sm-0"
					type="submit">
					<i style="font-size: 20px" class="fa">Logout</i>
				</button>
			</a>

		</div>
	</nav>
	<!-- body section of the page use jsp -->
	<!-- use loop to fetch the data and display it -->
	<div class="container">
		<div class="row">
			<!-- add a single item fech from database  -->
			<c:forEach var="item" items="${list}">
				<div class="card my-4 mx-4 color display" style="width: 18rem">
					<img src="${item.imageName}" class="card-img-top img-height"
						alt="..." />
					<div class="card-body">
						<h5 class="card-title">${item.name}</h5>
						<p class="card-text">${item.description}</p>
						<h5 class="price">
							<strong>Price : ${item.price}</strong>
						</h5>
						
						<span id="rating">Rating:${item.rating} <i
							style="font-size: 15px" class="fa">&#xf005;</i></span>
						<div class="date_field">
							Expected Date:<span class="date">12/10/2020</span>
						</div>
						<section class="o-container">
							<!-- Rating Stars Box -->
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
								<li class="c-rating-star__item" title="Excellent" data-value="4">
									<i class="fa fa-star fa-fw c-rating-star__icon"></i>
								</li>
								<li class="c-rating-star__item" title="WOW!!!" data-value="5">
									<i class="fa fa-star fa-fw c-rating-star__icon"></i>
								</li>
							</ul>
						</section>
						<span id="resultSpan"></span>
						<button class="btn btn-warning addcart" id="" data-toggle="modal"
							data-target="#myModal" onClick="configureProductId(${item.id})">Add
							to Cart</button>
						<button class="btn btn-warning addcart" id="${item.id}"
							data-toggle="modal" data-target="#wishListModal"
							onClick="configureProductId(${item.id})">Add to Wishlist</button>

					</div>
				</div>
			</c:forEach>
			<!-- modal starts -->
			<div class="modal" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Add to cart</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<!-- Modal body -->
						<div class="modal-body">

							<div class="input-group">
								<span class="input-group-btn"> 
								</span> <label>Quantity</label><br> <input type="number"
									name="quant[1]" id="quantity" class="form-control input-number"
									value="1" min="1"> <br> <label>Zip Code</label> <input
									type="text" id="zipcode" class="form-control input-number"
									value="1" min="1" max="10">
								<button class="btn btn-warning addcart" onClick="addToCart()">Add
									to Cart</button>
								<br>
								<div class="alert alert-success" id="messageSpanCart"></div>
							</div>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal"
								onClick="emptyModalCart()">Close</button>
						</div>

					</div>
				</div>
			</div>
			<!-- modal ends -->
			<!-- modal starts -->
			<div class="modal" id="wishListModal">
				<div class="modal-dialog">
					<div class="modal-content">

						<!-- Modal Header -->
						<div class="modal-header">
							<h4 class="modal-title">Add to Wishlist</h4>
							<button type="button" class="close" data-dismiss="modal">&times;</button>
						</div>
						<!-- Modal body -->
						<div class="modal-body">

							<div class="input-group">
								<span class="input-group-btn">
								</span> <label>Quantity</label><br> <input type="number"
									name="quant[1]" id="quantityWish"
									class="form-control input-number" value="1" min="1" max="10">
								<button class="btn btn-warning addcart"
									onClick="addToWishList()">Add to Wishlist</button>
								<br>
								<div class="alert alert-success" id="messageSpanWishlist"></div>
							</div>
						</div>

						<!-- Modal footer -->
						<div class="modal-footer">
							<button type="button" class="btn btn-danger" data-dismiss="modal" onclick="emptyModalWishList()">
								Close</button>
						</div>

					</div>
				</div>
			</div>
			<!-- modal ends -->
			<!-- close the loop  -->
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
		alert(zipCode);
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
                $('#messageSpanCart').append(obj.message);
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
          let id = e.target.parentElement.parentElement;
        
          let url='/addProductRating/'+id.id+"/"+val;
          console.log(url);
          $.ajax({
            url: url,
            type: "POST",
            data: val,
            success: function () {
              //alert("Save Complete");
            	document.location.reload(true);
            },
          });
          
        });
      }

     </script>
</body>
</html>
