<html>

<head>
    <title>Pay Card</title>
</head>

<body>

<h1>Pay Card</h1>

<h2>Create pay</h2>

<form action="createtrans" method="post">
    card: <input name="card"><br>
    date exp: <input name="dateexp"><br>
    summa: <input name="summa"><br>
    <input type="submit">
</form>

<br>
<br>
<br>
<form action="/logout" method="get">
    <input type="submit" value="Logout">
</form>


</body>

</html>