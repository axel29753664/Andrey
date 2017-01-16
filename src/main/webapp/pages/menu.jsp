<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
<form>
    <a href="login">Login</a>
    <a href="registration">Registration</a>
    <c:if test="${adminAccess == true}">
        <a href="adminPage"> AdminPanel </a>
    </c:if>
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="userPage"> ${pageContext.request.userPrincipal.name} </a>
        <a href="logout">logout </a>
    </c:if>
    <%--<sec:authorize access="hasRole('ROLE_ADMIN')">--%>
    <%--<a href="adminPage"> AdminPanel </a>--%>
    <%--</sec:authorize>--%>
</form>
</body>
</html>