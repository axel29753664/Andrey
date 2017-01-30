<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bets</title>
</head>
<body>
<jsp:include page="bets.jsp"></jsp:include>

<form name="betsTable">
    <table border="2">
        <tr>
            <td>Event name</td>
            <td>Event Description</td>
            <td>Event winner side</td>
            <td>Bet condition</td>
            <td>Bet sum</td>

        </tr>
        <c:forEach items="${betEventMap}" var="betEvent">
            <tr>
                <td> ${betEvent.value.eventName}</td>
                <td> ${betEvent.value.eventDescription}</td>
                <td> ${betEvent.value.winnerStatus}</td>
                <td> ${betEvent.key.betCondition}</td>
                <td> ${betEvent.key.betSum}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>