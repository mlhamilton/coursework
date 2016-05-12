<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta charset="utf-8">
        <title>Product Maintenance - Product</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>


    <body>
        <h1>Product - Edit</h1>

        <p>* marks required fields</p>
        <i>${message}</i>
        <form action="productMaint" method="post">
            <label class="pad_top"> Code: </label>
            <input type="text" name="code" value="${item.product.code}" readonly><a style="color:red">${star}</a><br/>
            <label class="pad_top"> Description: </label>
            <input type="text" name="description" value="${item.product.description}" required><br/>
            <label class="pad_top"> Price: </label>
            <input type="text" name="price" value="${item.product.price}" required><br/>
            <input type="hidden" name="action" value="updateProduct">
            <input type="submit" value="Update Product">
        </form>

        <form action="<c:url value='/order/showCart'/>" method="get">
            <input type="submit" value="View Products">
        </form>   

<!--        <form action="productMaint" method="post">
            <input type="hidden" name="action" value="displayProducts">
            <input type="submit" value="View Products">
        </form>-->
        <p style="color:red">${updated_message}</p>
    </body>
</html>