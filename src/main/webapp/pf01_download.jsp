<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Downloads (but this JSP is not in use in this version of the project)</h1>

<h2>Paddlefoot - The First CD</h2>
    
<table>
<tr>
    <th>Song title</th>
    <th>Audio Format</th>
</tr>
<tr>
    <td>64 Corvair</td>
     <!-- Fixed from pg. 233 to point inside this web app -->
    <td><a href="/sound/${productCode}/corvair.mp3">MP3</a></td>
</tr>
<tr>
    <td>Whiskey Before Breakfast</td>
    <td><a href="/sound/${productCode}/whiskey.mp3">MP3</a></td>
</tr>
</table>

<p><a href="?action=viewAlbums">View list of albums</a></p>

<p><a href="?action=viewCookies">View all cookies and session variables</a></p>

</body>
</html>