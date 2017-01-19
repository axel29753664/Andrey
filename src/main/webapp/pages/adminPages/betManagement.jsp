<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bets management</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>

<form name="userTable" action="betManagement" method="post">
    <table border="1">
        <tr>
            <td>UserID</td>
            <td>Firstname</td>
            <td>Lastname</td>
        </tr>
        <c:forEach items="${data}" var="user">
            <tr>
                <td> ${user.userId}</td>
                <td> ${user.firstName}</td>
                <td> ${user.lastName}</td>
                <td>
                    <label>
                        <input type="button" value="Show user's bets"
                               onclick="document.getElementById('userId').value = ${user.userId};
                                       document.userTable.submit(); "/>
                    </label>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="userId" value="" name="userIdForBetDeleting"/>
</form>
<input type="button" onclick="history.back();" value="Back"/>
</body>
</html>