<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${empty sessionScope.username}">
        <a href="/login"><span class="glyphicon glyphicon-log-in"></span> Zaloguj</a>
    </c:when>
    <c:otherwise>
        <a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Wyloguj</a>
    </c:otherwise>
</c:choose>

