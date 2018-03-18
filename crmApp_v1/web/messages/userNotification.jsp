<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-12
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><%=request.getAttribute("messageTitle")%></title>
</head>
<body>
    <header>
        Komunikat:
    </header>
    <h1>
        <%=request.getAttribute("messageBody")%>
    </h1>
</body>
</html>
