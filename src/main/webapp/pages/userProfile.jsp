<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User profile</title>
</head>
<body>
<jsp:include page="userPage.jsp"></jsp:include>

<form:form action="${contextPath}/userProfile" method="post" modelAttribute="user">
    <table>
        <c:set var="height" value="50"/>
        <form:hidden path="userId"/>
        <tr>
            <td height="${height}">Name:</td>
            <td><form:input path="firstName"/></td>
            <td><font color="red"><form:errors path="firstName"/></font></td>
        </tr>

        <tr>
            <td height="${height}">Lastname:</td>
            <td><form:input path="lastName"/></td>
            <td><font color="red"><form:errors path="lastName"/></font></td>
        </tr>

        <tr>
            <td height="${height}">Login:</td>
            <td>${user.login}</td>
            <form:hidden path="login"/>
            <td><font color="red"><form:errors path="login"/></font></td>
        </tr>

        <tr>
            <td height="${height}">Password:</td>
            <td><form:input path="password"/></td>
            <td><font color="red"><form:errors path="password"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Balance:</td>
            <td>${user.balance}</td>
            <form:hidden path="balance"/>
            <td><font color="red"><form:errors path="balance"/></font></td>
        </tr>
    </table>

    <input type="submit" value="Save"/>
</form:form>

</body>
</html>
