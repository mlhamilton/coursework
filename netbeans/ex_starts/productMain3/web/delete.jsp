<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance - Delete</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>
<body>
    <h1>Are you sure you want to delete this product?</h1>
    
<form action="productMaint" method="post">
    <!--FIGURE THIS OUT-->
    Code: </label type="text" name="code" value="${product.code}"><br/>
    Description: ${product.description}<br/>
    Price: ${product.price}<br/>
  <input type="hidden" name="action" value="yesDelete">
  <input type="submit" value="Yes">
  <input type="hidden" name="action" value="displayProducts">
  <input type="submit" value="No">
</form>
    
</body>
</html>