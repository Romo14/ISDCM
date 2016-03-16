<%-- 
    Document   : registroRes
    Created on : 01/03/2016, 12:46:57
    Author     : Oriol Gasset
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>${message}</h1>
        <c:choose>
            <c:when test="${message == ""}">
                <a href="index.html">Volver a la página de registro</a>
                <br />
            </c:when>
            <c:when test="${message == ""}">
                <a href="videoManagement.html">Continuar</a>
                <br />
            </c:when>
        </c:choose>
    </body>
</html>
