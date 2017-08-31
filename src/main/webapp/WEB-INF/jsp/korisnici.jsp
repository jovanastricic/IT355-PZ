<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Korisnici:</h1>
        <c:if test="${!empty korisnici}">
            <table>
                <tr> 
                    <th width="200"> Id</th>
                    <th width="200"> Ime</th>
                    <th width="200"> Prezime</th>
                    <th width="200"> Adresa</th>
                    <th width="200"> Email</th>
                    <th width="200"> Telefon</th>
                </tr>
                <c:forEach items="${korisnici}" var="korisnik">
                    <tr>
                        <td path="id">${korisnik.id_korisnik}</td>
                        <td path="ime">${korisnik.ime_korisnik}</td>
                        <td path="prezime">${korisnik.prezime_korisnik}</td>
                        <td>${korisnik.adresa_korisnik}</td>
                        <td>${korisnik.email_korisnik}</td>
                        <td>${korisnik.telefon_korisnik}</td>
                        <td> <a  href="<c:url value='/deletekorisnik/${korisnik.id_korisnik}.${korisnik.ime_korisnik}.${korisnik.prezime_korisnik}'/>">Obriši</a>
                        <td> <a  href="<c:url value='/updatekorisnik/${korisnik.id_korisnik}'/>">Izmeni</a>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
        </table>
    </body>
</html>