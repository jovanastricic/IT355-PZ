<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page session="true"%>

<head>
    <title>Kontakt</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" type="text/css"/>
    <script src="https://code.jquery.com/jquery-3.1.1.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="<c:url value="/resources/email.css" />" rel="stylesheet"  type="text/css" />
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<%@include file="he.jsp" %> 
<div class="container" style="float: left; height: 40%; margin-left: 30px; margin-top: 30px;">
    <div class="row-fluid">
        <div class="span8" style="float: left;">
            <iframe width="500" height="350" frameborder="0" scrolling="no" marginheight="0" marginwidth="0" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2832.28869179649!2d20.47364691511048!3d44.774919487191205!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x475a70597c7ecbd5%3A0x5b8289bea701947b!2sVojvode+Stepe+180%2C+Beograd!5e0!3m2!1sen!2srs!4v1504827058439"></iframe>
        </div>

            <div class="span4" style="float: left; height: 40%; margin-left: 80px; margin-top: 50px;">
    		<h2>Kontakt</h2>
    		<address>
    			<strong>email: dentix@gmail.com</strong><br>
    			Vojvode Stepe 180<br>
    			Srbija<br>
    			11 000 Beograd<br>
    			<abbr title="Telefon">Telefon:</abbr> 011/555-333
    		</address>
    	</div>
    </div>
</div>
 <%@include file="footer.jsp" %>

