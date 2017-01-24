<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.User"--%>
<sec:authentication var="user" property="principal"/>
<html>
<head>
    <title>Bet creation form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post" action="createBetForm">
    <font color="red">${message}</font><br>
    <b>Selected event:</b>
    <table border="2">
        <tr>
            <td>Name</td>
            <td>Description</td>
            <td>Coefficient</td>
        </tr>
        <tr>
            <td> ${event.eventName}</td>
            <td> ${event.eventDescription}</td>
            <td> ${event.coefficient}</td>
        </tr>
    </table>
    <br>
    <br>
    <b>Now enter your bet amount and select condition:</b>
    <table>
        <input type="hidden" name="userID" value=${user.userId}>
        <input type="hidden" name="eventID" value=${event.eventId}>
        <tr>
            <td> Bet sum</td>
            <td><input type="number" step="0.01" name="betSum"/></td>
        </tr>

    </table>
    <input type="submit" value="Send"/>
    <input type="button" onClick='location.href="${pageContext.request.contextPath}/events"' value="Back"/>
</form>
</body>
</html>
