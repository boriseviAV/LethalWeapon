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
  <a class="add-item" href="/new_accessory">Добавить</a><br/>

  <c:set var="itemsInPortion" value="${requestScope.itemsInPortion}"/>
  <c:set var="portionsNumber" value="${requestScope.accessoriesListPortionsNumber}"/>
  <c:set var="restNumber" value="${requestScope.accessoriesListRestNumber}"/>
  <c:if test="${portionsNumber > 0}">
    <c:forEach var="portionNumber" begin="0" end="${portionsNumber - 1}">
      <div class="group">
        <div class="items">
          <c:forEach var="accessory" items="${requestScope.accessoriesList}" begin="${portionNumber * itemsInPortion}" end="${(portionNumber + 1) * itemsInPortion - 1}">
            <a href="/show_accessory?id=${accessory.accessoryId}">
              <div class="item-template" align="center">
                <img src="${accessory.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                <span>${accessory.name}</span>
              </div>
            </a>
          </c:forEach>
        </div>
      </div>
    </c:forEach>
  </c:if>

  <c:set var="accessoriesListSize" value="${requestScope.accessoriesListSize}"/>
  <c:if test="${restNumber > 0}">
    <div class="group">
      <div class="items">
        <c:forEach var="accessory" items="${requestScope.accessoriesList}" begin="${accessoriesListSize - restNumber}" end="${accessoriesListSize - 1}">
          <a href="/show_accessory?id=${accessory.accessoryId}">
            <div class="item-template" align="center">
              <img src="${accessory.pictureURL}" width="100%" height="100%" alt="Нет изображения">
              <span>${accessory.name}</span>
            </div>
          </a>
        </c:forEach>
      </div>
    </div>
  </c:if>

</body>
</html>
