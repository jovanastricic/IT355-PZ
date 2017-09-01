<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSP Page</title>
    </head>
    <body>
        <form:form method="POST" modelAttribute="usluga">
            <form:label path="tip_usluga">
                Tip usluge
            </form:label>
            <form:input  id="tip_usluga" placeholder="tip_usluga" path="tip_usluga" />
            
            <form:label path="naziv_usluga">
                Naziv usluge
            </form:label>
            <form:input id="naziv_usluga" placeholder="naziv_usluga" path="naziv_usluga" />
            
            <form:label path="cena_usluga">
                Cena usluge
            </form:label>
            <form:input id="cena_usluga" placeholder="cena_usluga" path="cena_usluga" />
            
            <button type="submit">Dodaj</button>
        </form:form>
    </body>
</html>