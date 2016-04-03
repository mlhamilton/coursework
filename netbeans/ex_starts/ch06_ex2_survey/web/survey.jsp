<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Thanks for taking our survey!</h1>

<p>Here is the information that you entered:</p>
<label>Email:</label>
<span>${user.email}</span><br>
<label>First Name:</label>
<span>${user.firstName}</span><br>
<label>Last Name:</label>
<span>${user.lastName}</span><br>
<label>Search Engine:</label>
<span>${user.heardFrom}</span><br>
<label>Updates:</label>
<span>${user.wantsUpdates}</span><br>
<c:if test="${user.wantsUpdates == 'Yes'}">
    <label>Contact Via:</label>
    <span>${user.contactVia}</span><br>
</c:if>

<p>To enter another email address, click on the Back 
button in your browser or the Return button shown 
below.</p>


<%-- How do I use post instead???--%>
<form action="index" method="get">
    <%-- Probably used for DB
    <input type="hidden" name="action" value="join">
    --%>
    <input type="submit" value="Return">
</form>