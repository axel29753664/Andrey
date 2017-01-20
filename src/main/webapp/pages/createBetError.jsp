<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MakeBetError</title>
</head>
<body>
<jsp:include page="menu.jsp"></jsp:include>
<center>
    <form>
        <h1>Incorrect input data</h1>
        <h2>Errors: ${data}</h2>
    </form>
</center>
<input type="button" onClick='location.href="${pageContext.request.contextPath}/events"' value="Back"/>
</body>
</html>
