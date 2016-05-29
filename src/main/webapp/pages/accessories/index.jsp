<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="add-item" href="/new_accessory">Добавить аксессуар</a>
        <a class="add-item" href="/accessories?method=delete">Очистить</a><br/>
    </div>

    <ul class="container">
        <c:if test="${empty requestScope.accessoriesList}">
            <div class="empty-list">Список аксессуаров пуст</div>
        </c:if>
        <c:forEach var="accessory" items="${requestScope.accessoriesList}">
            <li class="item">
                <a href="/show_accessory?id=${accessory.accessoryId}">
                    <div class="item-template" align="center">
                        <img src="${requestScope.cacheDir}${accessory.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                        <div class="item-name">${accessory.name}</div>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
