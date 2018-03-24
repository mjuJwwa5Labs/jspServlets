<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-21
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty customerDtoList}">
    <div class="container">
        <table class="table table-striped table-hover ">
            <thead>
            <tr>
                <th>Id</th>
                <th>Imię</th>
                <th>Nazwisko</th>
                <th>Data utworzenia</th>
                <th>Data aktualizacji</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${customerDtoList}" var="customerDtoElement">
                <tr>
                    <td>${customerDtoElement.id}</td>
                    <td>${customerDtoElement.firstname}</td>
                    <td>${customerDtoElement.lastname}</td>
                    <td>${customerDtoElement.created}</td>
                    <td>${customerDtoElement.modified}</td>
                    <td><a href="#">Szczegóły</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>