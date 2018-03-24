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
    <jsp:include page="/tweets_jstl/core_page_components/headerInclusions.jsp"></jsp:include>
</head>
<body>

<jsp:include page="/tweets_jstl/navigation/topNav.jsp"></jsp:include>

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
            <input type="hidden" name="backUrl" value="${param.backUrl}"/>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default">Zaloguj</button>
            </div>
        </div>
    </form>
</div>

<div>
    <jsp:include page="/tweets_jstl/navigation/footerNavLanguge.jsp"></jsp:include>
</div>
</body>
</html>