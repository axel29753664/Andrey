<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post">
    Login <input type="text" name="login"/>
    Password <input type="text" name="password"/>
    <a href="${pageContext.request.contextPath}/userPage">
        <button>login</button>
    </a>
    <font color="red">${loginMessage}</font>
</form>
</body>
</html>



