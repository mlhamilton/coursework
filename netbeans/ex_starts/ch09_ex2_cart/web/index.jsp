<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>

    
<%--Cycling through a text list of items instead of statically stating them--%>    
<h1>CD list</h1>
<table>
    <tr>
        <th>Description</th>
        <th class="right">Price</th>
        <th>&nbsp;</th>
    </tr>
  <c:forEach var="item" items="${products}">
    <tr>
            <td>${item.description}</td>
            <td>${item.priceCurrencyFormat}</td>
            <td>
                <form action="cart" method="post">
                    <input type="hidden" name="productCode" value="8601">
                    <input type="submit" value="Add To Cart">
                </form>
            </td>
    </tr>
  </c:forEach>
 
<%--
        <td>86 (the band) - True Life Songs and Pictures</td>
        <td class="right">$14.95</td>
        <td>
            <form action="cart" method="post">
                <input type="hidden" name="productCode" value="8601">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Paddlefoot - The first CD</td>
        <td class="right">$12.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Paddlefoot - The second CD</td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="pf02">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
    <tr>
        <td>Joe Rut - Genuine Wood Grained Finish</td>
        <td class="right">$14.95</td>
        <td><form action="cart" method="post">
                <input type="hidden" name="productCode" value="jr01">
                <input type="submit" value="Add To Cart">
            </form></td>
    </tr>
--%>
</table>
        
</body>
</html>