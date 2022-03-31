<!doctype html>

<%@ page pageEncoding="UTF-8" %>

<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Оплата по банковской карте</title>
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
    <h1>Оплата по банковской карте</h1>
    <br>
    <br>
    <br>
    <hr>
    <h2>Параметры платежа</h2>

    <form action="createtrans" method="post">
        Номер карты: <input name="card" value="400000"><br>
        Срок действия: <input name="dateexp" value="0000"><br>
        Сумма оплаты: <input name="summa" value="0.00"><br>
        <input type="submit" value="Авторизовать">
    </form>

    <br>
    <br>
    <br>
    <form action="/logout" method="get">
        <input type="submit" value="Выйти">
    </form>

</div>
</body>

</html>