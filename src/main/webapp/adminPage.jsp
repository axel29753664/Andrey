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
<form name="myform" method="post" action="adminPage">
    <button type="submit" name="ShowUsers">Show all users from DB</button>

    <table border="1">
        <c:forEach items="${data}" var="user">
            <tr>
                <td>User ID: <c:out value="${user.userId}"/></td>
                <td>Login: <c:out value="${user.login}"/></td>
                <td>Password: <c:out value="${user.password}"/></td>
                <td>Firstname: <c:out value="${user.firstName}"/></td>
                <td>Lastname: <c:out value="${user.lastName}"/></td>
                <td>
                    <label>
                        <input type="checkbox" name="${user.userId}">
                    </label>

                </td>
            </tr>
        </c:forEach>
    </table>

    <button type="submit" name="delete">delete</button>


</form>

</body>
</html>
