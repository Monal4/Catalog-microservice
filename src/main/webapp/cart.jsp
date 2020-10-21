<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">	
<table class="table">
		<thead>
			<div class="fluid-container">
				<!-- <div class="d-flex flex-row bd-highlight mb-3">
					<div class="p-2 bd-highlight">Shopping Cart Items</div>
					<div class="d-flex flex-row-reverse bd-highlight">
						<div class="p-2 bd-highlight">Price</div>
					</div>
				</div> -->
				<tr>
					<th>Shopping Cart Items</th>
					<th class="text-right">Price</th> 
				</tr>
			</div>
		</thead>
	</table>
	  	<c:forEach items="${products}" var="p">
		<div class="border-bottom">	  
		  <div class="container">
			<div class="row align-items-center">
				<div class="col-4">
					${p.description}
				</div>
				<div class="col-2">
					${p.productId}
				</div>
				<div class="col-3">
					<div class="btn-group">
						<button type="button" class="btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							Qty: ${p.quantity}
						</button>
						<div class="dropdown-menu">
							<form class="form-inline" action="/Update/${p.productId}">
								<div class="form-group mb-2">
									<input type="number" value="${newQuantity}" name="newQuantity" class="form-control" id="staticEmail2" min="0" max="25" required>
									<button class="btn btn-primary" type="submit">Update</button>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="col-3 text-right">
					${p.price}
				</div>
				<br>
				<div class="col-3" style="margin-left: auto;">
					<form action="/remove/${p.productId}"> 
						<button class="btn btn-primary" style="float: right;" type="submit">Remove</button>
					</form>
				</div>
			</div>
		   </div>
		</div>
		<br>
		</c:forEach>
		<div class="container">
			<form class="form-inline" action="/checkout">
				<button class="btn btn-primary" type="submit" style="float: left;"> Checkout </button>
				<!-- &nbsp;&nbsp; -->
				<!-- <button class="btn btn-primary" style="margin-right: auto;" formaction="/"> Home </button> -->
				<label class="label text-right" style="margin-left: auto;"> Sub Total: ${Total}</label>
			</form>
		</div>
</div>

<!-- <a href="catalog.html"> continue shopping!</a> -->

<jsp:include page="/includes/footer.jsp" />
