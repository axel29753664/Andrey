<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
<form>
    <a href="login">Login</a>
    <a href="registration">Registration</a>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="userPage"> ${pageContext.request.userPrincipal.name} </a>
        <a href="logout">logout </a>
    </c:if>

</form>
</body>
</html>