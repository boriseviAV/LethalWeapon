<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <ul class="container">
        <c:choose>
            <c:when test="${requestScope.weaponsList != null}">
                <c:forEach var="weapon" items="${requestScope.weaponsList}">
                    <li class="item">
                        <label style="cursor: pointer">
                            <c:choose>
                                <c:when test="${requestScope.addToCol == false}">
                                    <a href="/show_weapon?id=${weapon.weaponId}">
                                        <div class="item-template" align="center">
                                            <img src="${weapon.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                            <span>${weapon.modelName}</span>
                                        </div>
                                    </a>
                                </c:when>
                                <c:when test="${requestScope.addToCol == true}">
                                    <input type="checkbox" name="weaponId" value="${weapon.weaponId}" style="cursor: pointer">
                                    <a>
                                        <div class="item-template" align="center">
                                            <img src="${weapon.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                            <span>${weapon.modelName}</span>
                                        </div>
                                    </a>
                                </c:when>
                            </c:choose>
                        </label>
                    </li>
                </c:forEach>
            </c:when>
            <c:when test="${requestScope.weaponsList == null}">
                Нет записей
            </c:when>
        </c:choose>

    </ul>
</body>
</html>
