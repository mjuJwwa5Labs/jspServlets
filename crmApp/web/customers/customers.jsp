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
<!--<%--<style><%@include file="/WEB-INF/css/style.css"%></style>--%>-->
<head>
    <title>Aktualna lista klientów</title>
</head>
<body>
    <p>
        Lista aktualnie zarejestrowanych klientów
    </p>

    <div class="mainContainer">
        <div>
                <%
                    List<CustomerDto> customerDtoList = (List<CustomerDto>) request.getAttribute("customerDtoList");
                    for (CustomerDto customerDto : customerDtoList) {
                 %>
                  <div clss="listElement">
                      Imie i nazwisko: <%=customerDto.getCustomerName()%>
                  </div>
                <%
                    }
                %>
        </div>
    </div>
</body>
</html>
