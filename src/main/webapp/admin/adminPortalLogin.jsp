<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="/includes/header.jsp" />

	<div class="fluid-container" id="registerationForm">
		<form action="AdminCredentials" method="POST">
			<input type="hidden" name="action" value="AdminCredentials">        
			<label class="pad_top">Admin First Name:</label>
			<input type="text" name="firstName" value="${firstName}"><br>
			<label class="pad_top">Admin Password:</label>
			<input type="text" name="password" value="${password}"><br>        
			<label>&nbsp;</label>
			<button class="btn btn-primary" type="submit" class="margin_left">login</button>
		</form>
	</div>

