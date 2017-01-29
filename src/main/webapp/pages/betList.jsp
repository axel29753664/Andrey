<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bets</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<form name="betsTable" action="betList">
    <table border="2">
        <tr>
            <td>Event</td>
            <td>Event Description</td>
            <td>Bet sum</td>
            <td>Bet condition</td>
        </tr>
        <c:forEach items="${betsDTO}" var="betDTO">
        <tr>
            <c:set var="conditionVariable" value ="true"/>
            <c:forEach items="${eventsDTO}" var="eventDTO">
                <c:if test="${conditionVariable eq 'true'}">
                    <c:if test="${betDTO.eventId==eventDTO.eventId}">
                        <td> ${eventDTO.eventName}</td>
                        <td> ${eventDTO.eventDescription}</td>
                        <c:set var="conditionVariable" value="false"/>
                    </c:if>
                </c:if>
            </c:forEach>
            <td> ${betDTO.betSum}</td>
            <td> ${betDTO.betCondition}</td>
        </c:forEach>
        </tr>
</table>
</form>
<input type="button" onclick="history.back();" value="Back"/>
</body>
</html>