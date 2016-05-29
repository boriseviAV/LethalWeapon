<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <c:choose>
        <c:when test="${requestScope.addToCol == true}">
            <form action="/add_weapons?to=${param.to}" method="POST">
                <jsp:include page="/pages/weapons/index.jsp"/>
            </form>
        </c:when>
        <c:when test="${requestScope.addToCol == false}">
            <jsp:include page="/pages/weapons/index.jsp"/>
        </c:when>
    </c:choose>
</body>
</html>
