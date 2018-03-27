<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Moja aplikacja tweeter</title>
  </head>
  <body>
  <div class="container">
    <h2>Tweets</h2>
    <p>Lista znalezionych tweetów:</p>
    <table class="table table-hover">
      <thead>
      <tr>
        <th>Strona</th>
        <th>Link</th>
      </tr>
      </thead>
      <tbody>
        <tr>
          <td>Login</td>
          <td><a href="/login">/login</a></td>
        </tr>
        <tr>
          <td>Wszystkie tweety</td>
          <td><a href="/tweets">/tweets</a></td>
        </tr>
      </tbody>
    </table>
  </div>
  </body>
</html>