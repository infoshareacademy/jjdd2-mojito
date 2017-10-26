<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<div style="margin-top:5%;">
    <div class="text-center">
        <h1 class="text-white text-center align-middle"> Wpisz nazwę interesującego Cię państwa. </h1>
        <form action="country_stations" method="post" class=" mb-4">

        <input type="text" name="userCountry">
        <button type="submit">Znajdz</button>
        <span class="text-white text-center align-middle">
            <h1><b> Stacje rowerowe znajdujące sie w  Germany</b></h1>
        </span>
        <div class="row justify-content-md-center">

            <thead class="thead-inverse">
            <tr>
                <th>Stacja</th>
                <th>Miasto</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${allPlaces}" var="place">
                <tr>
                    <td>${place.name}</td>
                </tr>
                </c:forEach>
            </tbody>
            </table>

        </div>
    </div>
    </div>
</div>
