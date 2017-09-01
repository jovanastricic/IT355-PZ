<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>



<%@include file="headerH.jsp" %>
<h1>Add ordinacija</h1>
<div class="container">
    <div class="col-md-6 col-md-offset-3">
        <c:url var="addOrdinacija" value="/addOrdinacija" ></c:url>
        <form:form method="POST" modelAttribute="ordinacija">
            <% String success = (String) request.getAttribute("successMsg");%>
            <%= (success != null) ? "<div class=\"alert alert-success\">" + success + "</div>" : ""%>
            <div class="form-group">
                <form:input type="hidden" id="id_ordinacija" class="form-control" placeholder="id_ordinacija" path="id_ordinacija" />
                <form:label path="naziv_ordinacija">
                    Naziv ordinacija
                </form:label>
                <form:input type="naziv_ordinacija" class="form-control" id="naziv_ordinacija" placeholder="naziv_ordinacija" path="naziv_ordinacija" />
            </div>
            <div class="form-group">
                <form:label path="opis_ordinacija">
                    Opis ordinacije
                </form:label>
                <form:input type="opis_ordinacija" class="form-control" id="opis_ordinacija" placeholder="opis_ordinacija" path="opis_ordinacija" />
            </div>
            <div class="form-group">
                <form:label path="adresa_ordinacija">
                    Adresa ordinacije
                </form:label>
                <form:input type="adresa_ordinacija" class="form-control" id="adresa_ordinacija" placeholder="adresa_ordinacija" path="adresa_ordinacija" />
            </div>
            <div class="form-group">
                <form:label path="telefon_ordinacija">
                    Kontakt telefon
                </form:label>
                <form:input type="telefon_ordinacija" class="form-control" id="telefon_ordinacija" placeholder="telefon_ordinacija" path="telefon_ordinacija" />
            </div>
            <div class="form-group">
                <div class="form-group">
                    <form:label path="email_ordinacija">
                        Email 
                    </form:label>
                    <form:input type="email_ordinacija" class="form-control" id="email_ordinacija" placeholder="email_ordinacija" path="email_ordinacija" />
                </div>
                <div class="form-group">
                    <form:label path="radnovreme_ordinacija">
                        Radno vreme
                    </form:label>
                    <form:input type="radnovreme_ordinacija" class="form-control" id="radnovreme_ordinacija" placeholder="radnovreme_ordinacija" path="radnovreme_ordinacija" />
                </div>

                <button type="submit" class="btn btn-primary">ADD</button>
            </form:form>
        </div></div>
    <%@include file="footerH.jsp" %>