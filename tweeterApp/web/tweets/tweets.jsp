<%@ page import="twitter.dto.TwitterMessageDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lista tweetów</title>
</head>
<body>
<div>
    <h1>
        Lista tweetów
    </h1>
</div>
    <ul>
        <%
            List<TwitterMessageDto> tweets = (List<TwitterMessageDto>) request.getAttribute("tweetsModel");
            for (TwitterMessageDto twitterMessageDto : tweets) {
        %>
        <li><strong>id:</strong> <%=twitterMessageDto.getId()%> ,
            <ul>
                <li><strong>użytkownik:</strong> <%=twitterMessageDto.getUsername()%></li>
                <li><strong>treść: </strong><%=twitterMessageDto.getMessage()%></li>
            </ul>
        </li>
        <%
            }
        %>
    </ul>
</div>
</body>
</html>
