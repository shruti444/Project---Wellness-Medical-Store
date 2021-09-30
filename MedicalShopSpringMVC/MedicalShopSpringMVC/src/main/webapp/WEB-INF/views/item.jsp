<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css">
<title>Menu - Item</title>
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
        <a class="nav-link" href="types">Menu</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="cart">Cart</a>
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
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item"><a href="types">${param.type}</a></li>
    <li class="breadcrumb-item"><a href="categories?type=${param.type}">${param.category}</a></li>
    <li class="breadcrumb-item"><a href="items?type=${param.type}&category=${param.category}">${item.name}</a></li>
  </ol>
</nav>

<div class="container">
<div class="row">
<div class="col"></div>
<div class="col-8">
<table class="table table-bordered">
  <tbody>
    <tr>
      <th>ID</th>
      <td>${item.itemID}</td>
    </tr>
    <tr>
      <th>Name</th>
      <td>${item.name}</td>
    </tr>
    <tr>
      <th>Type</th>
      <td>${item.type}</td>
    </tr>
    <tr>
      <th>Category</th>
      <td>${item.category}</td>
    </tr>
    <tr>
      <th>Description</th>
      <td>${item.description}</td>
    </tr>
    <tr>
      <th>Available Sizes</th>
      <td>
      <c:forEach var="s" items="${item.itemPricesList}">
      <c:out value="${s.sizes}, " />
      </c:forEach>
      </td>
    </tr>
  </tbody>
</table>
</div>
<div class="col"></div>
</div>
<sf:form action="addtocart">
<div class="row">
<div class="col-2"></div>
<c:forEach var="p" items="${item.itemPricesList}">
<div class="col">
<sf:radiobutton path="price" value="${p.itemPriceID}" label="${p.sizes}"/><br />Rs. ${p.price}/-
</div>
</c:forEach>
<div class="col-2"></div>
</div>
<br />
<div class="row">
<div class="col offset-2"><input type="submit" value="Add to Cart" class="btn btn-primary" /></div>
</div>
</sf:form>
</div>

<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script src="https://unpkg.com/@popperjs/core@2"></script>
</body>
</html>