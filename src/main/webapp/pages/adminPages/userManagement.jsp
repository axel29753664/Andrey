<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User management</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>
<form name="userTable" id="userTable" action="${contextPath}/admin/userManagement" method="post">

    <table border="1">
        <tr>
            <td>User ID</td>
            <td>Login</td>
            <td>Password</td>
            <td>Firstname</td>
            <td>Lastname</td>
            <td>Balance</td>
            <td></td>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.userId}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td><c:out value="${user.balance}"/></td>
                <td>
                    <label>
                        <input type="button" value="delete"
                               onclick="document.getElementById('userId').value = ${user.userId};
                                       document.userTable.submit(); "/>
                    </label>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="userId" value="" name="deletedUserId"/>

    <input type="button" onclick="history.back();" value="Back"/>
</form>
</body>
</html>
