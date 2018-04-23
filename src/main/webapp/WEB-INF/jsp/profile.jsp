<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<head>
		<meta http-equiv="Content-Typt" content="text/html; charset=ISO-8859-1">
		<title>your Profile</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

	</head>
	<body>
	<div class="container">
<div class="row">


   
    <nav class="navbar navbar-toggleable-md navbar-light bg-success">
		  <a class="navbar-brand" href="#">${Users.name}</a>
		 
		</nav>

		<div class="container py-5">
			<div class="row">
				<div class="col-12">
					<img src="" alt="Profile page image" width="30%" height="40%" class="rounded-circle"/>
					<h2 class="py-3">${Users.dis} </h2>
					
				</div>
			</div>
		</div>  
    

</div>
</div>
		
	</body>
</html>


<!--  <nav class="navbar navbar-toggleable-md navbar-light bg-success">
		  <a class="navbar-brand" href="#">MANAV PATEL</a>
		 
		</nav>

		<div class="container py-5">
			<div class="row">
				<div class="col-12">
					<img src="" alt="Profile page image" width="30%" height="40%" class="rounded-circle"/>
					<h2 class="py-3"> </h2>
					
				</div>
			</div>
		</div>  -->