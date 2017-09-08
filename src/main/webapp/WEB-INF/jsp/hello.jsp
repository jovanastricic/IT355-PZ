<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="http://cdn.bootcss.com/animate.css/3.5.1/animate.min.css">
    <link href="<c:url value="/resources/slider.css" />" rel="stylesheet"  type="text/css" />
    <script src="<c:url value="/resources/sliderJS.js" />"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .mySlides {display:none;}
    </style>
</head>

<%@include file="he.jsp" %>

<h2 class="w3-center">Dobrodosli u Dentix</h2>

<div class="w3-content w3-section" style="max-width:500px">
    <img class="mySlides" src="http://chakolasthedentist.com/system/view/uploads/gallery/featured-photo-logo-595540.jpg" style="width:100%">
    <img class="mySlides" src="http://nebula.wsimg.com/53136c6364e207d6167d931ad9430ba2?AccessKeyId=E674346D692ADA13C927&disposition=0&alloworigin=1" style="width:100%">
    <img class="mySlides" src="http://www.nw1dentalcare.co.uk/wp-content/uploads/2016/09/6cd06-fromthistothis-1024x768.jpg" style="width:100%">
</div>
<div>
    <script>
        var myIndex = 0;
        carousel();

        function carousel() {
            var i;
            var x = document.getElementsByClassName("mySlides");
            for (i = 0; i < x.length; i++) {
                x[i].style.display = "none";
            }
            myIndex++;
            if (myIndex > x.length) {
                myIndex = 1
            }
            x[myIndex - 1].style.display = "block";
            setTimeout(carousel, 2000); // Change image every 2 seconds
        }
    </script>
</div>



     <%@include file="footer.jsp" %>

























<h1>Zdravo, korisnice!</h1>
<h1> ${message}</h1>

<sec:authorize access="hasRole('ROLE_USER')">
    <c:url value="/j_spring_security_logout" var="logoutUrl" />
    <form action="${logoutUrl}" method="post" id="logoutForm">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
    <script>
        function formSubmit() {
            document.getElementById("logoutForm").submit();
        }
    </script>
    <c:if test="${pageContext.request.userPrincipal.name!= null}">
        <h2>
            Vase korisnicko ime je :
            ${pageContext.request.userPrincipal.name} | <a href="javascript:formSubmit()">
                Logout</a>
        </h2>
    </c:if>
</sec:authorize>
