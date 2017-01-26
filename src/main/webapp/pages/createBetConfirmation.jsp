<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<center>
    <form>
        <h1>You made a bid!</h1>
        <table border="2">
            <tr>
                <td>UserID</td>
                <td>EventID</td>
                <td>BetSum</td>
                <td>BetCondition</td>
            </tr>
            <tr>
                <td> ${bet.userId}</td>
                <td> ${bet.eventId}</td>
                <td> ${bet.betSum}</td>
                <td> ${bet.betCondition}</td>
            </tr>
        </table>
    </form>
</center>
<input type="button" onClick='location.href="${pageContext.request.contextPath}/events"' value="Back"/>
</body>
</html>