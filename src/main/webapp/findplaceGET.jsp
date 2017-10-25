<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/burgermenu.jsp"/>
<div style="margin-top:15%;">
    <div class="text-center">
        <h2 class="text-white">Wpisz odległosć wyszukiwania stacji. </h2>
        <form action="FindPlaceServlet" method="post">
            <input type="number" name="choosenRadius">
            <h2 class="text-white">Podaj szerokość geograficzną wzór XXXX.XXXX"</h2>
            <input type="text" name="latitiudeUser">
            <h2 class="text-white">Podaj długość geograficzną wzór XXXX.XXXX" </h2>
            <input type="text" name="longitudeUser">
            <button class="btn btn-secondary btn-lg" type="submit">Znajdz</button>
        </form>
    </div>
</div>
</body>
</html>
