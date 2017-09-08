<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<%@include file="he.jsp" %>



<html>
    <head>
        <title>Login Page</title>
         <link href="<c:url value="/resources/login.css" />" rel="stylesheet"  type="text/css" />
        <script src="https://use.typekit.net/ayg4pcz.js"></script>
        <script>try {
                Typekit.load({async: true});
            } catch (e) {
            }</script>
    </head>
    <body onload='document.loginForm.username.focus();'>
        <div class="container">
            <h1 class="welcome text-center">Uloguj se: <br></h1>
            <div class="card card-container">
                <h2 class='login_title text-center'>Login</h2>
                <hr>

                <form class="form-signin" action="<c:url value='/j_spring_security_check'/>" method='POST'>
                    <span id="reauth-email" class="reauth-email"></span>
                    <p class="input_title">Username</p>
                    <input type="text" id="username" name="username" class="login_box" placeholder="username" required autofocus>
                    <p class="input_title">Password</p>
                    <input type="password" id="password" name="password" class="login_box" placeholder="********" required>

                    <button class="btn btn-lg btn-primary" name="submit"type="submit">Login</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                </form><!-- /form -->
            </div><!-- /card-container -->
        </div><!-- /container -->
    </body>
     <%@include file="footer.jsp" %>
