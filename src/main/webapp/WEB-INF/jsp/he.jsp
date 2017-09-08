<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
    <head>
        <title>Ordinacija</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="<c:url value="/resources/headerStyle.css" />" rel="stylesheet"  type="text/css" />
        <link href="<c:url value="/resources/style.css" />" rel="stylesheet"  type="text/css" />
        <!-- JTabela -->
       
    </head>


    <body>
        <div class="header">
            <div class="headbanner">
                <nav class="navbar navbar-inverse">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <a class="navbar-brand" href="#">Dentix</a>
                        </div>
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="/PrviDomaci">Home</a></li>
                            <li><a href="onama">O nama</a></li>
                            <li><a href="usluge">Usluge</a></li>
                            <li><a href="http://www.gingerpricedds.com/cosmetic-dentistry-before-and-after-photos/">Galerija</a></li> 
                            <li><a href="saveti">Saveti</a></li> 
                            <li><a href="addtermin">Zakazivanje</a></li>
                            <li><a href="kontakt">Kontakt</a></li>
                        </ul>
                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                            <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
        <div class="container">

