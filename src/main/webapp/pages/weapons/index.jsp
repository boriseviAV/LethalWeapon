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
  <c:choose>
      <c:when test="${requestScope.addToCol == false}">
          <a class="add-item" href="${requestScope.back}">${requestScope.anchor}</a><br/>
          <a class="add-item" href="${requestScope.action}?to=${param.id}">Добавить</a><br/>
      </c:when>
      <c:when test="${requestScope.addToCol == true}">
          <a class="add-item" href="/add_weapons?to=${param.id}">К Категориям на добавление</a><br/>
          <input type="submit" value="Добавить в сборник" class="submit">
      </c:when>
  </c:choose>

  <c:set var="itemsInPortion" value="${requestScope.itemsInPortion}"/>
  <c:set var="portionsNumber" value="${requestScope.weaponsListPortionsNumber}"/>
  <c:set var="restNumber" value="${requestScope.weaponsListRestNumber}"/>
  <c:if test="${portionsNumber > 0}">
    <c:forEach var="portionNumber" begin="0" end="${portionsNumber - 1}">
      <div class="group">
        <div class="items">
          <c:forEach var="weapon" items="${requestScope.weaponsList}" begin="${portionNumber * itemsInPortion}" end="${(portionNumber + 1) * itemsInPortion - 1}">
              <label>
                  <c:choose>
                      <c:when test="${requestScope.addToCol == false}">
                          <a href="/show_weapon?id=${weapon.weaponId}">
                              <div class="item-template" align="center">
                                  <img src="${weapon.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                                  <span>${weapon.modelName}</span>
                              </div>
                          </a>
                      </c:when>
                      <c:when test="${requestScope.addToCol == true}">
                          <input type="checkbox" name="weaponId" value="${weapon.weaponId}">
                          <a>
                              <div class="item-template" align="center">
                                  <img src="${weapon.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                                  <span>${weapon.modelName}</span>
                              </div>
                          </a>
                      </c:when>
                  </c:choose>
              </label>
          </c:forEach>
        </div>
      </div>
    </c:forEach>
  </c:if>

  <c:set var="weaponsListSize" value="${requestScope.weaponsListSize}"/>
  <c:if test="${restNumber > 0}">
    <div class="group">
      <div class="items">
        <c:forEach var="weapon" items="${requestScope.weaponsList}" begin="${weaponsListSize - restNumber}" end="${weaponsListSize - 1}">
            <label>
                <c:choose>
                    <c:when test="${requestScope.addToCol == false}">
                        <a href="/show_weapon?id=${weapon.weaponId}">
                            <div class="item-template" align="center">
                                <img src="${weapon.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                                <span>${weapon.modelName}</span>
                            </div>
                        </a>
                    </c:when>
                    <c:when test="${requestScope.addToCol == true}">
                        <input type="checkbox" name="weaponId" value="${weapon.weaponId}">
                        <a>
                            <div class="item-template" align="center">
                                <img src="${weapon.pictureURL}" width="100%" height="100%" alt="Нет изображения">
                                <span>${weapon.modelName}</span>
                            </div>
                        </a>
                    </c:when>
                </c:choose>
            </label>
        </c:forEach>
      </div>
    </div>
  </c:if>

</body>
</html>
