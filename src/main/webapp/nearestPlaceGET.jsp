<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import = "java.util.Map" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
    <style>
        /* Always set the map height explicitly to define the size of the div
         * element that contains the map. */
        #map {
            height: 100%;
        }
        /* Optional: Makes the sample page fill the window. */
        html, body {
            height: 100%;
            margin: 0;
            padding: 0;
        }
        #floating-panel {
            position: absolute;
            top: 10px;
            left: 25%;
            z-index: 5;
            background-color: #fff;
            padding: 5px;
            border: 1px solid #999;
            text-align: center;
            font-family: 'Roboto','sans-serif';
            line-height: 30px;
            padding-left: 10px;
        }
    </style>
    <script>
        pos={};

    </script>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div>
    <div style="margin-top:15%;" class="text-center">
        <c:if test="${sessionScope.formatEx == true}">
            <span><h1><b>wpisales złe dane</b></h1></span>
        </c:if>
        <h2 class="text-white">Podaj swoje położenie geograficzne</h2>
        <form action="nearestStation" method="post">
            <h2 class="text-white">Podaj szerokość geograficzną (w formacie ułamka dziesiętnego)"</h2>
            <input type="text" name="latitiudeUser">
            <h2 class="text-white">Podaj długość geograficzną (w formacie ułamka dziesiętnego)" </h2>
            <input type="text" name="longitudeUser">
            <button class="btn btn-secondary btn-lg" type="submit">Znajdź</button>
        </form>
            <div id="floating-panel">
                <b>Mode of Travel: </b>
                <select id="mode">
                    <option value="DRIVING">Driving</option>
                    <option value="WALKING">Walking</option>
                    <option value="BICYCLING">Bicycling</option>
                    <option value="TRANSIT">Transit</option>
                </select>
            </div>
            <div id="map"></div>
            <script>


                function initMap() {
                    if (navigator.geolocation) {
                        navigator.geolocation.getCurrentPosition(function(position) {
                           pos = {
                                lat: position.coords.latitude,
                                lng: position.coords.longitude
                            };
                            var directionsDisplay = new google.maps.DirectionsRenderer;
                            var directionsService = new google.maps.DirectionsService;
                            var map = new google.maps.Map(document.getElementById('map'), {
                                zoom: 14,
                                center: {lat: 37.77, lng: -122.447}
                            });
                            directionsDisplay.setMap(map);

                            calculateAndDisplayRoute(directionsService, directionsDisplay);
                            document.getElementById('mode').addEventListener('change', function() {
                                calculateAndDisplayRoute(directionsService, directionsDisplay);
                            });


                        }, function() {

                        });
                    }

                }

                function calculateAndDisplayRoute(directionsService, directionsDisplay) {

                    var selectedMode = document.getElementById('mode').value;
                    directionsService.route({
                        origin: {lat: pos.lat+10, lng: pos.lng+60},  // Haight.
                        destination: {lat: 53.768, lng: 12.511},  // Ocean Beach.
                        // Note that Javascript allows us to access the constant
                        // using square brackets and a string value as its
                        // "property."
                        travelMode: google.maps.TravelMode[selectedMode]
                    }, function(response, status) {
                        if (status == 'OK') {
                            directionsDisplay.setDirections(response);
                        } else {
                            window.alert('Directions request failed due to ' + status);
                        }
                    });
                }
            </script>
            <script async defer
                    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0FNw2Jc23k1EB2IC5skPxu8FI0vVHB98&callback=initMap">
            </script>
    </div>
</div>
</body>
</html>
