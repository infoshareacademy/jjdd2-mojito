<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatibile" content="ie-edge, chrome-1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="MojitoBikeProject">
    <%--<link href="resources/fotolia-80738841.png" rel="shortcut icon" type="image/x-icon">--%>
    <meta name="description" content="">
    <title>MOHITOBIKEPROJECT</title>

    <link href="${pageContext.request.contextPath}/resources/style.css" rel="stylesheet" type="text/css">

    <%--no cache--%>
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate"/>
    <meta http-equiv="Pragma" content="no-cache"/>
    <meta http-equiv="Expires" content="0"/>
</head>

<body>

Wysylanie Email statystyki wyszukiwania


<form action="/MohitoBikeProject/portal/Email" method="post"  enctype="multipart/form-data">
    <button type="submit">WYŚLIJ</button>
</form>


</body>
</html>