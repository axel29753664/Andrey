<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event creation form</title>
</head>
<body>
<jsp:include page="userPage.jsp"></jsp:include>
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
            <td height="${height}">Winning condition description:</td>
            <td><form:input path="winDescription"/></td>
            <td><font color="red"><form:errors path="winDescription"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Coefficient:</td>
            <td><form:input path="coefficient"/></td>
            <td><font color="red"><form:errors path="coefficient"/></font></td>
        </tr>
        <tr>
            <form:form modelAttribute="betDTO">
                <td height="${height}">Bet Sum:</td>
                <td><form:input path="betSum"/></td>
                <td>
                    <font color="red"><form:errors path="userId"/></font>
                    <font color="red"><form:errors path="eventId"/></font>
                    <font color="red"><form:errors path="betSum"/></font>
                    <font color="red"><form:errors path="uncoveredSum"/></font>
                    <font color="red"><form:errors path="betCondition"/></font>
                </td>
            </form:form>
        </tr>
    </table>
    <input type="submit" value="Send"/>
</form:form>

</body>
</html>
