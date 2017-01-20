<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form:form method="post" action="registration" modelAttribute="userDTOForm">
    <table>

        <tr>
            <td>Name:<font color="red"><form:errors path="firstName"/></font></td>
        </tr>
        <tr>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td>Lastname<font color="red"><form:errors path="lastName"/></font></td>
        </tr>
        <tr>
            <td><form:input path="lastName"/></td>
        </tr>


        <tr>
            <td>Login<font color="red"><form:errors path="login"/></font></td>
        </tr>
        <tr>
            <td><form:input path="login"/></td>
        </tr>

        <tr>
            <td>Password<font color="red"><form:errors path="password"/></font></td>
        </tr>
        <tr>
            <td><form:input path="password"/></td>
        </tr>

    </table>

    <input type="submit" value="Send"/>
</form:form>
</body>
</html>
