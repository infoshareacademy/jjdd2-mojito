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
        <div style="height:985px; overflow-y: scroll;" class="text-center">
                <table class="table table-striped mt-4 table-inverse table-hover">
                    <thead class="thead-inverse">
                    <tr>
                        <th>Miasto</th>
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
    <div id="top_x_div" style="width: 1200px; height: 900px;"></div>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
        google.charts.load('current', {'packages':['bar']});
        google.charts.setOnLoadCallback(drawStuff);

        function drawStuff() {
            var data = new google.visualization.arrayToDataTable([
                ['Miasto', 'Ilość stacji'],
                <c:forEach items="${places}" var="place">
                ["${place.name}", ${place.numOfPlaces}],
                </c:forEach>
            ]);

            var options = {
                title: 'Chess opening moves',
                height: 950,
                width: 1050,
                bars: 'horizontal',
                axes: {
                    x: {
                        0: { side: 'top', label: 'Stacje'}
                    }
                },
                bar: { groupWidth: "90%" },
                explorer : {
                actions: ['dragToZoom', 'rightClickToReset']
                /* you can add more options */
            }
            };

            var chart = new google.charts.Bar(document.getElementById('top_x_div'));
            chart.draw(data, options);
        };
    </script>
</div>
</body>
</html>