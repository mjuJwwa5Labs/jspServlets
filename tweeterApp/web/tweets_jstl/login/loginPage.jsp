<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-17
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>(jstl) Strona edycji Tweeta</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/tweets">Mój tweeter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/addTweet">Dodaj tweeta</a></li>
            <li><a href="/tweetSearchForm">Wyszukaj tweeta</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
            <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>


<c:if test="${not empty errorMessage}">
    <div class="container">
        <div class="alert alert-warning">
            <strong>Czy wiesz czego szukasz?</strong> ${errorMessage}
        </div>
    </div>
</c:if>

<div class="container">
    <form class="form-horizontal" action="/login" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-2" for="username">Nazwa użytkownika</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="username" id="username" placeholder="Wprowadź nazwę użytkownika" value="">
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-2" for="password">Hasło</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="password" name="password" placeholder="Wpisz hasło" value="">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Zaloguj</button>
            </div>
        </div>
    </form>
</div>


</body>
</html>