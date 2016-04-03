<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance - Cart</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

<h1>Products</h1>

<table>
  <tr>
    <th>Code</th>
    <th>Description</th>
    <th>Price</th>
    <th> </th>
    <th> </th>
  </tr>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach var="item" items="${products}">
  <tr>
    <td>${item.code}</td>
    <td>${item.description}</td>
    <td>${item.priceCurrencyFormat}</td>
    <td><a href="productMaint?action=editProduct&code=${item.code}">Edit</a></td>
    <td><a href="productMaint?action=deleteProduct&code=${item.code}">Delete</a></td>
  </tr>
</c:forEach>
</table>
  
<form action="productMaint" method="post">
  <input type="hidden" name="action" value="addProduct">
  <input type="submit" value="Add Product">
</form>

<!--
<form action="" method="post">
  <input type="hidden" name="action" value="shop">
  <input type="submit" value="Continue Shopping">
</form>

<form action="" method="post">
  <input type="hidden" name="action" value="checkout">
  <input type="submit" value="Checkout">
</form>
-->

</body>
</html>