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
    <title>Strona edycji Tweeta</title>
</head>
<body>

    <%
        if (request.getAttribute("errorMessage")!=null) {
    %>
        <div><%=(String)request.getAttribute("errorMessage")%></div>
    <%
        }
    %>

    <%
        if (request.getAttribute("singleTweetModel")!=null) {
    %>
    <form action="/addTweet" method="POST">
        <div>
            <label for="username">Użytkownik:</label>
            <input type="text" id="username" name="username" value="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getUsername()%>"/>
        </div>
        <div>
            <label for="message">Wiadomość:</label>
            <input type="text" id="message" name="message" value="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getMessage()%>"/>
        </div>
        <div>
            <input type="submit" id="saveTweet" value="Dodaj tweeta"/>
        </div>
        <input type="hidden" name="<%=((TwitterMessageDto)request.getAttribute("singleTweetModel")).getId()%>"/>
    </form>
    <%
        }
    %>

</body>
</html>
