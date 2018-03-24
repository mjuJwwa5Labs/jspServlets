<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-17
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${not empty sessionScope.username}">
    Moje Tweety
</c:if>
