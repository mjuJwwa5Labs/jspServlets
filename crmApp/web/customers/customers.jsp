<%@ page import="dto.CustomerDto" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 23:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style><%@include file="/WEB-INF/css/style.css"%></style>
<head>
    <title>Aktualna lista klientów</title>
</head>
<body>
    <header>
        Lista aktualnie zarejestrowanych klientów
    </header>

    <div class="mainContainer">
        <div>
                <%
                    List<CustomerDto> customerDtoList = (List<CustomerDto>) request.getAttribute("customerDtoList");
                    for (CustomerDto customerDto : customerDtoList) {
                 %>
                  <div class="customerDetailsRow">
                      <div class="customerDetailsId">
                          Numer klienta: <%=customerDto.getId().toString()%>
                      </div>
                      <div class="customerDetailsLogin">
                          Login: <%=customerDto.getLogin()%>
                      </div>
                      <div class="customerDetailsFullName">
                          Imię i nazwisko: <%=customerDto.getFirstName() + " " + customerDto.getLastName()%>
                      </div>
                      <div class="customerDetailsType">
                          Typ konta: <%=customerDto.getCustomerType()%>
                      </div>
                  </div>
                <%
                    }
                %>
        </div>
    </div>
</body>
</html>
