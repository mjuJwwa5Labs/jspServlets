<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>(jstl) Strona edycji Tweeta</title>
    <jsp:include page="/tweets_jstl/core_page_components/headerInclusions.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/tweets_jstl/navigation/topNav.jsp"></jsp:include>

<c:choose>
    <c:when test="${not empty errorMessage}">
        <div class="container">
            <div class="alert alert-warning">
                <strong>Czy wiesz czego szukasz?</strong> ${errorMessage}
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <c:if test="${not empty singleTweetModel}">
            <div class="container">
                <form class="form-horizontal" action="/addTweet" method="POST">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="username">Nazwa użytkownika</label>
                        <div class="col-sm-10">
                            <input disabled type="text" class="form-control" id="username" name="username"
                                   placeholder="${singleTweetModel.username}" value="${singleTweetModel.username}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="title">Tytuł</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="title" id="title" placeholder="wpisz tytuł"
                                   value="${singleTweetModel.title}">
                                <c:if test="${not empty errors and not empty errors.fieldErrors.title}">
                                <span class="label label-warning">
                                        ${errors.fieldErrors.title}
                                </span>
                                </c:if>
                        </div>
                    </div>
                    <input type="hidden" name="${singleTweetModel.id}"/>
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="message">Wiadomość</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="message" name="message"
                                      placeholder="Wprowadź swoją wiadomość">${singleTweetModel.message}</textarea>
                            <c:if test="${not empty errors and not empty errors.fieldErrors.message}">
                                <span class="label label-warning">
                                        ${errors.fieldErrors.message}
                                </span>
                            </c:if>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default">Dodaj tweeta</button>
                        </div>
                    </div>
                </form>
            </div>
        </c:if>
    </c:otherwise>
</c:choose>
<div>
    <jsp:include page="/tweets_jstl/navigation/footerNavLanguge.jsp"></jsp:include>
</div>
</body>
</html>
