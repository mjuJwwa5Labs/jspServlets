<%@ page import="twitter.dto.TwitterMessageDto" %><%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Treść twojego tweeta</title>
</head>
<body>
    <form>
        <div>
            <label for="user">Użytkownik:</label>
            <input type="text" id="user" name="user" value="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getUsername()%>"/>
        </div>
        <div>
            <label for="message">Wiadomość:</label>
            <input type="text" id="message" name="message" value="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getMessage()%>"/>
        </div>
        <input type="hidden" name="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getId()%>"/>
    </form>
</body>
</html>
