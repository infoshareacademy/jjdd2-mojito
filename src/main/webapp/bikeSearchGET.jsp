<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<div style="margin-top:15%;">
    <div class="text-center">
        <h1 class="text-white ">Witaj w wyszukiwarce stacji rowerowych. </h1>
        <h2 class="text-white ">Wczytaj plik Xml do bazy danych. </h2>
        <form action="bikeSearch" method="post" enctype="multipart/form-data">
            <div class="row justify-content-md-center">
                <input type="file" class="col-3 form-control" name="userFile" style="text-align: center !important;">
                <button class="btn btn-secondary btn-lg" type="submit">Załaduj plik</button></div>
        </form>
    </div>
    </div>
</body>
</html>