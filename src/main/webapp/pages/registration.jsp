<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form method="post" action="registration">
    <font color="red">${message}</font><br>
    <table>
        <tr>
            <td> Name</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>Lastname</td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td>Login</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="text" name="password"/></td>
        </tr>
    </table>

    <input type="submit" value="Send"/>
</form>
</body>
</html>
