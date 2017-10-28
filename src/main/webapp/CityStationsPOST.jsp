<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/burgermenu.jsp"/>
<div style="margin-top:5%;">
    <div class="text-center">
        <h1 class="text-white text-center align-middle"> Wpisz nazwę interesującego Cię miasta. </h1>
        <form action="city_stations" method="post" class=" mb-4">
            <input type="text" name="userCity">
            <button type="submit">Znajdź</button>
            <span class="text-white text-center align-middle">
            <h1><b> Stacje rowerowe znajdujące sie w ${userCity}</b></h1>
        </span>
            <div class="row justify-content-md-center">
                <div class="col-5">
                    <table class="table table-striped mt-4 table-inverse table-hover">
                        <thead class="thead-inverse">
                        <tr>
                            <th>Stacja</th>
                        </tr>
                        </thead>
                        <table class="table table-striped mt-4 table-inverse table-hover">
                            <c:forEach items="${places}" var="place">
                                <tr>
                                    <td>${place.name}</td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </table>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
