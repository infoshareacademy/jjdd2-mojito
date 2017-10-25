<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/shared/head.jsp"/>
</head>
<body class="bg-dark">
<div style=\"margin-top:15%;\">\n" +
    "      \n" +
    "      <div class=\"text-center\">" +
<div class="list-group d-inline-flex p-2 ">
  <span class="btn btn-secondary btn-lg"
        class="list-group-item list-group-item-action active">
    Menu
  </span>
    <a href="nearestStation" class="list-group-item list-group-item-action">
        1.Wyszukanie najbliższej stacji rowerowej.</a>
    <a href="country_stations" class="list-group-item list-group-item-action">
        2.Wyszukanie stacji w danym kraju.</a>
    <a href="city_stations" class="list-group-item list-group-item-action">
        3.Wyszukanie stacji w danym mieście.</a>
    <a href="FindPlaceServlet" class="list-group-item list-group-item-action">
        4.Wyszukanie stacji rowerowej w konkretnej odległości.</a>
    <a href="countryStat" class="list-group-item list-group-item-action">
        5.Statystyki ilości stacji rowerowych w danym państwie.</a>
    <a href="cityStat" class="list-group-item list-group-item-action">
        6.Statystyki ilości stacji rowerowych w danym mieście</a>
    <a href="Statistics" class="list-group-item list-group-item-action">
        7.Najczęściej wyszukiwane miasta.</a>
</div>
</body>
</html>

