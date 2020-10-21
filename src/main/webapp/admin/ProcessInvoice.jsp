<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
<!-- <jsp:include page="/includes/navbar.jsp" /> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<section>
	<h3>List of UnProcessed Invoices: </h3>
	<br>
	<c:if test="${empty Invoices}">No Invoices Present at this time to process</c:if>
	<c:if test="${!empty Invoices}">
	<table border="1">
		<thead>
		<tr>
			<th>Id</th>
			<th>User</th>
			<th>Address</th>
			<th>InvoiceDate</th>
			<th>Amount</th>
		</tr>
	    </thead>
		<c:forEach items="${Invoices}" var="Invoices">
		<tr>
			<td>${Invoices.invoiceId}</td>
			<td>${Invoices.userFullName}</td>
			<td>${Invoices.userAddress}</td>
			<td>${Invoices.invoiceDate}</td>
			<td>${Invoices.totalAmount}</td>
		</tr>
	    </c:forEach>
	</table>
    
	<br>
	<form action="process" method="POST">
		Enter the ID to process: <input type="text" name="id">
		<input type="submit" name="Process" value="Process">
	</form>
	</c:if>
	<br>
	<ul>
	<li><a href="AdminPage.html">Back to Admin page</a></li>
    </ul>
</section>