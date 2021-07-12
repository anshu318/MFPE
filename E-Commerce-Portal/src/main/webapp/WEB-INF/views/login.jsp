<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Retail Product Management</title>
        
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <style>
        @import url('https://fonts.googleapis.com/css?family=Numans');
        html,body {
          background-image: url('https://images.pexels.com/photos/1363876/pexels-photo-1363876.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=2000');
		  background-size: cover;
          background-repeat: no-repeat;
          height: 100%;
          font-family: 'Numans', sans-serif;
        }
        .container {
        	
			height: 100%;
			align-content: center;
           
        }
        .card{
height: 370px;
margin-top: auto;
margin-bottom: auto;
width: 400px;
background-color: rgba(0,0,0,0.5) !important;
border-radius: 5px;
}
        
        .signup_link
        {
            text-align: center;
            font-size: 16px;
        }
        .signup_link a
        {
            color: #0400fc;
            text-decoration: none;
        }
        .login
        {
            text-align: center;
            padding: 20px 0;
            border-bottom: 1px solid black;
        }
        .labe
        {
            font-weight: bold;
            color: white;
        }
        .login{
        	color:white;
        }
        .login_btn{
			color: black;
			background-color: #FF00FF;
			width: 100px;
			
		}

		.login_btn:hover{
			color: black;
			background-color: white;
		}
		.input-group-prepend span{
			width: 50px;
			background-color: #FF00FF;
			color: black;
			border:0 !important;
		}

		input:focus{
			outline: 0 0 0 0  !important;
			box-shadow: 0 0 0 0 !important;

		}

		.err{
			color: white;
		}
        </style>
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card" >
                	<div class="card-header">
                    <h1 class="login">Login UI</h1>
                    </div>
                    <div class="card-body">
                    <form:form method="post" action="/authenticate" modelAttribute="login">
                    
                        <div class="input-group form-group">
                            <div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-user"></i></span>
							</div>
                            <form:input type="text" class="form-control" path="username" placeholder="username"/>
                        </div>
                        <div class="input-group-prepend">
                            <div class="input-group-prepend">
								<span class="input-group-text"><i class="fas fa-key"></i></span>
							</div>
                            <form:input type="password" class="form-control" id="password" path="password" placeholder="password"/>
                        </div>
                        <br>
                        <div class="form-group">
							<input type="submit" value="Login" class="btn float-right login_btn" style="font-weight: bold;">
						</div>
						<br>
			            <div class="form-group col-md-12 err">${error} </div>
                    
                    </form:form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>