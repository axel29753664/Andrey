<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="default.jsp"></jsp:include>
<form method="post">
    Login <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <input type="submit" value="Send"/>
    <font color="red">${loginMessage}</font>
</form>
</body>
</html>



