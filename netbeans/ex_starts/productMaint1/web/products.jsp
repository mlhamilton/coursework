<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance Project</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

    
<%--Cycling through a text list of items instead of statically stating them--%>    
<h1>CD list</h1>
<table>
    <tr>
        <th>Code</th>
        <th class="right">Description</th>
        <th class="right">Price</th>
        <th>Edit</th>
        <th>Delete</th>
        <th>&nbsp;</th>
    </tr>
  <c:forEach var="item" items="${products}">
    <tr>
            <td>${item.code}</td>
            <td>${item.description}</td>
            <td>${item.priceCurrencyFormat}</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="8601">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
            <td><a href="/edit">Edit</a></td>
            <td><a href="/delete">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<form action="" methond="post">
    <input type="hidden" name="action" value="addProduct">
    <input type="submit" value="Add Product">
</form>
        
</body>
</html>