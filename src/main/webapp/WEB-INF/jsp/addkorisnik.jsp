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
        <form:form method="POST" modelAttribute="korisnik">
            <form:label path="ime_korisnik">
                Ime
            </form:label>
            <form:input  id="ime_korisnik" placeholder="ime_korisnik" path="ime_korisnik" />
            
            <form:label path="prezime_korisnik">
                Prezime
            </form:label>
            <form:input id="prezime_korisnik" placeholder="prezime_korisnik" path="prezime_korisnik" />
            
            <form:label path="adresa_korisnik">
                Adresa
            </form:label>
            <form:input id="adresa_korisnik" placeholder="adresa_korisnik" path="adresa_korisnik" />
            
            <form:label path="email_korisnik">
                Email
            </form:label>
            <form:input id="email_korisnik" placeholder="email_korisnik" path="email_korisnik" />
            
            <form:label path="telefon_korisnik">
                Telefon
            </form:label>
            <form:input id="telefon_korisnik" placeholder="telefon_korisnik" path="telefon_korisnik" />
            
            <button type="submit">Dodaj</button>
        </form:form>
    </body>
</html>