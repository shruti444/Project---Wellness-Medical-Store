<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<title>Admin - Orders</title>
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

<div class="container p-3">
<div class="row">
<div class="col"></div>
<sf:form action="orders">
<div class="col row">
<div class="col-8 form-group">
<sf:select path="status" class="form-control">
<sf:option value="%" label="All"/>
<c:forEach var="s" items="${status}">
<sf:option value="${s}" label="${s}"/> 
</c:forEach>
</sf:select>
</div>
<div class="col-4 form-group"><input type="submit" value="Fetch Orders" class="btn btn-primary"/></div>
</div>
</sf:form>
<div class="col"></div>
</div>
<div class="row">
<div class="col">
<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Customer</th>
      <th scope="col">Order Time</th>
      <th scope="col">Status</th>
      <th scope="col">Details</th>
      <th scope="col">Update Status</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="o" items="${orders}">
    <tr>
      <th scope="row">${o.orderID}</th>
      <td>${o.customer.name}</td>
      <td>${o.orderTime}</td>
      <td>${o.status}</td>
      <td><a href="orderdetails?id=${o.orderID}">Details</a></td>
      <td>
      <sf:form action="updateorder?id=${o.orderID}">
		<sf:select path="status">
		<sf:option value="Pending" label="Pending"/>
		<sf:option value="Dispatched" label="Dispatched"/>
		<sf:option value="Delivered" label="Delivered"/>
		<sf:option value="Paid" label="Paid"/>
		</sf:select>
		<input type="submit" value="Update Status"/>
		</sf:form>
      </td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</div>
</div>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>