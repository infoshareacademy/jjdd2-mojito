<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
    <<jsp:include page="shared/body.jsp"/>
<div>
    <%--<div style="margin-top:15%;" class="text-center">--%>
            <%--<span class="text-white"><h1>Stacja : <b>${destinationStationName}</b></h1></span>--%>
            <%--<iframe width="100%" height="820" frameborder="0" style="border:0"--%>
                    <%--src="https://www.google.com/maps/embed/v1/directions?origin=${longitudeUser},${latitiudeUser}&amp;destination=${destination}&amp;key=AIzaSyBhfSZFVEUausxMjtYoA-DeCfjM7wRgy0I"--%>
                    <%--allowfullscreen=""></iframe>--%>
                <script>
                    var directionsDisplay;
                    var directionsService = new google.maps.DirectionsService();
                    var map;

                    function initialize() {
                        directionsDisplay = new google.maps.DirectionsRenderer();
                        var chicago = new google.maps.LatLng(41.850033, -87.6500523);
                        var mapOptions = {
                            zoom:7,
                            center: chicago
                        }
                        map = new google.maps.Map(document.getElementById('map'), mapOptions);
                        directionsDisplay.setMap(map);
                    }

                    function calcRoute() {
                        var start = document.getElementById('start').value;
                        var end = document.getElementById('end').value;
                        var request = {
                            origin: start,
                            destination: end,
                            travelMode: 'DRIVING'
                        };
                        directionsService.route(request, function(result, status) {
                            if (status == 'OK') {
                                directionsDisplay.setDirections(result);
                            }
                        });
                    }
                </script>
    <%--</div>--%>
</div>
</body>
</html>
