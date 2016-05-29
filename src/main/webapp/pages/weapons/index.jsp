<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <c:choose>
            <c:when test="${requestScope.addToCol == false}">
                <a class="add-item" href="${requestScope.back}">${requestScope.anchor}</a><br/>
                <a class="add-item" href="${requestScope.action}?to=${param.id}">Добавить</a><br/>
            </c:when>
            <c:when test="${requestScope.addToCol == true}">
                <a class="add-item" style="padding-bottom: 0; padding-top: 10px; margin-top: 8px; height: 28px" href="/add_weapons?to=${param.id}">К Категориям на добавление</a><br/>
                <input type="submit" value="Добавить в сборник" class="add-item submit" style="padding-top: 12px; margin-left: 5px; width: 160px; height: 40px">
            </c:when>
        </c:choose>
    </div>

    <ul class="container">
        <c:if test="${empty requestScope.weaponsList}">
            <div class="empty-list">Список оружия пуст</div>
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
