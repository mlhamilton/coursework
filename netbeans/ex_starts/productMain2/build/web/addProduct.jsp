<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Product Maintenance - Product</title>
    <link rel="stylesheet" href="styles/main.css" type="text/css"/>
</head>


<body>
    <h1>Product</h1>
<form action="productMaint" method="post">
    Code: <input type="text" name="code" value="" ><br/>
    Description: <input type="text" name="description" value=""><br/>
    Price: <input type="text" name="price" value=""><br/>
    

  <input type="hidden" name="action" value="updateProduct">
  <input type="submit" value="Add Product">
</form>
    
<form action="productMaint" method="post">
  <input type="hidden" name="action" value="displayProducts">
  <input type="submit" value="View Products">
</form>
    
</body>
</html>