<%--
  Created by IntelliJ IDEA.
  User: VORON
  Date: 01.05.2016
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
  <title>LethalWeapon</title>
  <meta charset="UTF-8">
  <link rel="shortcut icon" type="image/x-icon" href="../resources/images/icon.png">
  <link rel="stylesheet" href="../resources/styles/styles.css" media="all">
</head>
<body>

<div class="header">
  <a href="/index" class="logo"></a>

  <div class="search">
    <form class="search-form">
      <input type="search" name="q" placeholder="Поиск по сайту" class="searchText">
      <input type="submit" value="Search" class="find">
    </form>
  </div>
  <a href="/signup" class="signup">
    <div align="center">
      <span>Sign up</span>
    </div>
  </a>
  <a href="/login" class="signup">
    <div align="center">
      <span>Login</span>
    </div>
  </a>
</div>

<div class="container">

  <div class="menu">
    <a href="/index"><div class="menuButton">Главная</div></a>
    <a href="/categories"><div class="menuButton">Категории</div></a>
    <a href="/accessories"><div class="menuButton">Аксессуары</div></a>
    <a href="/weapon_collections"><div class="menuButton">Сборники</div></a>
  </div>

  <div class="container_body">
      <jsp:include page="${requestScope.pageName}"/>
  </div>

</div>

</body>
</html>