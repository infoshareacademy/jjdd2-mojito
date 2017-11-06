<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div>
    <div class="text-center">
        <div class="text-center">
            <h1 class="text-white text-center align-middle"> Wpisz nazwę interesującego Cię kraju. </h1>
            <form action="country_stations" method="post">
                <input type="text" name="userCountry">
                <button type="submit">Znajdź</button>
                <div class="col-6"><img src="http://rowery.rzeszow.pl/wp-content/uploads/2015/08/stacja-naprawy-rower%C3%B3w-rzesz%C3%B3w.jpg" alt="Mountain View" width="1500" height="880">
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>