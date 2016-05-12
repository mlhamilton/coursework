
<section class="cart">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<h1>Products</h1>
  <c:choose>
      <c:when test="${emptyCart != null}">
          <p>Your cart is empty.</p>
      </c:when>
      <c:otherwise>
        <table>
           <tr>
            <th>Qty</th>
            <th>Description</th>
            <th>Price</th>
            <th>Amount</th>
            <th>&nbsp;</th>
         </tr>
         <c:forEach var="item" items="${products}">
            <tr class="cart_row">
<%--              
                <td>
                <form action="<c:url value='/order/updateItem'/>" method="post">
                  <input type="hidden" name="productCode" 
                         value="<c:out value='${item.code}'/>">
                  <input type="submit" value="Update">
                  <input type=text name="quantity" 
                         value="<c:out value='${item.quantity}'/>" id="quantity">
                </form>                  
              </td>
--%>
<!--          Replacing item.product. with product.-->
              <td>${item.description}</td>
              <td>${item.priceCurrencyFormat}</td>
<%--              <td>${item.totalCurrencyFormat}</td>--%>
              <td>
                <form action="<c:url value='/order/editItem'/>" method="post">
                  <input type="hidden" name="productCode" 
                         value="<c:out value='${item.code}'/>">
                  <input type="submit" value="Edit">
                </form>                  
              </td>
              <td>
                <form action="<c:url value='/order/removeItem'/>" method="post">
                  <input type="hidden" name="productCode" 
                         value="<c:out value='${item.code}'/>">
                  <input type="submit" value="Remove">
                </form>                  
              </td>
            </tr>
          </c:forEach>
          </table>
      </c:otherwise>
  </c:choose>

          
<!--AddProducts button goes to add products JSP page-->          
<form action="<c:url value='/order/addPage'/>" method="get" id="float_left">
  <input type="submit" value="Add Product">
</form>


<%--<c:if test="${emptyCart == null}">
    <!-- Connection is NOT SECURE.  For testing only. -->
    <form action="<c:url value='/order/checkUser'/>" method="post">
      <input type="submit" value="Checkout">
    </form>
    <!-- Connection is SECURE.  Before you can use it, you need to configure 
    a secure connection on your system as described in chapter 15, comment
    out the previous form, and remove the comments from the following form. -->
    <!--
    <form action="${absolutePathSecure}/order/checkUser" method="post">
      <input type="submit" value="Checkout">
    </form>
    -->
</c:if>--%>

    
</section>
