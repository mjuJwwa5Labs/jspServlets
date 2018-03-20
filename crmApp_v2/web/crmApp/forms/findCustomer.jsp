<%--
  Created by IntelliJ IDEA.
  User: juszc
  Date: 2018-03-18
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form class="form-horizontal" action="/logged/customers/customer" method="post">
    <div class="form-group">
        <label class="control-label col-sm-2" for="id">Identyfikator</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="id" name="id" placeholder="Id klienta">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="firstname">Imię</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="firstname" name="firstname" placeholder="Imię klienta">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2" for="lastname">Nazwisko</label>
        <div class="col-sm-6">
            <input type="text" class="form-control" id="lastname" name="lastname" placeholder="Nazwisko klienta">
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2"></label>
        <div class="col-sm-2">
            <span class="label label-default">Data od</span>
        </div>
        <div class="col-sm-2">
            <span class="label label-default">Data do</span>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Data utworzenia konta</label>
        <div class="col-sm-2">
            <input type="date" class="form-control" id="created_from" name="created_from" disabled>
        </div>
        <div class="col-sm-2">
            <input type="date" class="form-control" id="created_to" name="created_to" disabled>
        </div>
    </div>
    <div class="form-group">
        <label class="control-label col-sm-2">Data ostatniej aktualizacji</label>
        <div class="col-sm-2">
            <input type="date" class="form-control" id="modified_from" name="modified_from" disabled>
        </div>
        <div class="col-sm-2">
            <input type="date" class="form-control" id="modified_to" name="modified_to" disabled>
        </div>
    </div>

    <div class="form-group">
        <div class="col-sm-offset-2 col-sm-6">
            <button type="submit" class="btn btn-default">Wyszukaj</button>
        </div>
    </div>
</form>