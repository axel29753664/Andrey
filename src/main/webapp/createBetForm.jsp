<jsp:useBean id="user" scope="session" type="lv.javaguru.java2.domain.User"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            <td>Winning condition</td>
            <td>Lose condition</td>
            <td>Draw condition</td>
        </tr>
        <tr>
            <td> ${event.eventName}</td>
            <td> ${event.eventDescription}</td>
            <td> ${event.winningCondition}</td>
            <td> ${event.loseCondition}</td>
            <td> ${event.drawCondition}</td>
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
        <tr>
            <td> Condition</td>
            <td><input type="radio" name="betCondition" value="WIN"> Win
                <input type="radio" name="betCondition" value="LOSE"> Lose
                <input type="radio" name="betCondition" value="DRAW"> Draw </td>
        </tr>
    </table>
    <input type="submit" value="Send"/>
</form>
</body>
</html>
