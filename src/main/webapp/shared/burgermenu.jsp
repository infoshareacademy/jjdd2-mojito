<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-dark bg-dark" style=" position: fixed;
    top: 0;
    width: 100%;
    border-bottom: 1px solid #666;    z-index: 1;">
    <span class="navbar-brand"><b>Mohito Bike Project</b></span>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarText" aria-expanded="true" style="">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="nearestStation">Wyszukanie najbliższej stacji rowerowej.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="country_stations">Wyszukanie stacji w danym kraju.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="city_stations">Wyszukanie stacji w danym mieście.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="FindPlaceServlet">Wyszukanie stacji rowerowej w konkretnej odległości.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="countryStat">Ilości stacji rowerowych w państwach.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cityStat">Ilości stacji rowerowych w miastach.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="Statistics">Najczęściej wyszukiwane miasta.</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">Wylogowanie</a>
            </li>
        </ul>
    </div>
</nav>