<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>




<head>
    <title>Login Page</title>
    <link href="<c:url value="/resources/register.css" />" rel="stylesheet"  type="text/css" />
    
</head>
<%@include file="he.jsp" %>

    <div class="container">
        <h1 class="welcome text-center">Registruj se: <br></h1>
        <div class="card card-container">
            <h2 class='login_title text-center'>Sign Up</h2>
            <hr>

           <form:form name='registerForm' class="form-signin"  modelAttribute="korisnik" method='POST'>
                <span id="reauth-email" class="reauth-email"></span>
                
                <p class="input_title">Ime</p>
               <form:input type="text" path="ime_korisnik" name="ime_korisnik" class="login_box" placeholder="ime" />
               
                   <p class="input_title">Prezime</p>
                <form:input type="text" id="prezime_korisnik" path="prezime_korisnik" name="prezime_korisnik" class="login_box" placeholder="prezime" />
                
                    <p class="input_title">Adresa</p>
               <form:input type="text" id="adresa_korisnik" path="adresa_korisnik" name="adresa_korisnik" class="login_box" placeholder="adresa" />
               
                   <p class="input_title">Email</p>
                <form:input type="text" id="email_korisnik" path="email_korisnik" name="email_korisnik" class="login_box" placeholder="email" />
               
                    <p class="input_title">Telefon</p>
                <form:input type="text" id="telefon_korisnik" path="telefon_korisnik" name="telefon_korisnik" class="login_box" placeholder="telefon" />
               
                    <p class="input_title">Username</p>
                <form:input type="text" id="username" path="username" name="username" class="login_box" placeholder="username" />
               
                    <p class="input_title">Password</p>
                <form:input type="password" id="password" path="password" name="password" class="login_box" placeholder="********" />
                
                <button class="btn btn-lg btn-primary" name="submit"type="submit">Sign Up</button>
               
                </form:form><!-- /form -->
        </div><!-- /card-container -->
    </div><!-- /container -->
</body>
     <%@include file="footer.jsp" %>

