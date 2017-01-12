<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="session" class="lv.javaguru.java2.domain.User"/>

<html>
<head>
    <title>user page</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<form>
    <b> Hello ${user.firstName} ${user.lastName} You are login as "${user.login}" </b>
</form>
<form method="post" action="userPage">
    <button type="submit">logout</button>
    <input type="button" value="Make bet" onClick='location.href="makeBetForm"'>
    <input type="button" value="Create Event" onClick='location.href="createEventForm"'>

</form>
<form><font color="red">${message}</font><br></form>
</body>
</html>
