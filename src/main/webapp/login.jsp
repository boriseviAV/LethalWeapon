<%--
  Created by IntelliJ IDEA.
  User: VORON
  Date: 01.05.2016
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход</title>
</head>
<body>
    <div class="form_div" align="center">
        <form class="reg" method="POST">
            <br>LOGIN:<br>
            <label>
                <input type="text" name="login" class="text_field" required>
            </label><br>
            <br>PASSWORD:<br>
            <label>
                <input type="password" name="pass" class="text_field" required>
            </label><br><br>

            <input type="submit" value="LOGIN" class="submit"><br><br>
        </form>
    </div>
</body>
</html>
