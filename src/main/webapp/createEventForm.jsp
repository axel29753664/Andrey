<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Event creation form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post" action="createEventForm">
    <font color="red">${message}</font><br>
    <table>
        <tr>
            <td> Event name</td>
            <td><input type="text" name="eventName"/></td>
        </tr>
        <tr>
            <td>Event Description</td>
            <td><input type="text" name="eventDescription"/></td>
        </tr>
        <tr>
            <td>Winning condition</td>
            <td><input type="text" name="winningCondition"/></td>
        </tr>
        <tr>
            <td>Lose condition</td>
            <td><input type="text" name="loseCondition"/></td>
        </tr>
        <tr>
            <td>Draw condition</td>
            <td><input type="text" name="drawCondition"/></td>
        </tr>
    </table>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
