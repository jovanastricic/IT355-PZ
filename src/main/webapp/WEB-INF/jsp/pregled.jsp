<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@include file="he.jsp" %>


<h1>Zakaži pregled</h1>

<div class="container" style="height: 100%; ">

    <div class="col-md-6 col-md-offset-3">

        <form:form method="POST"  modelAttribute="termin">
            <div class="form-group">
                <form:label path="dan_termin">
                    Datum pregleda
                </form:label>
                <form:input type="dan_termin" class="form-control" id="dan_termin" placeholder="dan" path="dan_termin" />
            </div>

            <div class="form-group">
                <form:label path="vreme_termin">
                    Vreme pregleda
                </form:label>
                <form:input type="vreme_termin" class="form-control" id="vreme_termin" placeholder="vreme" path="vreme_termin" />
            </div>

            <div class="form-group">
                <form:label path="opis_termin">
                    Opis
                </form:label>
                <form:input type="opis_termin" class="form-control" id="opis_termin" placeholder="opis" path="opis_termin" />
            </div>
            <div class="form-group">
                <form:label for="id_ordinacija" path="id_ordinacija">Ordinacije</form:label>


                <form:select id="slcRole" class="form-control" path="id_ordinacija">
                    <form:option value="">SELECT</form:option>
                    <form:options items="${ordinacije}" itemValue="id_ordinacija" itemLabel="naziv_ordinacija" />
                </form:select>
            </div>
            <button type="submit" class="btn btn-primary">ZAKAŽI</button>
        </form:form>
    </div>
</div>
<%@include file="footer.jsp" %>