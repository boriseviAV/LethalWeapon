<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 7/05/16
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
  <a class="add-item" href="/new_weapon_collection">Добавить</a><br/>

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

      <hr color="#00FF00">
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

      <hr color="#00FF00">
    </c:forEach>
  </c:if>

</body>
</html>
