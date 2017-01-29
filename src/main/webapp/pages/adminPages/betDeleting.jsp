<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Bets deleting</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>

<form name="betsDeletingTable" action="${contextPath}/admin/betDeleting" method="post">
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
            <td>
                <label>
                    <input type="button" value="Delete bet"
                           onclick="document.getElementById('betId').value = ${betDTO.betId};
                                   document.betsDeletingTable.submit(); "/>
                </label>
            </td>
        </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="betId" value="" name="betIdForDeleting"/>

</form>
<input type="button" onClick='location.href="${pageContext.request.contextPath}/admin/betManagement"' value="Назад"/>
</body>
</html>