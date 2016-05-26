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
</head>
<body>
    <div class="add">
        <a class="back" href="/accessories">Назад к Аксессуарам</a><br/>
    </div>

    <ul class="container">
        <li class="item-show">
            <div class="avatar" align="center">
                <img src="${requestScope.accessory.pictureURL}" width="80%" height="100%" alt="Нет изображения">
            </div>

            <div align="center">
                <table bgcolor="#01A9DB" class="parameters" border="1" cellspacing="0">
                    <tr class="param">
                        <td width="30%" align="right" class="param">Название:</td>
                        <td width="70%" align="center" class="param">${requestScope.accessory.name}</td>
                    </tr>
                    <tr class="param">
                        <td align="right" class="param">Описание:</td>
                        <td align="center" class="param">${requestScope.accessory.description}</td>
                    </tr>
                </table>
            </div>
        </li>
    </ul>
</body>
</html>
