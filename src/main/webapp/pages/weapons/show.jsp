<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 9/05/16
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
  <a class="back" href="/weapons">Назад к Списку оружия</a><br/>
  <div class="item_info" align="center">
    <div class="avatar">
      <img src="${requestScope.weapon.pictureURL}" width="100%" height="100%" alt="Нет изображения">
    </div>

    <div class="parameters">
      <table border="1" cellspacing="0">
        <tr>
          <td colspan="2" class="font-1str">
            ${requestScope.weapon.modelName}
          </td>
        </tr>
        <tr>
          <td align="right">Название модели:</td>
          <td align="center" class="info1">${requestScope.weapon.modelName}</td>
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
          <td align="right">Боепитание:</td>
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
  </div>

  <hr color="#00FF00">

  <span>Сборники, где встречается это оружие:</span><br/>

  <c:set var="itemsInPortion" value="${requestScope.itemsInPortion}"/>
  <c:set var="portionsNumber" value="${requestScope.weaponCollectionsListPortionsNumber}"/>
  <c:set var="restNumber" value="${requestScope.weaponCollectionsListRestNumber}"/>
  <c:if test="${portionsNumber > 0}">
      <c:forEach var="weaponCollection" items="${requestScope.weaponCollectionsList}">
          <a href="/show_weapon_collection?id=${weaponCollection.collectionId}">
              <div class="object-collection" align="center">
                  <div class="collection">
                      <img src="${weaponCollection.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                  </div>
                  <div>
                      <span>${weaponCollection.description}</span>
                  </div>
              </div>
          </a>
      </c:forEach>
  </c:if>

  <c:set var="weaponCollectionsListSize" value="${requestScope.weaponCollectionsListSize}"/>
  <c:if test="${restNumber > 0}">
      <c:forEach var="weaponCollection" items="${requestScope.weaponCollectionsList}" begin="${weaponCollectionsListSize - restNumber}" end="${weaponCollectionsListSize - 1}">
          <a href="/show_weapon_collection?id=${weaponCollection.collectionId}">
              <div class="object-collection" align="center">
                  <div class="collection">
                      <img src="${weaponCollection.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                  </div>
                  <div>
                      <span>${weaponCollection.name}</span>
                  </div>
              </div>
          </a>
      </c:forEach>
  </c:if>
</body>
</html>
