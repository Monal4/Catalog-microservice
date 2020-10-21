<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
<!-- <jsp:include page="/includes/navbar.jsp" /> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<section>
	<h3>List of UnProcessed Invoices: </h3>
	<br>
	<table border="1">
		<thead >
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
	<ul>
	<li><a href="ShowReport.html">Back</a></li>
	<li><a href="AdminPage.html" >Back to Admin page</a></li>
    </ul>
</section>