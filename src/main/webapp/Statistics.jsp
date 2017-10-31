<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="shared/head.jsp"/>
</head>
<body class="bg-dark">
<jsp:include page="shared/burgermenu.jsp"/>
<div style="margin-top:5%;">
    <div class="text-center">
        <div class="row justify-content-md-center">
            <div class="col-5">
                <table class="table table-striped mt-4 table-inverse table-hover">
                    <thead class="thead-inverse">
                    <tr>
                        <th>Miasto</th>
                        <th><span class="float-right">Liczba wyświetleń</th>
                    </tr>
                    </thead>
                    <table class="table table-striped mt-4 table-inverse table-hover">
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
</div>
<<<<<<< HEAD
<%--<input class="btn btn-primary" type="submit" value="Wyślij statystyki odwiedzin na adres Email">--%>
<h2><a class="text-warning" href="Email">link do wysyłki raportu</a></h2>
=======
>>>>>>> 964cba57f05a904fef4c0dd2ac89c7a6a032ca02
</body>
</html>
