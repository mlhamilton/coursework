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
        <form action="<c:url value='/order/showCart'/>" method="get" id="float_left">
            <input type="submit" value="View Products">
        </form>
    </body>
</html>