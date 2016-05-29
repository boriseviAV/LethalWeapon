<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <ul class="container">
        <c:if test="${requestScope.weaponsList == null or empty requestScope.weaponsList}">
            <div class="empty-list">Результаты не найдены</div>
        </c:if>
                <c:forEach var="weapon" items="${requestScope.weaponsList}">
                    <li class="item">
                        <label style="cursor: pointer">
                            <c:choose>
                                <c:when test="${requestScope.addToCol == false}">
                                    <a href="/show_weapon?id=${weapon.weaponId}">
                                        <div class="item-template" align="center">
                                            <img src="${requestScope.cacheDir}${weapon.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                            <div class="item-name">${weapon.modelName}</div>
                                        </div>
                                    </a>
                                </c:when>
                                <c:when test="${requestScope.addToCol == true}">
                                    <input type="checkbox" name="weaponId" value="${weapon.weaponId}" style="cursor: pointer">
                                    <a>
                                        <div class="item-template" align="center">
                                            <img src="${requestScope.cacheDir}${weapon.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                            <div class="item-name">${weapon.modelName}</div>
                                        </div>
                                    </a>
                                </c:when>
                            </c:choose>
                        </label>
                    </li>
                </c:forEach>


    </ul>
</body>
</html>
