<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 15/05/16
  Time: 10:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <a class="back" href="/accessories">Назад к Списку аксессуаров</a><br/>
    <div class="item_info" align="center">
        <div class="avatar">
            <img src="${requestScope.accessory.pictureURL}" width="100%" height="100%" alt="Нет изображения">
        </div>

        <div class="parameters">
            <table border="1" cellspacing="0">
                <tr>
                    <td align="right">Название:</td>
                    <td align="center" class="info1">${requestScope.accessory.name}</td>
                </tr>
                <tr>
                    <td align="right">Описание:</td>
                    <td align="center" class="info1">${requestScope.accessory.description}</td>
                </tr>
            </table>
        </div>
    </div>

    <hr color="#00FF00">
</body>
</html>
