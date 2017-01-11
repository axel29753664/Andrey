<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post" action="login">
    Login <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <input type="submit" value="login">
    <font color="red">${message}</font>

</form>
</body>
</html>



