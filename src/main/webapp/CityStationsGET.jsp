<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/burgermenu.jsp"/>
<div style="margin-top:15%;">
    <div class="text-center">
        <div class="text-center">
            <h1 class="text-white text-center align-middle"> Wpisz nazwę interesującego Cię państwa. </h1>
            <form action="country_stations" method="post">
                <input type="text" name="userCountry">
                <button type="submit">Znajdz</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>