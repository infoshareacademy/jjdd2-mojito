<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="shared/head.jsp"/>
    <style>
        #map {
            height: 760px;
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
            <h3 class="text-white">Zdefiniuj obszar wyszukiwania w km. </h3>
            <form action="FindPlaceServlet" method="post">
                <input type="number" name="choosenRadius">
                <h3 class="text-white">Podaj szerokość geograficzną (w formacie ułamka dziesiętnego)</h3>
                <input type="text" name="latitiudeUser">
                <h3 class="text-white">Podaj długość geograficzną (w formacie ułamka dziesiętnego)</h3>
                <input type="text" name="longitudeUser">
                <button class="btn btn-secondary btn-lg" type="submit">Znajdź</button>
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
<div class="row justify-content-md-center">
    <div>
        <table class="table table-striped mt-4 table-inverse table-hover">
            <thead class="thead-inverse">
            <tr>
                <th>Stacja</th>
                <th>Miasto</th>
            </tr>
            </thead>
            <c:forEach items="${places}" varStatus="loop" var="place">
                <tr>
                    <td id="${loop.index}" lat="${place.latitudePlace}" long="${place.longitudePlace}" class="tableButton">${place.name}</td>
                    <td>${place.city}</td>
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
