<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="add-item" href="/new_weapon_collection">Добавить сборник</a>
        <a class="add-item" href="/weapon_collections?method=delete">Очистить</a>
        <br/>
    </div>

    <ul class="container">
        <c:if test="${empty requestScope.weaponCollectionsList}">
            <div class="empty-list">Список сборников пуст</div>
        </c:if>
        <c:forEach var="weaponCollection" items="${requestScope.weaponCollectionsList}">
            <li class="item">
                <a href="/show_weapon_collection?id=${weaponCollection.collectionId}">
                    <div align="center">
                        <img src="${requestScope.cacheDir}${weaponCollection.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                        <div class="item-name">${weaponCollection.name}</div>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
