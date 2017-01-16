<%--@elvariable id="user" type="lv.javaguru.java2.domain.User"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>user page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form>
    <b> Hello ${user.firstName} ${user.lastName} You are login as "${pageContext.request.userPrincipal.name}" </b>

</form>
<form>

    <input type="button" value="Create Event" onClick='location.href="createEventForm"'>
    <input type="button" value="Show events" onClick='location.href="events"'>
    <input type="button" value="Show your's bets" onClick='location.href="bets"'>

</form>
</body>
</html>
