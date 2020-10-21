<%@page contentType="text/html" pageEncoding="utf-8"%>
<jsp:include page="/includes/header.jsp" />

<table>
<tr>
    <th>Song title</th>
    <th>Audio Format</th>
</tr>
<tr>
    <td>Filter</td>
    <!-- Changed from pg. 233 to point inside this web app -->
    <td><a href="/sound/${productCode}/filter.mp3">MP3</a></td>
</tr>
<tr>
    <td>So Long Lazy Ray</td>
    <td><a href="/sound/${productCode}/so_long.mp3">MP3</a></td>
</tr>
</table>

<p><a href="catalog.html">View list of albums</a></p>

<jsp:include page="/includes/footer.jsp" />