<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 10/05/16
  Time: 1:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="add">
        <a class="add-item" href="/categories">Назад к Категориям</a><br/>
    </div>

    <div class="container">
        <div class="form_div" align="center">
            <form class="reg" method="POST" action="/new_category" enctype="multipart/form-data">
                <br>Название:
                <label>
                    <input type="text" name="name" class="text_field">
                </label>
                <br><br>Изображение:
                <label>
                    <input type="file" name="picture" class="text_field">
                </label>
                <br><br>

                <input type="submit" value="ОК" class="submit"><br><br>
            </form>
        </div>
    </div>
</body>
</html>
