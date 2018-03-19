<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <label class="navbar-brand">crmApp</label>
        </div>
        <ul class="nav navbar-nav">
            <%--<li class="active"><a href="#">Mój profil</a></li>--%>
            <li><a href="/logged/customers">Lista klientów</a></li>
            <li><a href="/logged/customers/customer">Wyszukiwarka klientów</a></li>
            <li class="disabled"><a href="#">Moje zadania <span class="badge media-middle"> 0</span></a></li>
            <li class="disabled"><a href="#">Mój profil</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <%--<li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>--%>
                <li class="dropdown disabled">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">Język / Language<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li class="disabled"><a href="#">Polski</a></li>
                        <li class="disabled"><a href="#">English</a></li>
                    </ul>
                </li>
            <li class="disabled"><a href="#"><span class="glyphicon glyphicon-log-in"></span> Logowanie</a></li>
        </ul>
    </div>
</nav>