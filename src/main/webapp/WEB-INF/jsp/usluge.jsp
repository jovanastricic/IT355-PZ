<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Usluge</h1>
        <c:if test="${!empty usluge}">
            <table>
                <tr>
                    <th width="200"> Id</th>
                    <th width="200"> Tip</th>
                    <th width="200"> Naziv</th>
                    <th width="200">Cena</th>
                </tr>
                <c:forEach items="${usluge}" var="usluga">
                    <tr>
                        <td path="id">${usluga.id_usluga}</td>
                        <td>${usluga.tip_usluga}</td>
                        <td path="naziv">${usluga.naziv_usluga}</td>
                        <td>${usluga.cena_usluga}</td>
                        <td><a href="<c:url value='/deleteusluga/${usluga.id_usluga}.${usluga.naziv_usluga}'/>">Obriši</a>
                        <td><a href="<c:url value='/updateusluga/${usluga.id_usluga}'/>">Izmeni</a>
                            </td>
                        </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>