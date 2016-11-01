<!DOCTYPE html>
<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2>Zakazivanje pregleda</h2>
<form:form method="POST" action="/PrviDomaci/addPregled" commandName="pregled">
    <table>
        <tr>
            <td><form:label path="imeIPrezime">Ime i prezime:</form:label></td>
            <td><form:input path="imeIPrezime" /></td>
        </tr>
        <tr>
            <td><form:label path="jmbg">jmbg:</form:label></td>
            <td><form:input path="jmbg" /></td>
        </tr>
        <tr>
            <td><form:label path="email">Email:</form:label></td>
            <td><form:input path="email" /></td>
        </tr>
        <tr>
            <td><form:label path="telefon">Telefon:</form:label></td>
            <td><form:input path="telefon" /></td>
        </tr>
        <tr>
            <td><form:label path="datum">Datum:</form:label></td>
            <td><form:input path="datum" /></td>
        </tr>
        <tr>
            <td><form:label path="vreme">Vreme:</form:label></td>
            <td><form:input path="vreme" /></td>
        </tr>
        <tr>
            <td><form:label path="opis">Opis:</form:label></td>
            <td><form:input path="opis" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Zakazi"/>
            </td>
        </tr>
    </table>
</form:form>