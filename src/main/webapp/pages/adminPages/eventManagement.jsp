<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Event Management</title>
</head>
<body>
<jsp:include page="../adminPages/adminPage.jsp"></jsp:include>
<form>
    <input type="button" value="Show Active Events" onClick='location.href="${contextPath}/admin/activeEvents"'>
    <input type="button" value="Show All Events" onClick='location.href="${contextPath}/admin/allEvents"'>
</form>
</body>