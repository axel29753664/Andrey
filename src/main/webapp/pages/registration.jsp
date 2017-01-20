<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form:form method="post" action="registration" modelAttribute="userDTOForm">

    <table>
        <c:set var="height" value="50"/>
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
            <td><form:input path="login"/></td>
            <td><font color="red"><form:errors path="login"/></font></td>
        </tr>

        <tr>
            <td height="${height}">Password:</td>
            <td><form:input path="password"/></td>
            <td><font color="red"><form:errors path="password"/></font></td>
        </tr>


    </table>

    <input type="submit" value="Send"/>
</form:form>
</body>
</html>
