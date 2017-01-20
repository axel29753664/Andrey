<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event creation form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form:form method="post" action="createEventForm" modelAttribute="eventDTO">
    <table>
        <c:set var="height" value="50"/>
        <tr>
            <td height="${height}">Event name:</td>
            <td><form:input path="eventName"/></td>
            <td><font color="red"><form:errors path="eventName"/></font></td>

        </tr>
        <tr>
            <td height="${height}">Event Description:</td>
            <td><form:input path="eventDescription"/></td>
            <td><font color="red"><form:errors path="eventDescription"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Winning condition:</td>
            <td><form:input path="winningCondition"/></td>
            <td><font color="red"><form:errors path="winningCondition"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Lose condition:</td>
            <td><form:input path="loseCondition"/></td>
            <td><font color="red"><form:errors path="loseCondition"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Draw condition:</td>
            <td><form:input path="drawCondition"/></td>
            <td><font color="red"><form:errors path="drawCondition"/></font></td>
        </tr>
    </table>
    <input type="submit" value="Send"/>
</form:form>
</body>
</html>
