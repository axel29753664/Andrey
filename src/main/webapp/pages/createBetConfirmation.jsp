<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.servlet.dto.BetDTO"--%>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.servlet.dto.UserDTO"--%>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.servlet.dto.EventDTO"--%>
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
                <td>User</td>
                <td>Event</td>
                <td>Event Description</td>
                <td>Bet sum</td>
                <td>Bet condition</td>
            </tr>
            <tr>
                <td> ${userDTO.firstName} ${userDTO.lastName}</td>
                <td> ${eventDTO.eventName}</td>
                <td> ${eventDTO.eventDescription}</td>
                <td> ${betDTO.betSum}</td>
                <td> ${betDTO.betCondition}</td>
            </tr>
        </table>
    </form>
</center>
<input type="button" onClick='location.href="${pageContext.request.contextPath}/events"' value="Back"/>
</body>
</html>