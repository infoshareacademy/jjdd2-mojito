
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div style="margin-top:5%;">

    <div class="text-center"><span
            class="text-white"><h3>Stacja : <b>"${destinationStationName}"</b></h3></span>
        <iframe width="1525px" height="820px" frameborder="0" style="border:0"
                src="https://www.google.com/maps/embed/v1/directions?origin=${longitudeUser},${latitiudeUser}&amp;destination=${destination}&amp;key=AIzaSyBhfSZFVEUausxMjtYoA-DeCfjM7wRgy0I"
                allowfullscreen=""></iframe>
    </div>
</div>
</body>
</html>
