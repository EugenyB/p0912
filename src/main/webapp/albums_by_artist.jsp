<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: eugen
  Date: 09.12.2022
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Albums by Artist</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <jsp:useBean id="albumBean" type="com.example.p0912.beans.AlbumBean" scope="request"/>
    <h1>Artist - ${albumBean.artist.name}</h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Title</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${albumBean.albums}" var="a">
                <tr>
                    <td>${a.id}</td>
                    <td>${a.title}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
