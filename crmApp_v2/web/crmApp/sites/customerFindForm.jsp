<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <jsp:include page="/crmApp/common/head.jsp"></jsp:include>
<body>
    <jsp:include page="/crmApp/common/navigation.jsp"></jsp:include>
    <div class="container-fluid" style="margin-top:80px; margin-bottom:10px">
        <c:if test="${empty customerDtoList}">
            <jsp:include page="/crmApp/forms/findCustomer.jsp"></jsp:include>
        </c:if>
    </div>
    <jsp:include page="/crmApp/common/footer.jsp"></jsp:include>
</body>
</html>