<%--
  Created by IntelliJ IDEA.
  User: sined
  Date: 7/05/16
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
  <div class="form_div">
    <form class="reg" method="POST" action="/new_weapon?to=${param.to}" enctype="multipart/form-data">
      <br>Вид:
      <label>
        <input type="text" name="model_name" class="text_field">
      </label>
      <br>Способ держания:
      <label>
        <select name="holding_way">
          <option value="one">Одноручное</option>
          <option value="two">Двуручное</option>
          <option value="other">-</option>
        </select>
      </label>
      <br>Страна-производитель:
      <label>
        <input type="text" name="country" class="text_field">
      </label>
      <br>Дальнобойность:
      <label>
        <input type="text" name="range" class="text_field">
      </label>
      <br>Калибр:
      <label>
        <input type="text" name="caliber" class="text_field">
      </label>
      <br>Вместимость магазина (обоймы):
      <label>
        <input type="text" name="ammo_number" class="text_field">
      </label>
      <br>Оптика:
      <label>
        <select name="optics">
          <option value="true">Есть</option>
          <option value="false">Нет</option>
        </select>
      </label>
      <br>Материал:
      <label>
        <input type="text" name="stuff" class="text_field">
      </label>
      <br>Изображение:
      <label>
        <input type="file" name="picture" class="text_field">
      </label>
      <br><br>

      <input type="submit" value="ОК" class="submit"><br><br>
    </form>
  </div>
</body>
</html>
