<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>User management</title>
</head>
<body>
<jsp:include page="../adminPages/adminPage.jsp"></jsp:include>

<form name="userTable" id="userTable" action="${contextPath}/admin/userManagement" method="post">

    <table border="1">
        <tr>
            <td>User ID</td>
            <td>Login</td>
            <td>Password</td>
            <td>Firstname</td>
            <td>Lastname</td>
            <td>Roles</td>
            <td>Balance</td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${users}" var="user">

            <tr>
                <td><c:out value="${user.userId}"/></td>
                <td><c:out value="${user.login}"/></td>
                <td><c:out value="${user.password}"/></td>
                <td><c:out value="${user.firstName}"/></td>
                <td><c:out value="${user.lastName}"/></td>
                <td>
                    <table>
                        <tr>
                            <c:forEach items="${user.roles}" var="role">
                                <td> ${role.name}</td>
                            </c:forEach>
                        </tr>
                    </table>
                </td>
                <td><c:out value="${user.balance}"/></td>
                <td>
                    <label>
                        <input type="button" value="delete"
                               onclick="document.getElementById('delete').value = ${user.userId};
                                       document.userTable.submit(); "/>
                    </label>
                </td>
                <td>
                    <label>
                        <input type="button" value="update"
                               onclick="document.getElementById('update').value = ${user.userId};
                                       document.userTable.submit(); "/>
                    </label>
                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="delete" value="" name="deletedUserId"/>
    <input type="hidden" id="update" value="" name="updatedUserId"/>

</form>
</body>
</html>
