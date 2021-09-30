<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Sign Up</title>
</head>
<body class="h-100" id="login-body">
	<div class="container h-100">
	<div class="row h-100">
	<div class="col-lg-4 rounded my-auto p-3" id="login-box">
	<sf:form method="post" action="register">
	  <div class="form-group">
	    <label for="name">Name :</label>
	    <sf:input path="name" class="form-control" />
	  </div>
	  <div class="form-group">
	    <label for="mobile">Mobile :</label>
	    <sf:input path="mobile" class="form-control" />
	  </div>
	  <div class="form-group">
	    <label for="address">Address :</label>
	    <sf:input path="address" class="form-control" />
	  </div>
	  <div class="form-group">
	    <label for="email">Email :</label>
	    <sf:input path="email" class="form-control" />
	  </div>
	  <div class="form-group">
	    <label for="password">Password :</label>
	    <sf:password path="password" class="form-control" />
	  </div>
	  <input type="submit" value="Register" class="btn btn-primary" />
	  <a href="login">Back to login</a>
	</sf:form>
	</div>
	</div>
	</div>
	
	
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>