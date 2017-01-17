<%@taglib prefix="sec"
          uri="http://www.springframework.org/security/tags" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menu</title>
</head>
<body>
<form>
    <a href="${pageContext.request.contextPath}/login">Login</a>
    <a href="${pageContext.request.contextPath}/registration">Registration</a>

    <sec:authorize access="hasRole('ROLE_ADMIN')">
        <a href="${pageContext.request.contextPath}/admin/adminPage"> AdminPanel </a>
    </sec:authorize>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <a href="${pageContext.request.contextPath}/userPage"> ${pageContext.request.userPrincipal.name} </a>
        <a href="${pageContext.request.contextPath}/logout">logout </a>
    </c:if>

</form>
</body>
</html>