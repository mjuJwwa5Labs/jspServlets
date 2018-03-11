<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Komunikat</title>
</head>
<body>
    <div>
        <%=(String)request.getAttribute("message")%>
    </div>
</body>
</html>
