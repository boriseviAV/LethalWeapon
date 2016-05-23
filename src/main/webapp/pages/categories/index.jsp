<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <c:choose>
            <c:when test="${requestScope.addToCol == false}">
                <a class="add-item" href="/new_category">Добавить категорию</a><br/>
            </c:when>
            <c:when test="${requestScope.addToCol == true}">
                <a class="add-item" href="/show_weapon_collection?id=${param.to}">К Сборнику</a><br/><br/>
                <a class="add-item" style="border: none; color: #253441">Выберите, из какой Категории Вы хотите добавить оружие в Сборник</a>
            </c:when>
        </c:choose>
    </div>

    <ul class="container">
        <c:forEach var="category" items="${requestScope.categoriesList}">
            <li class="item">
                <a href="/show_category?id=${category.categoryId}">
                    <div align="center">
                        <img src="${category.pictureURL}" width="200" height="200" alt="Нет изображения">
                        <span class="item-title">${category.name}</span>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
