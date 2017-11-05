<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body class="bg-dark" style="background: radial-gradient(#5e5d67de , #26262e);; opacity: 0.9;">
<div style="flex-wrap: inherit;" class="bd-example bd-example-tabs" >
    <div class="row" >
        <div class="col-2">
            <div class="nav flex-column nav-pills " style=" height: 100%;background: #fff; flex-wrap: inherit;" id="v-pills-tab " role="tablist" >
                <span style="margin-top:100px;padding:15px 10px ;border-radius: 0;" data-toggle="pill" id="v-pills-home-tab"   role="tab" aria-controls="v-pills-home" aria-selected="true">Menu</span>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;" href="nearestStation" role="tab" aria-controls="v-pills-profile" aria-selected="false">Wyszukanie najbliższej stacji rowerowej.</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="country_stations" role="tab" aria-controls="v-pills-messages" aria-selected="false">Wyszukanie stacji w danym kraju.</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="city_stations" role="tab" aria-controls="v-pills-settings" >Wyszukanie stacji w danym mieście.</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="FindPlaceServlet" role="tab" aria-controls="v-pills-settings" aria-selected="false">Wyszukanie stacji rowerowej w danymo obszarze.</a>
                <a class="nav-link" style=" padding:15px 10px ;border-radius: 0;"  href="countryStat" role="tab" aria-controls="v-pills-settings" aria-selected="false">Wyświetl stacje rowerowe w państwach.</a>
                <a class="nav-link" style=" padding:15px 10px ;border-radius: 0;"  href="cityStat" role="tab" aria-controls="v-pills-settings" aria-selected="false">Wyświetl stacje rowerowe w miastach</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="Statistics" role="tab" aria-controls="v-pills-settings" aria-selected="false">Najczęściej wyszukiwane miasta.</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="CountryStatistics" role="tab" aria-controls="v-pills-settings" aria-selected="false">Najczęściej wyszukiwane państwa.</a>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="Menu" role="tab" aria-controls="v-pills-settings" aria-selected="false">Powrót do strony głownej.</a>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <a class="nav-link" style=" padding:15px 10px; border-radius: 0;"  href="logout" role="tab" aria-controls="v-pills-settings" aria-selected="false">Wyloguj</a>

            </div>

        </div>
