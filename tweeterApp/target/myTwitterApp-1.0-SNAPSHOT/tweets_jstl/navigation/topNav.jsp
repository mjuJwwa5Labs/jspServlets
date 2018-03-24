<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-17
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/tweets">Mój tweeter</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/addTweet">Dodaj tweeta</a></li>
            <li><a href="/tweetSearchForm">Wyszukaj tweeta</a></li>
            <li><a href="/myTweets"><jsp:include page="/tweets_jstl/login/myTweetsNav.jsp"></jsp:include></a></li>
        </ul>
        <jsp:include page="/tweets_jstl/login/logged.jsp"></jsp:include>
        <ul class="nav navbar-nav navbar-right">
            <li><jsp:include page="/tweets_jstl/navigation/topNavLoginButton.jsp"></jsp:include></li>
        </ul>
    </div>
</nav>