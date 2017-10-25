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
                        <th>Stacja</th>
                    </tr>
                    </thead>
                    <table class="table table-striped mt-4 table-inverse table-hover">
                        <c:forEach items="${places}" var="p">
                            <tr>
                                <td>${p.name}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
