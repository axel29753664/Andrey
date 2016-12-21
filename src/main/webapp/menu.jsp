<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>First page</title>
</head>
<body>
<form>
    <a href="login">Login</a>
    <a href="registration">Registration</a>

    <%! private String type = "hidden";%>
    <% if (user == null) {
        type = null;
    } %>
    <a type=<%= type %>; href="userPage"> ${user.login} </a>

</form>
</body>
</html>