<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bet creation form</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form:form method="post" action="createBetForm" modelAttribute="betDTOForm">
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
            <td height="${height}">Bet Sum:</td>
            <td><form:input path="betSum"/></td>
            <td><font color="red"><form:errors path="betSum"/></font></td>
        </tr>
        <tr>
            <td height="${height}">Bet Condition:</td>
            <td><form:select path="betCondition">
                    <form:option value="NOT_APPLIED" label="--- Select ---"/>
                    <form:option value="WIN"/>
                    <form:option value="LOSE"/>
                </form:select>
            </td>
            <td><font color="red"><form:errors path="betCondition"/></font></td>
        </tr>
 </table>
 <input type="submit" value="Send"/>
</form:form>
</body>
</html>