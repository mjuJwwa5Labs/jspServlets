<%@ page import="twitter.dto.TwitterMessageDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>(jstl) Lista tweetów</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<c:if test="${not empty resultsCount}">
    <div>
        <h2>
            Ilość znalezionych tweetów: ${resultsCount}
        </h2>
    </div>
</c:if>

<div class="container">
    <h2>Tweets</h2>
    <p>Lista znalezionych tweetów:</p>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>Numer tweeta</th>
            <th>Tytuł tweeta</th>
            <th>Nazwa użytkownika</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${tweetsModel}" var="tweet">
        <tr>
            <td>${tweet.id}</td>
            <td>${tweet.title}</td>
            <td>${tweet.username}</td>
            <td><a href="/tweet?tweetId=${tweet.id}">Podgląd</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
