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
    <div class="text-center col-9">
        <c:if test="${sessionScope.formatEx == true}">
            <span><h1><b>wpisales złe dane</b></h1></span>
        </c:if>
            <div id="floating-panel">
                <b>Wybierz rodzaj transportu :  </b>
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
                                center: {lat: 51.77, lng: 12.447}
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
                    console.log(pos);

                    var selectedMode = document.getElementById('mode').value;
                    directionsService.route({
                        origin: {lat: pos.lat, lng: pos.lng},  // Haight.
                        destination: {lat: 52.3485329, lng: 20.9418336},  // Ocean Beach.
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
</body>
</html>
