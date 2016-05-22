<jsp:include page="/includes/header.jsp" />
<jsp:include page="/includes/column_left_all.jsp" />

<!-- begin middle column -->

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
                    <th>Code</th>   
                    <th>Description</th>
                    <th>Price</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach var="item" items="${products}">
                    <tr class="cart_row">
                        <td>${item.code}</td>
                        <td>${item.description}</td>
                        <td>${item.priceCurrencyFormat}</td>
                        <td>
                            <form action="<c:url value='/product/edit'/>" method="post">
                                <input type="hidden" name="productCode" 
                                       value="<c:out value='${item.code}'/>">
                                <input type="submit" value="Edit">
                            </form>                  
                        </td>
                        <td>
                            <form action="<c:url value='/product/removeItem'/>" method="post">
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


    <!--Go to add products page-->          
    <form action="<c:url value='/product/addPage'/>" method="get" id="float_left">
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

<!-- end middle column -->

<jsp:include page="/includes/footer.jsp" />