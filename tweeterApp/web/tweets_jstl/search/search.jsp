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
    <jsp:include page="/tweets_jstl/core_page_components/headerInclusions.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/tweets_jstl/navigation/topNav.jsp"></jsp:include>

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
<div>
    <jsp:include page="/tweets_jstl/navigation/footerNavLanguge.jsp"></jsp:include>
</div>
</body>
</html>
