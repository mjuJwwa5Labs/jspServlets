<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>(jstl) Komunikat</title>
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

    <div class="container">
        <div class="alert alert-success">
            <strong>Hurrra!</strong> ${message}
        </div>
    </div>
</body>
</html>
