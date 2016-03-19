<%-- 
    Document   : registroRes
    Created on : 01/03/2016, 12:46:57
    Author     : Oriol Gasset
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% Boolean result = (Boolean)request.getAttribute("result");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h1>${message}</h1>
            <% if (!result){%>
                <a href="index.html">Volver a la página de registro</a>
            <%} else{%>
                <a href="videoManagement.html">Continuar</a>
            <%}%>

    </body>
</html>
