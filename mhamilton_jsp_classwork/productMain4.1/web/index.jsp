<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance - Index</title>
    </head>
    <body>
        <h1>Product Maintenance</h1>
        <a href="<c:url value='/order/showCart'/>"/>
                    View Products</a>
        
<!--    Just reference junk from the add to cart button                   
        <form method="post" action="<c:url value='/order/addItem'/>">
            <input type="hidden" name="productCode" value="${product.code}">
            <input type="image" src="<c:url value='/images/addtocart.gif'/>" 
                   width="113" alt="Add to Cart">
-->
        
    </body>
</html>