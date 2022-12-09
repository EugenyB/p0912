<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 09.12.2022
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Artist</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:useBean id="artist" scope="request" type="com.example.p0912.data.Artist"/>
    <form action="update_artist" method="post">
        <input type="text" name="name" value="${artist.name}">
        <input type="hidden" name="id" value="${artist.id}">
        <input type="submit" value="Update">
    </form>
</body>
</html>
