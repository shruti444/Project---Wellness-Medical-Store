<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<title>Cart</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="navbar-brand">Amazing Pizza</div>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="types">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link active" href="cart">Cart</a>
      </li>
    </ul>
    <c:choose>
	    <c:when test="${empty customer}">
	    	<c:set var="custName" value="anonymous" />
	    	<c:set var="loginVar" value="Login" />
	    </c:when>
	    <c:otherwise>
	    	<c:set var="custName" value="${customer.getName()}" />
	    	<c:set var="loginVar" value="Logout" />
	    </c:otherwise>
    </c:choose>
    <div class="text-light mr-3">Hello, ${custName}!</div>
    <div><a class="badge badge-warning" href="logout">${loginVar}</a></div>
  </div>
</nav>
<c:set var="total" value="0.0"/>
<c:forEach var="i" items="${cart}">
<c:set var="total" value="${total + i.price}"/>
</c:forEach>

<div class="container mt-5">
<div class="row">
<table class="table table-bordered">
<thead>
<tr><th colspan="5">Order Details</th></tr>
<tr>
<th>Pizza</th>
<th>Type</th>
<th>Category</th>
<th>Size</th>
<th>Price</th>
</tr>
</thead>
  <tbody>
	<c:forEach var="i" items="${cart}">
    <tr>
      <td>${i.item.name}</td>
      <td>${i.item.type}</td>
      <td>${i.item.category}</td>
      <td>${i.sizes}</td>
      <td>${i.price}</td>
    </tr>
	</c:forEach>
	<tr>
	    <td colspan="4">Total Bill</td>
	    <td>${total}</td>
    </tr>
  </tbody>
</table>
<form action="placeorder"><input type="submit" value="Place Order" class="btn btn-primary" /></form>
</div>
</div>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>