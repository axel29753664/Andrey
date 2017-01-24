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
                <td>Coefficient</td>

            </tr>
            <tr>
                <td> ${event.eventName}</td>
                <td> ${event.eventDescription}</td>
                <td> ${event.coefficient}</td>

            </tr>
        </table>
    </form>
</center>
</body>
</html>
