<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/burgermenu.jsp"/>
<div style="margin-top:5%;">

    <div class="text-center"><span
            class="text-white"><h1>Stacja : <b>Leipzig International School (König-Albert-Brücke)</b></h1></span>
        <iframe width="100%" height="820" frameborder="0" style="border:0"
                src="https://www.google.com/maps/embed/v1/directions?origin=${longitudeUser},${latitiudeUser}&amp;destination=${destination}&amp;key=AIzaSyBhfSZFVEUausxMjtYoA-DeCfjM7wRgy0I"
                allowfullscreen=""></iframe>
    </div>
</div>
</body>
</html>