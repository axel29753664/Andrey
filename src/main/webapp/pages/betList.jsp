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
        <c:forEach items="${bets}" var="bet">
            <tr>
                <td> ${bet.event.eventName}</td>
                <td> ${bet.event.eventDescription}</td>
                <td> ${bet.event.winnerStatus}</td>
                <td> ${bet.betCondition}</td>
                <td> ${bet.betSum}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>