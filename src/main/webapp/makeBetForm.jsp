<jsp:useBean id="user" scope="session" type="lv.javaguru.java2.domain.User"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make bet form</title>
</head>
<body>
<form action="makeBet" method="POST">
    <p>User ID: ${user.userId}</p>
    <input type="hidden" name="userID" value="4">
    <p>Event ID: ${eventId} </p>
    <input type="hidden" name="eventID" value="2">
    <p>Bet sum: <input type="number" min="1" name="betSum"></p>
    <p><input type="radio" name="winningCondition" value="FOR"> For
       <input type="radio" name="winningCondition" value="AGAINST"> Against</p>
    <input type="submit" value="Create Bet"/>
</form>
</body>
</html>
