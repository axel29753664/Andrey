<%--@elvariable id="event" type="lv.javaguru.java2.domain.Event"--%>
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
            <td>Winner</td>
            <td>Status</td>
        </tr>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td> ${event.eventId}</td>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>

                <td>
                    <select name="select${event.eventId}">
                        <option>${event.winnerStatus}</option>
                        <option>WIN</option>
                        <option>LOSE</option>
                    </select>

                </td>
                <td>
                    ${event.betSide}
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
    <input type="submit">
    <input type="hidden" id="eventId" value="" name="deletedEventId"/>
</form>
<input type="button" onclick="history.back();" value="Back"/>
</body>