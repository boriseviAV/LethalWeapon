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
  <script language="JavaScript" type="text/javascript">
    <!--
    function clock() {
      var theDate = new Date();
      var hours, minutes, seconds;
      hours = theDate.getHours();
      hours = (hours < 10) ? "0" + hours : hours;
      minutes = theDate.getMinutes();
      minutes = (minutes < 10) ? "0" + minutes : minutes;
      seconds = theDate.getSeconds();
      seconds = (seconds < 10) ? "0" + seconds : seconds;
      var strDate =  hours + ":" + minutes + ":" + seconds;
      document.forms['clockForm'].clockBox.value=strDate;
      setTimeout("clock()", 1000);}
    //-->
  </script>
</head>
<body onLoad="clock()">

<div class="header">
  <a href="index.jsp" class="logo"></a>

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
    <a href="/collections"><div class="menuButton">Сборники</div></a>
    <form name="clockForm">Время: <input type="text" name="clockBox" size="10"></form>
  </div>

  <div class="container_body">
      <jsp:include page="${requestScope.pageName}"/>

  </div>

</div>

</body>
</html>