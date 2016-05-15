<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 16/05/16
  Time: 12:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:choose>
        <c:when test="${requestScope.addToCol == true}">
            <form action="/add_weapons?to=${param.id}" method="POST">
                <jsp:include page="/pages/weapons/index.jsp"/>
            </form>
        </c:when>
        <c:when test="${requestScope.addToCol == false}">
            <jsp:include page="/pages/weapons/index.jsp"/>
        </c:when>
    </c:choose>
</body>
</html>
