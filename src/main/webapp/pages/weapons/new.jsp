<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
    <div class="container">
        <div class="form_div" align="center">
            <form style="width: 700px" class="reg" method="POST" action="/new_weapon?to=${param.to}" enctype="multipart/form-data">
                <div>
                    <span style="float: left; width: 49%">
                        Название модели:
                        <label>
                            <input type="text" name="model_name" class="text_field">
                        </label>
                    </span>
                    <span style="float: right; width: 49%">
                        Материал:
                        <label>
                            <input type="text" name="stuff" class="text_field">
                        </label>
                    </span>
                </div>

                <br><br>

                <div>
                    <span style="float: left; width: 49%">
                        Страна-производитель:
                        <label>
                            <input type="text" name="country" class="text_field">
                        </label>
                    </span>
                    <span style="float: right; width: 49%">
                        Дальнобойность:
                        <label>
                            <input type="text" name="range" class="text_field">
                        </label>
                    </span>
                </div>

                <br>

                <div>
                    <span style="float: left; width: 49%">
                        Калибр:
                        <label>
                            <input type="text" name="caliber" class="text_field">
                        </label>
                    </span>
                    <span style="float: right; width: 49%">
                        Вместимость магазина (обоймы):
                        <label>
                            <input type="text" name="ammo_number" class="text_field">
                        </label>
                    </span>
                </div>

                <br><br>
                <br><br>

                <br>Изображение:
                <label>
                    <input type="file" name="picture" class="text_field">
                </label>

                <br><br>

                <div>
                    <span style="float: left; width: 49%">
                        Способ держания:
                        <label>
                            <select name="holding_way">
                                <option value="one">Одноручное</option>
                                <option value="two">Двуручное</option>
                                <option value="other">-</option>
                            </select>
                        </label>
                    </span>
                    <span style="float: right; width: 49%">
                        Оптика:
                        <label>
                            <select name="optics">
                                <option value="true">Есть</option>
                                <option value="false">Нет</option>
                            </select>
                        </label>
                    </span>
                </div>

                <br><br>
                <input type="submit" value="ОК" class="submit"><br><br>
            </form>
        </div>
    </div>
</body>
</html>
