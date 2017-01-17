<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bets deleting</title>
</head>
<body>
<jsp:include page="../menu.jsp"></jsp:include>

<form name="betsDeletingTable" action="betsDeleting" method="post">
    <table border="2">
        <tr>
            <td>EventID</td>
            <td>BetSum</td>
            <td>BetCondition</td>
        </tr>
        <c:forEach items="${data}" var="bet">
            <tr>
                <td> ${bet.eventId}</td>
                <td> ${bet.betSum}</td>
                <td>
                    <label>
                        <input type="button" value="Delete bet"
                               onclick="document.getElementById('betId').value = ${bet.betId};
                                       document.betsDeletingTable.submit(); "/>
                    </label>

                </td>
            </tr>
        </c:forEach>
    </table>
    <input type="hidden" id="betId" value="" name="deletingBetId"/>

</form>
<input type="button" onclick="history.back();" value="Назад"/>
</body>
</html>