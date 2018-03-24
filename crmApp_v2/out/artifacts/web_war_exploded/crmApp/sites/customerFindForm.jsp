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
        <c:if test="${not empty errors.errors.errorMessage}">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-sm-2"></label>
                    <div class="col-sm-6">
                        <div class="alert alert-danger">
                            <strong>Uwaga!</strong>
                            <c:forEach items="${errors.errors.errorMessage}" var="errorItem">
                                ${errorItem}
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </form>
        </c:if>
        <jsp:include page="/crmApp/components/forms/findCustomer.jsp"></jsp:include>
        <jsp:include page="/crmApp/components/tables/customersListTable.jsp"></jsp:include>
<jsp:include page="/crmApp/common/coreHtml/siteCloseSection.jsp"></jsp:include>
