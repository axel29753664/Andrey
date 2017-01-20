<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<jsp:include page="../userPage.jsp"></jsp:include>

<input type="button" value="Bets management" onClick='location.href="${contextPath}/admin/betManagement"'>
<input type="button" value="Show all users from DB" onClick='location.href="${contextPath}/admin/userManagement"'>

</body>
</html>
