<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.User"--%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<sec:authentication var="user" property="principal"/>
<html>
<head>
    <title>user page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form>
    <b> Hello ${user.firstName} ${user.lastName} You are login as "${user.login}" </b>

</form>
<form>

    <input type="button" value="Create Event"
           onClick='location.href="${contextPath}/createEventForm"'>
    <input type="button" value="Show events" onClick='location.href="${contextPath}/events"'>
    <input type="button" value="Show your's bets" onClick='location.href="${contextPath}/betList"'>

</form>
</body>
</html>
