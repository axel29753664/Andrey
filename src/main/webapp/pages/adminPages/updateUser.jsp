<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Update User</title>
</head>
<body>


<form method="post" action="${contextPath}/admin/userUpdate">
    <table border="1">
        <tr>
            <td>User ID</td>
            <td>Login</td>
            <td>Password</td>
            <td>Firstname</td>
            <td>Lastname</td>
            <td>Admin</td>
            <td>User</td>
            <td>Balance</td>
        </tr>
        <tr>
            <form:form modelAttribute="user">
            <td><form:input path="userId" readonly="true"/></td>
            <td><form:input path="login"/></td>
            <td><form:input path="password"/></td>
            <td><form:input path="firstName"/></td>
            <td><form:input path="lastName"/></td>
            <form:form modelAttribute="userRoles">
                <td><form:checkbox path="admin"/>Admin</td>
                <td><form:checkbox path="user"/>User</td>
            </form:form>
            <td><form:input path="balance"/></td>
        </tr>
        <tr>
            <td><font color="red"><form:errors path="userId"/></font></td>
            <td><font color="red"><form:errors path="login"/></font></td>
            <td><font color="red"><form:errors path="password"/></font></td>
            <td><font color="red"><form:errors path="firstName"/></font></td>
            <td><font color="red"><form:errors path="lastName"/></font></td>
            <form:form modelAttribute="userRoles">
                <%--<td><font color="red"><form:errors path="admin"/><form:errors path="user"/></font></td>--%>
            </form:form>
                <%--<td><font color="red"><form:errors path="balance"/></font></td>--%>
            </form:form>
        </tr>
    </table>
    <input type="submit" value="Update"/>
</form>
</body>
</html>
