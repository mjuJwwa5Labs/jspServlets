<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    My Tweeter App
    <%
      for (int i = 0; i<10; i++) {
          out.println("<div>Numer iteracji: " + i + "</div>");
      }
    %>
  </body>
</html>