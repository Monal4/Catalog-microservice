<!DOCTYPE html>

<jsp:include page="/includes/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

   <div class="fluid-container">
      <form class="form" action="Registered.html" method="POST">      
         <label>Email:</label>
         <input type="email" name="email" value="${email}"><br>
         <label>First Name:</label>
         <input type="text" name="firstName" value="${firstName}"><br>
         <label>Last Name:</label>
         <input type="text" name="lastName" value="${lastName}"><br>       
         <label>&nbsp;</label>
         <button class="btn btn-primary" type="submit">Register/login</button>
      </form>
   </div>

<jsp:include page="/includes/footer.jsp" />