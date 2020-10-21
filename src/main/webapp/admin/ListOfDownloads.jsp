<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />
<!-- <jsp:include page="/includes/navbar.jsp" /> -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<section>
	<h3>List of Downloads : </h3>
	<br>
	<table border="1">
		<thead >
		<tr>
			<th>Email</th>
			<th>Product</th>
			<th>Track</th>
			<th>DownloadDate</th>
		</tr>
	    </thead>
		<c:forEach items="${allDown}" var="download">
		<tr>
			<td>${download.emailAddress}</td>
			<td>${download.productCode}</td>
			<td>${download.trackTitle}</td>
			<td>${download.downloadDate}</td>
		</tr>
	</c:forEach>
	</table>
	<br>
	<ul>
	<li><a href="ShowReport.html">Back</a></li>
	<li><a href="AdminPage.html" >Back to Admin page</a></li>
    </ul>
</section>