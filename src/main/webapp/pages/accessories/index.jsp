<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="add-item" href="/new_accessory">Добавить аксессуар</a><br/>
    </div>

    <ul class="container">
        <c:forEach var="accessory" items="${requestScope.accessoriesList}">
            <li class="item">
                <a href="/show_accessory?id=${accessory.accessoryId}">
                    <div class="item-template" align="center">
                        <img src="${accessory.pictureURL}" width="200" height="200" alt="Нет изображения">
                        <span class="item-title">${accessory.name}</span>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>

</body>
</html>
