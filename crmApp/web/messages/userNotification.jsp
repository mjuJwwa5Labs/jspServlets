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
    <title>Wystąpił problem</title>
</head>
<body>
    <header>
        Coś poszło źle...
    </header>
    <h1>
        <%=request.getAttribute("message")%>
    </h1>
</body>
</html>
