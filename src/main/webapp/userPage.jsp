<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>
<html>
<head>
    <title>user page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    <input type="submit" value="logout"/>

    <h1> Hello ${user.firstName} ${user.lastName} </h1>
    <h1> You are login as "${user.login}" </h1>
    <%--<%! private String button;%>--%>
    <%--<% if ((user.getLogin() != null) && (user.getLogin().equalsIgnoreCase("vasja"))) {--%>
        <%--button = "<input type=\"submit\" value=\"logout\"/>";--%>
    <%--}--%>
    <%--%>--%>
    <%--<%= button %>--%>
</form>
</body>
</html>
