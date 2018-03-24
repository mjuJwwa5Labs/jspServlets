<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="dropdown">
    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Wybierz język<span class="caret"></span></button>
    <ul class="dropdown-menu">
        <li class="active"><a href="/language?lang=PL">Polski</a></li>
        <li class="active"><a href="/language?lang=EN">Angielski</a></li>
        <li class="active"><a href="/language?lang=CN">Chiński</a></li>
        <li class="diasbled"><a href="#">Klingoński</a></li>
    </ul>
</div>
<c:if test="${not empty cookie}">
    <p class="navbar-text">Zapisany w cookie: ${cookie.lang.value}</p>
</c:if>

<c:if test="${not empty language}">
    <p class="navbar-text">Wybrany język: ${language}</p>
</c:if>
