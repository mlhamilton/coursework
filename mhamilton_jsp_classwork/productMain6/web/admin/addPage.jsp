<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- begin middle column -->

<section class="add">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <html>
        <head>
            <meta charset="utf-8">
            <title>Product Maintenance - Product</title>
            <link rel="stylesheet" href="styles/main.css" type="text/css"/>
        </head>


        <body>
            <h1>Product - Add</h1>
            <p>* marks required fields</p>
            <i>${message}</i>

            <form action="<c:url value='/product/addItem'/>" method="post" id="float_left">
                <label class="pad_top"> Code: </label>
                <input type="text" name="code" value="${product.code}" required> ${star}<br/>
                <label class="pad_top"> Description: </label>
                <input type="text" name="description" value="${product.description}" required> ${star}<br/>
                <label class="pad_top"> Price: </label>
                <input type="text" name="price" value="" required> ${star}<br/>
                <input type="hidden" name="action" value="addItem">
                <input type="submit" value="Add Product">
            </form>
        </body>

</section>
<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" /> 

</html>