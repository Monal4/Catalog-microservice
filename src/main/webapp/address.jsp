<!DOCTYPE html>

<jsp:include page="/includes/header.jsp" />
<!-- <jsp:include page="/includes/navbar.jsp" /> -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<p align = center>Enter Your Address!</p>
<section align=center>
	<form action="addAddress.html" method="get">
     <input type="hidden" name="email" value="${email}">    

    <label class="pad_top">address:</label>
    <input type="text" name="address" value="${address}"><br>
   
    <input type="submit" value="UpdateAddress" class="margin_left">
</form>
</section>
<jsp:include page="/includes/footer.jsp" />