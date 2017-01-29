<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--@elvariable id="user" type="lv.javaguru.java2.domain.servlet.dto.BetDTO"--%>
<html>
<head>
    <title>Bet creation form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>

<form:form method="post" action="createBetForm" modelAttribute="betDTO">
    <table>
        <c:set var="height" value="50"/>
        <tr>
            <td><form:hidden path="userId"/> </td>
            <td><font color="red"><form:errors path="userId"/></font></td>
        </tr>
        <tr>
            <td><form:hidden path="eventId"/></td>
            <td><font color="red"><form:errors path="eventId"/></font></td>
        </tr>
        <tr>
            <td><form:hidden path="betCondition"/></td>
            <td><font color="red"><form:errors path="betCondition"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Bet Sum:</td>
            <td><form:input path="betSum"/></td>
            <td><font color="red"><form:errors path="betSum"/></font></td>
        </tr>
    </table>
    <table>
    <input type="submit" value="Send"/>
</form:form>
</body>
</html>