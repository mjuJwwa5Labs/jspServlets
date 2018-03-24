<%@ page import="twitter.dto.TwitterMessageDto" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>(jstl) Lista tweetów</title>
    <jsp:include page="/tweets_jstl/core_page_components/headerInclusions.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/tweets_jstl/navigation/topNav.jsp"></jsp:include>

<c:if test="${not empty resultsCount}">
    <div class="container">
        <div class="alert alert-success">
            Ilość znalezionych tweetów: <strong>${resultsCount}</strong>
        </div>
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
            <td><a href="/tweet?tweetId=${tweet.id}" data-toggle="tooltip" title="TweetId = ${tweet.id}">Podgląd</a></td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div>
    <jsp:include page="/tweets_jstl/navigation/footerNavLanguge.jsp"></jsp:include>
</div>
</body>
</html>
