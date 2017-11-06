<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
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
                        function initMap(id) {
                           if(id){
                                var element = document.getElementById(id);
                                var lat = parseFloat(element.getAttribute("lat"));
                                var long = parseFloat(element.getAttribute("long"));
                           }
                           else{
                               var lat = ${places[0].latitudePlace}
                               var long = ${places[0].longitudePlace}
                           }


                            var map = new google.maps.Map(document.getElementById('map'), {
                                zoom: id ? 20 : 14,
                                center: {lat:lat, lng: long}

                            });
                            <c:forEach items="${places}" varStatus="loop"  var="place">
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
<div style="height:985px; overflow-y: scroll;" class="row justify-content-md-center">
    <div>
        <table class="table table-striped mt-4 table-inverse table-hover">
            <thead class="thead-inverse">
            <tr>
                <th>Stacja</th>
            </tr>
            </thead>
            <c:forEach items="${places}" varStatus="loop" var="place">
                <tr>
                    <td id="${loop.index}" lat="${place.latitudePlace}" long="${place.longitudePlace}" class="tableButton">${place.name}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<script>
    <c:forEach items="${places}" varStatus="loops"  var="place">
    var id = document.getElementById(${loops.index});
    id.onclick = function(e) {
        var index = ${loops.index};
        (function(index){
            initMap(index)
        }(index))
    };
    </c:forEach>
</script>
</body>
</html>
