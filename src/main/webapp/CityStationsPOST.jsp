<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
    <style>
        #map {
            height: 830px;
            width: 100%;
        }
    </style>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div class="col-6">
    <div class="tab-content" id="v-pills-tabContent">
<div>
    <div class="text-center">
        <h1 class="text-white text-center align-middle"> Wpisz nazwę interesującego Cię miasta. </h1>
        <form action="city_stations" method="post" class=" mb-4">
            <input type="text" name="userCity">
            <button type="submit">Znajdź</button>
            <span class="text-white text-center align-middle">
            <h1><b> Stacje rowerowe znajdujące sie w ${userCity}</b></h1>
        </span>
            <div id="map"></div>
            <script>
                function initMap() {
                    var map = new google.maps.Map(document.getElementById('map'), {
                        zoom: 12,
                        center: {lat:${places[0].latitudePlace}, lng: ${places[0].longitudePlace}}
                    });
                    <c:forEach items="${places}" var="place">
                    var marker = new google.maps.Marker({
                        position: {lat: ${place.latitudePlace}, lng: ${place.longitudePlace}},
                        map: map
                    });
                    </c:forEach>
                }
            </script>
            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAg8P2obHgXkAFdbW_sUlNpl_8qL8w3nZ8&callback=initMap">
            </script>
        </form>
    </div>
    </div>
    </div>
</div>
<jsp:include page="shared/rightMenu.jsp"></jsp:include>
<div class="row justify-content-md-center">
    <div>
            <table class="table table-striped mt-4 table-inverse table-hover">
                <thead class="thead-inverse">
                <tr>
                    <th>Stacja</th>
                </tr>
                </thead>
                <c:forEach items="${places}" var="place">
                    <tr>
                        <td>${place.name}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
    </div>
</div>
</body>
</html>
