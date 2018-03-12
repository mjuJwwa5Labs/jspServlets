<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-12
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <title>Formualarz dodawania nowego klienta</title>
</head>
<body>
    <header>
        Formularz dodawania nowego klienta
    </header>

    <div class="customerAddForm">
        <form>
            <div class="customerAddFormRow">
                <div class="formLabel">
                    <label for="firstName">Imie:</label>
                </div>
                <div class="formField">
                    <input type="text" name="firstName" id="firstName">
                </div>
            </div>
        </form>
    </div>

</body>
</html>
