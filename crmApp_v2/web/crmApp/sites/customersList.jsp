<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="/crmApp/common/coreHtml/siteOpenSection.jsp"></jsp:include>

    <c:forEach items="${customerDtoList}" var="customerDto">
        <div class="media">
            <div class="media-left media-top">
                <img src="/crmApp/media/img_avatar1.png" class="media-object" style="width:60px">
            </div>
            <div class="media-body">
                <h4 class="media-heading">${customerDto.firstname} ${customerDto.lastname}<small><i> <strong>Data utworzenia:</strong> ${customerDto.created}</i></small><small><i>, <strong>ostatnia aktualizacja:</strong> ${customerDto.modified}</i></small></h4>
                <p><a href="/customers">Historia</a> | <a href="/customers">Segment</a></p>
            </div>
        </div>
    </c:forEach>

<jsp:include page="/crmApp/common/coreHtml/siteCloseSection.jsp"></jsp:include>