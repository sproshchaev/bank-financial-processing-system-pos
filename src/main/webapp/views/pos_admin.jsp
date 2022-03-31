<!doctype html>

<%@ page pageEncoding="UTF-8" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Сессия администратора</title>
    <style>
        .wrapper {
            width: 100%;
            max-width: 1200px;
            margin: 0 auto;
        }
        h1 {
            text-align: center;
        }
        .form_group {
            width: 100%;
            padding: 10px 0;
            display: flex;
            flex-wrap: wrap;
            justify-content: start;
            align-items: center;
        }
        .form_group label {
            flex-basis: 10%;
            font-weight: 600;
            text-transform: uppercase;
            font-size: .8rem;
        }
    </style>
</head>

<body>
<div class="wrapper">

    <h1>Сессия администратора</h1>
    <br>
    <br>
    <br>
    <hr>

    <h2>Возврат платежа</h2>

    <form action="createrefund" method="post">
        Номер карты: <input name="card" value="400000"><br>
        Срок действия: <input name="dateexp" value="0000"><br>
        Сумма возврата: <input name="summa" value="0.00"><br>
        <input type="submit" value="Авторизовать возврат">
    </form>
</div>
<br>
<br>
<br>
<hr>
<div class="wrapper">

    <h2>Выписка по операциям</h2>


    <form action="createstatement" method="post">
        Дата начала периода: <input name="datebegin" value="2022-03-01"><br>
        Дата окончаня периода: <input name="dateend" value="2022-03-31"><br>
        <input type="submit" value="Сформировать выписку">
    </form>

</div>

<br>
<br>
<br>

<div class="wrapper">

<form action="/logout" method="get">
    <input type="submit" value="Logout">
</form>

</div>

</body>

</html>