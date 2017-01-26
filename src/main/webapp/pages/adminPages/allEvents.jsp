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
            <td>Winning description</td>
            <td>Coefficient</td>
            <td>Total Bank</td>
            <td>Current bet side</td>
            <td>Winner</td>

        </tr>
        <c:forEach items="${eventList}" var="event" varStatus="i">
            <tr>
                <td> ${event.eventId}</td>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>
                <td> ${event.winDescription}</td>
                <td> ${event.coefficient}</td>
                <td> ${event.totalBank}</td>
                <td> ${event.betSide} </td>

                <td>
                    <select name="winnerStatus${event.eventId}">
                        <option>${event.winnerStatus}</option>
                        <option>WIN</option>
                        <option>LOSE</option>
                    </select>

                </td>
                <td>
                    <input type="checkbox" value="${event.eventId}" name="${i.index}">

                </td>
            </tr>
        </c:forEach>
    </table>

    <input type="button" value="update"
           onclick="document.getElementById('buttonId').value = 'update';
                   document.eventTable.submit(); "/>

    <input type="button" value="Delete"
           onclick="document.getElementById('buttonId').value ='delete';
                   document.eventTable.submit(); "/>

    <input type="hidden" id="buttonId" value="" name="buttonPressed"/>
    <input type="hidden" value="${eventList.size()}" name="eventListSize"/>


</form>
</body>