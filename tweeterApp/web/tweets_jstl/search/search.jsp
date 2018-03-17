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
    <title>(jstl) Wyszukaj tweeta</title>
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
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <form class="form-horizontal" action="/tweets/search" method="GET">
        <div class="form-group">
            <label class="control-label col-sm-2" for="searchUsername">Nazwa użytkownika</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="searchUsername" name="searchUsername" placeholder="Wpisz szukaną nazwę" value="">
            </div>
        </div>
        <input type="hidden" name="${singleTweetModel.id}"/>
        <div class="form-group">
            <label class="control-label col-sm-2" for="searchMessage">Wiadomość</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="searchMessage" name="searchMessage" placeholder="Wpisz szukaną wiadomość"></textarea>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Szukaj tweeta</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
