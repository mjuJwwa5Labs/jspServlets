<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wyszukaj tweeta</title>
</head>
<body>
<form action="/tweets/search">
    <div>
        <label for="searchUsername">Użytkownik:</label>
        <input type="text" id="searchUsername" name="searchUsername" value=""/>
    </div>
    <div>
        <label for="searchMessage">Wiadomość:</label>
        <input type="text" id="searchMessage" name="searchMessage" value=""/>
    </div>
    <div>
        <input type="submit" id="search" value="Wyszukaj"/>
    </div>
</form>
</body>
</html>
