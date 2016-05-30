<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>

    <div class="add">
        <c:choose>
            <c:when test="${requestScope.addToCol == false}">
                <a class="add-item" href="/new_category">Добавить категорию</a>
                <a class="add-item" href="/categories?method=delete">Очистить</a>
                <br/>
            </c:when>
            <c:when test="${requestScope.addToCol == true}">
                <a class="add-item" href="/show_weapon_collection?id=${param.to}">К Сборнику</a><br/><br/>
                <a class="add-item" style="border: none; color: #253441">Выберите, из какой Категории Вы хотите добавить оружие в Сборник</a>
            </c:when>
        </c:choose>
    </div>

    <ul class="container">
        <c:if test="${empty requestScope.categoriesList}">
            <div class="empty-list">Список категорий пуст</div>
        </c:if>
        <c:forEach var="category" items="${requestScope.categoriesList}">
            <li class="item">
                <c:choose>
                    <c:when test="${requestScope.addToCol == true}">
                        <a href="/show_category?id=${category.categoryId}&to=${requestScope.collectionId}">
                            <div class="item-template" align="center">
                                <img src="${requestScope.cacheDir}${category.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                <div class="item-name">${category.name}</div>
                            </div>
                        </a>
                    </c:when>
                    <c:when test="${requestScope.addToCol == false}">
                        <a href="/show_category?id=${category.categoryId}">
                            <div class="item-template" align="center">
                                <img src="${requestScope.cacheDir}${category.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                <div class="item-name">${category.name}</div>
                            </div>
                        </a>
                    </c:when>
                </c:choose>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
