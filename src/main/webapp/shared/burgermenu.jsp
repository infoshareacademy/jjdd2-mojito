<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-dark bg-dark" style=" position: fixed;
    top: 0;
    width: 100%;
    border-bottom: 1px solid #666;    z-index: 1;">
    <span class="navbar-brand"><b>Mohito Bike Project</b></span>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarText" aria-controls="navbarText" aria-expanded="true" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse show" id="navbarText" aria-expanded="true" style="">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="nearestStation">Najblizsza stacja</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="country_stations">stacje w kraju</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="city_stations">stacje w miescie</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="FindPlaceServlet">wyszukanie stacji w promieniu</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="countryStat">statystyki panst</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cityStat">statystyki miast</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="logout">wylogowanie</a>
            </li>
        </ul>
    </div>
</nav>

