<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ page import="java.util.Map" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<jsp:include page="shared/head.jsp"/>--%>
    <%--<script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>--%>
    <%--<style>--%>
        <%--/* Always set the map height explicitly to define the size of the div--%>
         <%--* element that contains the map. */--%>
        <%--#map {--%>
            <%--height: 100%;--%>
        <%--}--%>

        <%--/* Optional: Makes the sample page fill the window. */--%>
        <%--html, body {--%>
            <%--height: 100%;--%>
            <%--margin: 0;--%>
            <%--padding: 0;--%>
        <%--}--%>

        <%--#floating-panel {--%>
            <%--position: absolute;--%>
            <%--top: 10px;--%>
            <%--left: 25%;--%>
            <%--z-index: 5;--%>
            <%--background-color: #fff;--%>
            <%--padding: 5px;--%>
            <%--border: 1px solid #999;--%>
            <%--text-align: center;--%>
            <%--font-family: 'Roboto', 'sans-serif';--%>
            <%--line-height: 30px;--%>
            <%--padding-left: 10px;--%>
        <%--}--%>
    <%--</style>--%>
<%--</head>--%>
<%--<body class="bg-dark">--%>
<%--<jsp:include page="shared/body.jsp"/>--%>
<%--<div class="text-center col-9">--%>
    <%--<c:if test="${sessionScope.formatEx == true}">--%>
        <%--<span><h1><b>wpisales złe dane</b></h1></span>--%>
    <%--</c:if>--%>
    <%--<div id="floating-panel">--%>
        <%--<b>Wybierz rodzaj transportu : </b>--%>
        <%--<select id="mode">--%>
            <%--<option value="DRIVING">Driving</option>--%>
            <%--<option value="WALKING">Walking</option>--%>
            <%--<option value="BICYCLING">Bicycling</option>--%>
            <%--<option value="TRANSIT">Transit</option>--%>
        <%--</select>--%>
    <%--</div>--%>

    <%--<div id="map"></div>--%>


    <%--<script>--%>

        <%--function initMap() {--%>
            <%--function calculateAndDisplayRoute(directionsService, directionsDisplay, lat, lng) {--%>

                <%--var selectedMode = document.getElementById('mode').value;--%>
                <%--directionsService.route({--%>
                    <%--origin: {lat: ${latitiudeUser}, lng: ${longitudeUser}},--%>
                    <%--destination: {lat: ${destLat}, lng: ${destLng}},--%>
                    <%--travelMode: google.maps.TravelMode[selectedMode]--%>
                <%--}, function (response, status) {--%>
                    <%--if (status == 'OK') {--%>
                        <%--directionsDisplay.setDirections(response);--%>
                    <%--} else {--%>
                        <%--window.alert('Directions request failed due to ' + status);--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>

                    <%--var directionsDisplay = new google.maps.DirectionsRenderer;--%>
                    <%--var directionsService = new google.maps.DirectionsService;--%>
                    <%--var map = new google.maps.Map(document.getElementById('map'), {--%>
                        <%--zoom: 14,--%>
                        <%--center: {lat: ${latitiudeUser}, lng: ${longitudeUser}}--%>
                    <%--});--%>
                    <%--directionsDisplay.setMap(map);--%>

                    <%--calculateAndDisplayRoute(directionsService, directionsDisplay);--%>
                    <%--document.getElementById('mode').addEventListener('change', function () {--%>
                        <%--calculateAndDisplayRoute(directionsService, directionsDisplay);--%>
                    <%--});--%>




        <%--}--%>
    <%--</script>--%>
    <%--<script async defer--%>
            <%--src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA0FNw2Jc23k1EB2IC5skPxu8FI0vVHB98&callback=initMap">--%>
    <%--</script>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
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
