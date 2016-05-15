<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 10/05/16
  Time: 1:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
  <c:choose>
      <c:when test="${requestScope.addToCol == false}">
          <a class="add-item" href="/new_category">Добавить</a><br/>
      </c:when>
      <c:when test="${requestScope.addToCol == true}">
          <a class="add-item" href="/show_weapon_collection?id=${param.to}">К Сборнику</a><br/><br/>
          Выберите, из какой Категории Вы хотите добавить оружие в Сборник
      </c:when>
  </c:choose>

  <c:set var="itemsInPortion" value="${requestScope.itemsInPortion}"/>
  <c:set var="portionsNumber" value="${requestScope.categoriesListPortionsNumber}"/>
  <c:set var="restNumber" value="${requestScope.categoriesListRestNumber}"/>
  <c:if test="${portionsNumber > 0}">
    <c:forEach var="portionNumber" begin="0" end="${portionsNumber - 1}">
      <div class="group">
        <div class="items">
          <c:forEach var="category" items="${requestScope.categoriesList}" begin="${portionNumber * itemsInPortion}" end="${(portionNumber + 1) * itemsInPortion - 1}">
            <a href="/show_category?id=${category.categoryId}">
              <div class="item-template" align="center">
                <img src="${category.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                <span>${category.name}</span>
              </div>
            </a>
          </c:forEach>
        </div>
      </div>
    </c:forEach>
  </c:if>

  <c:set var="categoriesListSize" value="${requestScope.categoriesListSize}"/>
  <c:if test="${restNumber > 0}">
    <div class="group">
      <div class="items">
        <c:forEach var="category" items="${requestScope.categoriesList}" begin="${categoriesListSize - restNumber}" end="${categoriesListSize - 1}">
          <a href="/show_category?id=${category.categoryId}">
            <div class="item-template" align="center">
              <img src="${category.pictureURL}" width="100%" height="100%" alt="Нет изображения">
              <span>${category.name}</span>
            </div>
          </a>
        </c:forEach>
      </div>
    </div>
  </c:if>
</body>
</html>
