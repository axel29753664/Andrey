<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Bets</title>
</head>
<body>
<jsp:include page="userPage.jsp"></jsp:include>
<form>
    <input type="button" value="All bets" onClick='location.href="${contextPath}/allBets"'>
    <input type="button" value="Active bets" onClick='location.href="${contextPath}/activeBets"'>
</form>
</body>
</html>
