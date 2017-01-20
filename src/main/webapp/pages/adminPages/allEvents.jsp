<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <td>Name</td>
            <td>Description</td>
            <td>Winning condition</td>
            <td>Lose condition</td>
            <td>Draw condition</td>
        </tr>
        <c:forEach items="${eventList}" var="event">
            <tr>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>
                <td> ${event.winningCondition}</td>
                <td> ${event.loseCondition}</td>
                <td> ${event.drawCondition}</td>
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