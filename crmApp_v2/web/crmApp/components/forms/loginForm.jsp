<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-21
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="/login" method="post">
    <div class="form-group">
        <label class="control-label col-sm-2" for="login">Login</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="login" name="login" placeholder="Login" value="">
            <c:if test="${not empty errors.errors.login}">
                <c:forEach items="${errors.errors.login}" var="errorItem">
                <span class="label label-warning">
                        ${errorItem}
                </span>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="password">Hasło</label>
        <div class="col-sm-6">
            <input type="password" class="form-control" id="password" name="password" placeholder="Hasło">
            <c:if test="${not empty errors.errors.password}">
                <c:forEach items="${errors.errors.password}" var="errorItem">
                <span class="label label-warning">
                        ${errorItem}
                </span>
                </c:forEach>
            </c:if>
        </div>
    </div>
    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Zaloguj</button>
        </div>
    </div>
</form>
