<html>

<head>
    <title>Admin Pay Card</title>
</head>

<body>

<h1>ChargeBack</h1>

<h2>ChargeBack</h2>

<form action="createrefund" method="post">
    card: <input name="card"><br>
    code auth: <input name="codeauth"><br>
    summa: <input name="summa"><br>
    <input type="submit">
</form>

<br>
<br>
<br>
<h2>Statement</h2>

<form action="createstatement" method="post">
    Date begin: <input name="datebegin" value="1"><br>
    Date end: <input name="dateend" value="2"><br>
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