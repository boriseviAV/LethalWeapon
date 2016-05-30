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
                <img class="avatar-image" src="${requestScope.cacheDir}${requestScope.accessory.pictureURL}" onerror="this.src='resources/images/no_image.jpg'" width="600" height="330" alt="Нет изображения">
            </div>

            <div align="center">
                <table bgcolor="#253441" class="parameters" border="1" cellspacing="0">
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
