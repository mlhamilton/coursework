<!DOCTYPE html>
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
            <input type="text" name="code" value="${product.code}" readonly><br/>
            <label class="pad_top"> Description: </label>
            <input type="text" name="description" value="${product.description}" required><br/>
            <label class="pad_top"> Price: </label>
            <input type="text" name="price" value="${product.price}" required><br/>


          <input type="hidden" name="action" value="updateProduct">
          <input type="submit" value="Update Product">
        </form>

        <form action="productMaint" method="post">
          <input type="hidden" name="action" value="displayProducts">
          <input type="submit" value="View Products">
        </form>
    
</body>
</html>