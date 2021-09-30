<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<title>Admin - Order Details</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="navbar-brand">Amazing Pizza</div>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="orders">Orders</a>
      </li>
    </ul>
    <a class="badge badge-warning" href="logout">Logout</a>
  </div>
</nav>
<div class="container mt-5 mb-5">
<div class="row">
<div class="col"></div>
<sf:form action="updateorder?id=${order.orderID}">
<div class="col row">
<div class="col-8 form-group">
<sf:select path="status" class="form-control">
	<sf:option value="Pending" label="Pending"/>
	<sf:option value="Dispatched" label="Dispatched"/>
	<sf:option value="Delivered" label="Delivered"/>
	<sf:option value="Paid" label="Paid"/>
</sf:select>
</div>
<div class="col-4 form-group"><input type="submit" value="Update Status" class="btn btn-primary"/></div>
</div>
</sf:form>
<div class="col"></div>
</div>

<div class="row">
<table class="table table-bordered">
<thead>
<tr><th colspan="2">Customer</th></tr>
</thead>
  <tbody>
    <tr>
      <th>ID</th>
      <td>${order.customer.customerID}</td>
    </tr>
    <tr>
      <th>Name</th>
      <td>${order.customer.name}</td>
    </tr>
    <tr>
      <th>Mobile</th>
      <td>${order.customer.mobile}</td>
    </tr>
    <tr>
      <th>Address</th>
      <td>${order.customer.address}</td>
    </tr>
    <tr>
      <th>Email</th>
      <td>${order.customer.email}</td>
    </tr>
  </tbody>
</table>
</div>

<div class="row">
<table class="table table-bordered">
<thead>
<tr><th colspan="2">Order</th></tr>
</thead>
  <tbody>
    <tr>
      <th>ID</th>
      <td>${order.orderID}</td>
    </tr>
    <tr>
      <th>Order Time</th>
      <td>${order.orderTime}</td>
    </tr>
    <tr>
      <th>Status</th>
      <td>${order.status}</td>
    </tr>
  </tbody>
</table>
</div>

<div class="row">
<table class="table table-bordered">
<thead>
<tr><th colspan="4">Order Details</th></tr>
<tr>
<th>Pizza</th>
<th>Type</th>
<th>Category</th>
<th>Size</th>
</tr>
</thead>
  <tbody>
	<c:forEach var="o" items="${order.orderDetailsList}">
    <tr>
      <td>${o.price.item.name}</td>
      <td>${o.price.item.type}</td>
      <td>${o.price.item.category}</td>
      <td>${o.price.sizes}</td>
    </tr>
	</c:forEach>
  </tbody>
</table>
</div>

</div>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>