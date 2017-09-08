<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="headerH.jsp" %>
<h1>Usluge list</h1>
<c:if test="${!empty usluge}">

    <table class="table table-striped">
        <thead>
            <tr>
                <th>Tip usluge</th>
                <th>Naziv usluge</th>
                <th>Cena usluge</th>
                <th>Ordinacija</th>
                <th >Edit</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody> 
            <c:forEach items="${usluge}" var="usluga">

                <tr>
                    <td>${usluga.tip_usluga}</td>
                    <td>${usluga.naziv_usluga}</td>
                    <td>${usluga.cena_usluga}</td>
                    <td>${usluga.ordinacija}</td>
                    <td><a href="<c:url value='/editUsluga/${usluga.id_usluga}' />">edit</a></td>
                    <td><a href="<c:url value='/deleteusluga/${usluga.id_usluga}' />">delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<%@include file="footerH.jsp" %>