<!DOCTYPE html>
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
    <form action="productMaint" method="post">
        <label class="pad_top"> Code: </label>
        <input type="text" name="code" value="${product.code}" required> ${star}<br/>
        <label class="pad_top"> Description: </label>
        <input type="text" name="description" value="${product.description}" required> ${star}<br/>
        <label class="pad_top"> Price: </label>
        <input type="text" name="price" value="${product.price}" required> ${star}<br/>
      <input type="hidden" name="action" value="sqlAddProduct">
      <input class="margin_left" type="submit" value="Add Product">
    </form>

    <form action="productMaint" method="post">
      <input type="hidden" name="action" value="displayProducts">
      <input tclass="margin_left" type="submit" value="View Products">
    </form>
    
</body>
</html>