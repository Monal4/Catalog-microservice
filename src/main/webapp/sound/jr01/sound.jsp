<jsp:include page="/includes/header.jsp" />
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

  <!-- <div class="fluid-container" style="text-align: center;"> -->
    <table class="table">
      <thead>
        <tr>
          <th scope="col"><b>Song title</b></th>
          <th scope="col"><b>Audio Format</b></th>
        </tr>
      </thead>
      <tr>
        <td scope="col">1. Filter</td>
        <td scope="col">
          <audio src="/sound/jr01/filter.mp3" controls></audio>
        </td>
      </tr>
      <tr>
        <td scope="col">2. So Long Lazy Ray</td>
        <td scope="col">
          <audio src="/sound/jr01/so_long.mp3" controls></audio>
        </td>
      </tr>
    </table>
    
    <form class="form-inline" action="AddToCart">
      <div class="form-group mx-sm-3 mb-2">
        <input class="form-control" placeholder="Enter Quantity" type="number" name="quantity" min="1" max="10" value="${quantity}" required/>
        <input type="hidden" name="productCode" value="${productCode}"/>
      </div>
      <button type="submit" style="margin-right: 3px;" class="btn btn-primary mb-2">Add to cart</button>
      <a class="btn btn-secondary mb-2"  href="/"> Home </a>
    </form>
  <!-- </div> -->

<jsp:include page="/includes/footer.jsp" />
