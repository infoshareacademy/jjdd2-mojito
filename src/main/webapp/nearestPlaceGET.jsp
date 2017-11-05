<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div style="margin-top:15%;">
    <div class="text-center">
        <h2 class="text-white">Podaj swoje położenie geograficzne</h2>
        <form action="nearestStation" method="post">
            <h2 class="text-white">Podaj szerokość geograficzną (w formacie ułamka dziesiętnego)"</h2>
            <input type="text" name="latitiudeUser">
            <h2 class="text-white">Podaj długość geograficzną (w formacie ułamka dziesiętnego)" </h2>
            <input type="text" name="longitudeUser">
            <button class="btn btn-secondary btn-lg" type="submit">Znajdź</button>
        </form>
    </div>
</div>
</body>
</html>