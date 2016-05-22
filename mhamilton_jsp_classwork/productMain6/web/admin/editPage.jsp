<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- begin middle column -->

<html>
    <head>
        <meta charset="utf-8">
        <title>Product Maintenance - Product</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>
        <h1>Product - Edit</h1>
        <i>${message}</i>
        <form action="<c:url value='/product/editItem'/>" method="post" id="float_left">
            <label class="pad_top"> Code: </label>
            <input type="text" name="code" value="${product.code}" readonly><a style="color:red">${star}</a><br/>
            <label class="pad_top"> Description: </label>
            <input type="text" name="description" value="${product.description}" required><br/>
            <label class="pad_top"> Price: </label>
            <input type="text" name="price" value="${product.price}" required><br/>

            <input type="hidden" name="action" value="editItem">

            <input type="hidden" name="id"  value="${product.id}">
            <label>Product ID = ${product.id}</label> <br/>
            <input type="submit" value="Update Product">
        </form> 
        <form action="<c:url value='/product/showCart'/>" method="get">
            <input type="hidden" name="action" value="showCart">
            <input type="submit" value="Show Cart">
        </form>
        <p style="color:red">${updated_message}</p>
    </body>
</html>

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />