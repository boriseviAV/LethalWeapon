<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="add-item" href="/new_weapon_collection">Добавить сборник</a><br/>
    </div>

    <ul class="container">
        <c:forEach var="weaponCollection" items="${requestScope.weaponCollectionsList}">
            <li class="item">
                <a href="/show_weapon_collection?id=${weaponCollection.collectionId}">
                    <div align="center">
                        <img src="${weaponCollection.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                        <span class="item-title">${weaponCollection.name}</span>
                    </div>
                </a>
            </li>
        </c:forEach>
    </ul>
</body>
</html>
