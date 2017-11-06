<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div class="col-3">
    <div class="tab-content" id="v-pills-tabContent">
            <div style="height:985px; overflow-y: scroll;" class="text-center ">
                <table class="table table-striped mt-4 table-inverse table-hover">
                    <thead class="thead-inverse">
                    <tr>
                        <th>Kraj</th>
                        <th>Ilość stacji</th>
                    </tr>
                    </thead>
                        <c:forEach items="${places}" var="place">
                            <tr>
                                <td>${place.name}</td>
                                <td>${place.numOfPlaces}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </table>
            </div>
        </div>
    </div>
    <div class="col-7">
        <div class="row justify-content-md-center">
            <div id="regions_div" style="width: 100%; height: 990px;"></div>
            <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            <script type="text/javascript">
                google.charts.load('current', {
                    'packages':['geochart'],
                    'mapsApiKey': 'AIzaSyD-9tSrke72PouQMnMX-a7eZSW0jkFMBWY'
                });
                google.charts.setOnLoadCallback(drawRegionsMap);


                function drawRegionsMap() {
                    var data = google.visualization.arrayToDataTable([
                        ['Country', 'Stacje'],
                        <c:forEach items="${places}" var="place">
                        ["${place.name}", ${place.numOfPlaces}],
                        </c:forEach>
                    ]);

                    var options = {};

                    var chart = new google.visualization.GeoChart(document.getElementById('regions_div'));

                    chart.draw(data, options);
                }
            </script>
        </div>
    </div>

</body>
</html>
