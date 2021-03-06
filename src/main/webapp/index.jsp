<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>${requestScope.pageTitle}</title>
    <link rel="shortcut icon" href="resources/images/icon.png" />
    <style>
        <%@include file="resources/styles/styles.css"%>
    </style>

    <script type="application/javascript">
        <%@include file="resources/scripts/index.js"%>
    </script>

</head>
<body>
    <div style="overflow-y: auto; height: 100%; display: flex; flex-direction: column">
        <div style="display: inline">
            <div class="header">
                <div class="header-panel">
                    <div>
                        <ul class="panel">
                            <li class="logo">
                                <a href="/">LETHAL WEAPON</a>
                            </li>
                            <li class="search">
                                <form method="POST" action="/search">
                                    <input name="phrase" type="text" class="text-search" placeholder="Введите фразу для поиска...">
                                    <input type="submit" class="button-search" value="Поиск">
                                </form>
                            </li>

                            <li class="signin-signup">
                                <ul class="ul-signin-signup">
                                    <c:choose>
                                        <c:when test="${sessionScope.currentUser == null}">
                                            <li class="signin">
                                                <a href="/login" class="reg-btn">ВХОД</a>
                                            </li>
                                            <li class="signup">
                                                <a href="/signup" class="reg-btn">РЕГИСТРАЦИЯ</a>
                                            </li>
                                        </c:when>
                                        <c:when test="${sessionScope.currentUser != null}">
                                            <li class="signin">
                                                <a>${sessionScope.currentUser.name}</a>
                                            </li>
                                            <li class="signup">
                                                <a href="/logout">Выйти</a>
                                            </li>
                                        </c:when>
                                    </c:choose>
                                </ul>
                            </li>
                            <li class="signin-signup">
                                <div id="clock"></div>
                            </li>
                        </ul>
                    </div>
                    <div style="width: 100%" align="center">
                        <ul class="menu">
                            <li class="ref-li"><a href="/weapon_collections">Сборники</a></li>
                            <li class="ref-li"><a href="/accessories">Аксессуары</a></li>
                            <li class="ref-li"><a href="/categories">Категории</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div class="cont">
            <jsp:include page="${requestScope.pageName}"/>
        </div>
    </div>
</body>
</html>