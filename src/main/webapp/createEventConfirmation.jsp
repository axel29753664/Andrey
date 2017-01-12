<jsp:useBean id="event" scope="request" type="lv.javaguru.java2.domain.Event"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirmation</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<center>
    <form>
        <h1>Event created!</h1>
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
    </form>
</center>
</body>
</html>
