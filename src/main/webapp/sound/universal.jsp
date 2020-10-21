

<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html">
<html>
<head>
<title>Play sample</title>
</head>
<body>
	<p>Playing ${title} of CD ${productCode}</p>
	<audio controls autoplay>
		<source src="${src}" />
	</audio>

	<p>Playing ${title1} of CD ${productCode}</p>
	<audio controls autoplay>
		<source src="${src1}" />
	</audio>
	<c:url var="userWelcomeUrl" value="userWelcome.html" />
	<!-- <c:url var="cartURL" value="cart.html" />
	<c:url var="addToCartUrl" value="cart.html">
		<c:param name="addItem" value="true" />
	</c:url> -->
	<!-- <form method="get" action="cart.html">
			<input type="submit" value="${productCode}">
		</form> -->
		<li>
		<h1>Select Quantity of product and add to cart directly</h1>
		<form method="get" action="cart">
			<input type="number" name="productQuantity" value="Quantity" min="1" >
			<input type="hidden" name="productCode" value="${productCode}">
			<input type="submit" name="Add to Cart">
		</form></li>

<li><a href="cart.html">
    view Cart
</a></li>
	
	<UL><!-- <li><a href="${addToCartUrl}">Add to Cart</a></li> -->
		<li><a href="${userWelcomeUrl}">User Home </a></li>
		<!-- <li><a href="${cartURL}">View Cart</a></li> -->
	</UL>

</body>
</html>