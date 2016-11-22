<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Make bet form</title>
</head>
<body>
<form action="http://localhost:8080/java2/makeBet" method="POST">
    <p>User ID: 3</p>
    <input type="hidden" name="userID" value="3">
    <p>Event ID: 2</p>
    <input type="hidden" name="eventID" value="2">
    <p>Bet sum: <input type="number" min="1" name="betSum"></p>
    <p><input type="radio" name="winningChoice" value="FOR"> For
       <input type="radio" name="winningChoice" value="AGAINST"> Against</p>
    <input type="submit" value="Create Bet"/>
</form>
</body>
</html>
