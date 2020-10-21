<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<jsp:include page="/includes/header.jsp" />

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

    <div class="container">
        <table class="table table-dark">
            <thead>
              <tr>
                <th scope="col">Product Description</th>
                <th scope="col">Quantity</th>
                <th scope="col">Price</th>
              </tr>
            </thead>
            <c:forEach items="${Products}" var="p">
                <tbody>
                    <tr>
                        <td>${p.description}</td>
                        <td>${p.quantity}</td>
                        <td>${p.price}</td>
                    </tr>
                </tbody>
            </c:forEach>
            <label style="float: left; font-weight: bold;">Sub Total: ${total}</label>
          </table>
    </div>

<jsp:include page="/includes/footer.jsp" />
