<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="back" href="${requestScope.back}">Назад к списку оружия</a><br/>
    </div>

    <ul class="container">
        <li class="item-show">
            <div class="avatar" align="center">
                <img class="avatar-image" src="${requestScope.cacheDir}${requestScope.weapon.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="600" height="330" alt="Нет изображения">
            </div>

            <div align="center">
                <table bgcolor="#253441" class="parameters" border="1" cellspacing="0">
                    <tr>
                        <td width="30%" align="right">Название модели:</td>
                        <td width="70%" align="center" class="info1">${requestScope.weapon.modelName}</td>
                    </tr>
                    <tr>
                        <td align="right">Способ держания:</td>
                        <td align="center" class="info2">${requestScope.weapon.holdingWay}</td>
                    </tr>
                    <tr>
                        <td align="right">Страна производства:</td>
                        <td align="center" class="info3">${requestScope.weapon.country}</td>
                    </tr>
                    <tr>
                        <td align="right">Дальнобойность:</td>
                        <td align="center" class="info4">${requestScope.weapon.range}</td>
                    </tr>
                    <tr>
                        <td align="right">Патрон:</td>
                        <td align="center" class="info5">${requestScope.weapon.caliber}</td>
                    </tr>
                    <tr>
                        <td align="right">Вместимость магазина (обоймы):</td>
                        <td align="center" class="info6">${requestScope.weapon.ammoNumber}</td>
                    </tr>
                    <tr>
                        <td align="right">Оптика:</td>
                        <td align="center" class="info7">${requestScope.weapon.optics}</td>
                    </tr>
                    <tr>
                        <td align="right">Материал:</td>
                        <td align="center" class="info8">${requestScope.weapon.stuff}</td>
                    </tr>
                </table>
            </div>
        </li>
        <li class="item-show">
            <span style="color: chocolate">Сборники, где встречается это оружие:</span>
        </li>
        <li class="item-show">
            <ul class="container">
                <c:if test="${empty requestScope.weaponsCollectionsList}">
                    <div class="empty-list">Список сборников пуст</div>
                </c:if>
                <c:forEach var="weaponCollection" items="${requestScope.weaponCollectionsList}">
                    <li class="item">
                        <a href="/show_weapon_collection?id=${weaponCollection.collectionId}">
                            <div align="center">
                                <img src="${requestScope.cacheDir}${weaponCollection.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="200" height="200" alt="Нет изображения">
                                <span class="item-title">${weaponCollection.name}</span>
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </li>
    </ul>

</body>
</html>
