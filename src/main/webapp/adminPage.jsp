<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>
<html>
<head>
    <title>Admin page</title>
</head>
<body>
<jsp:include page="userPage.jsp"></jsp:include>
<form method="post" action="adminPage">

    <button name="ShowUsers" onclick="showForm()">
        Show all users from DB
    </button>

</form>

<form name="userTable" id="userTable" action="adminPage" method="post">

    <table border="1">
        <tr>
            <td>User ID</td>
            <td>Login</td>
            <td>Password</td>
            <td>Firstname</td>
            <td>Lastname</td>
            <td></td>
        </tr>
        <c:forEach items="${data}" var="user">
            <tr>
                <td><c:out value="${user.userId}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
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


</form>

</body>
</html>
