<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-12
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    boolean formNotCorrect = (boolean) request.getAttribute("formNotCorrect");
    Map<String,String[]> parametersMap = null;
    Map<String,String> validationResult = null;

    if (formNotCorrect) {
        parametersMap = (Map<String,String[]>) request.getAttribute("parametersMap");
        validationResult = (Map<String,String>) request.getAttribute("validationResult");
    }

%>

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
        <form action="/customers/addCustomer" method="post">
            <div class="customerAddFormRow">
                <div class="customerAddFormLabel">
                    <label for="login">Login:</label>
                </div>
                <div class="customerAddFormField">
                    <input class="customerAddInputText" type="text" name="login" id="login" value="<% if (formNotCorrect) {out.print(parametersMap.get("login"));}%>">
                </div>
                <div class="customerAddFormValidatorRow">
                    <label for="login"><% if (formNotCorrect) {out.print(validationResult.get("login"));}%></label>
                </div>
            </div>
            <div class="customerAddFormRow">
                <div class="customerAddFormLabel">
                    <label for="firstName">Imie:</label>
                </div>
                <div class="customerAddFormField">
                    <input type="text" name="firstName" id="firstName" value="<% if (formNotCorrect) {out.print(parametersMap.get("firstName"));}%>">
                </div>
                <div class="customerAddFormValidatorRow">
                    <label for="firstName"><% if (formNotCorrect) {out.print(validationResult.get("firstName"));}%></label>
                </div>
            </div>
            <div class="customerAddFormRow">
                <div class="customerAddFormLabel">
                    <label for="lastName">Nazwisko:</label>
                </div>
                <div class="customerAddFormField">
                    <input type="text" name="lastName" id="lastName" value="<% if (formNotCorrect) {out.print(parametersMap.get("lastName"));}%>">
                </div>
                <div class="customerAddFormValidatorRow">
                    <label for="lastName"><% if (formNotCorrect) {out.print(validationResult.get("lastName"));}%></label>
                </div>
            </div>
            <div class="customerSubmitRow">
                <div class="customerAddFormLabel">
                </div>
                <div class="customerAddFormField">
                    <input class="customerAddSubmit" type="submit" value="Zapisz zmiany">
                </div>
            </div>
        </form>
    </div>

</body>
</html>
