<%@ page import="lv.javaguru.java2.domain.WinnerStatus" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Events</title>
</head>
<body>
<jsp:include page="../adminPages/eventManagement.jsp"></jsp:include>


<form name="eventTable" action="${contextPath}/admin/allEvents" method="post">
    <table border="2">
        <tr>
            <td>Event ID</td>
            <td>Name</td>
            <td>Description</td>
            <td>Winning condition</td>
            <td>Lose condition</td>
            <td>Draw condition</td>
            <td>Winner</td>
            <td>Status</td>
        </tr>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td> ${event.eventId}</td>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>
                <td> ${event.winningCondition}</td>
                <td> ${event.loseCondition}</td>
                <td> ${event.drawCondition}</td>
                <td>
                    <form:select path="winner">
                        <form:option value="0" label="${event.winnerStatus}"/>
                        <form:options items="${winner}"/>
                    </form:select>
                </td>
                <td>
                    <form:select path="eventsStatus">
                        <form:option value="0" label="${event.eventStatus}"/>
                        <form:options items="${eventsStatus}"/>
                    </form:select>
                </td>
                <td>
                    <label>
                        <input type="button" value="Delete"
                               onclick="document.getElementById('eventId').value = ${event.eventId};
                                       document.eventTable.submit(); "/>
                    </label>

                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="eventId" value="" name="deletedEventId"/>
</form>
<input type="button" onclick="history.back();" value="Back"/>
</body>