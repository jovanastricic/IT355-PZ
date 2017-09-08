<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<head>
    <script src="https://code.jquery.com/jquery-3.1.1.js" integrity="sha256-16cdPddA6VdVInumRGo6IbivbERE8p7CQR3HzTBuELA=" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/flatly/bootstrap.min.css"/>


    <script>
        $(document).ready(function () {
            $("table").DataTable();
        });
    </script>

</head>
<%@include file="he.jsp" %>
<h1>Usluge</h1>
<c:if test="${!empty usluge}">

    <table class="table table-striped">
        <thead>
            <tr>
                <th width="200"> Tip</th>
                <th width="200"> Naziv</th>
                <th width="200">Cena</th>
            </tr>
        </thead>
        <tbody> 
            <c:forEach items="${usluge}" var="usluga">
                <tr>
                    <td>${usluga.tip_usluga}</td>
                    <td path="naziv">${usluga.naziv_usluga}</td>
                    <td>${usluga.cena_usluga}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>
<%@include file="footer.jsp" %>
