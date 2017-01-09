<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>

<html>
<head>
    <title>user page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post" action="userPage">
    <button type="submit">logout</button>
    <input type="button" value="Make bet" onClick='location.href="makeBetForm"'>
    <h1> Hello ${user.firstName} ${user.lastName} </h1>
    <h1> You are login as "${user.login}" </h1>
</form>
</body>
</html>
