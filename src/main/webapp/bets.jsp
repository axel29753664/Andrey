<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bets</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<form name="betsTable" action="bets">
    <table border="2">
        <tr>
            <td>UserID</td>
            <td>EventID</td>
            <td>BetSum</td>
            <td>BetCondition</td>
        </tr>
        <c:forEach items="${data}" var="bet">
            <tr>
                <td> ${bet.userId}</td>
                <td> ${bet.eventId}</td>
                <td> ${bet.betSum}</td>
            </tr>
        </c:forEach>
    </table>
</form>
    <input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>