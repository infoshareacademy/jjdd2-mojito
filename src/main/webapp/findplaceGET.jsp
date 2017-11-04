<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/body.jsp"/>
<div>
    <div style="margin-top:15%;" class="text-center">
        <c:if test="${sessionScope.formatEx == true}">
            <span><h1><b>wpisales złe dane</b></h1></span>
        </c:if>
        <h2 class="text-white">Zdefiniuj obszar wyszukiwania w km. </h2>
        <form action="FindPlaceServlet" method="post">
            <input type="number" name="choosenRadius">
            <h2 class="text-white">Podaj szerokość geograficzną (w formacie ułamka dziesiętnego)</h2>
            <input type="text" name="latitiudeUser">
            <h2 class="text-white">Podaj długość geograficzną (w formacie ułamka dziesiętnego)</h2>
            <input type="text" name="longitudeUser">
            <button class="btn btn-secondary btn-lg" type="submit">Znajdź</button>
        </form>
    </div>
</div>
</body>
</html>
