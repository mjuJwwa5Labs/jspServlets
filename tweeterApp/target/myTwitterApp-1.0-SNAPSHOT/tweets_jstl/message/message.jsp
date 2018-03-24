<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-11
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/tweets_jstl/core_page_components/headerInclusions.jsp"></jsp:include>
    <title>(jstl) Komunikat</title>
</head>
<body>

<jsp:include page="/tweets_jstl/navigation/topNav.jsp"></jsp:include>

    <div class="container">
        <div class="alert alert-success">
            <strong>Hurrra!</strong> ${message}
        </div>
    </div>
<div>
    <jsp:include page="/tweets_jstl/navigation/footerNavLanguge.jsp"></jsp:include>
</div>
</body>
</html>
