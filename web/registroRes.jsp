<%-- 
    Document   : registroRes
    Created on : 01/03/2016, 12:46:57
    Author     : Oriol Gasset
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/includes-css-js.jsp" %>
<% Boolean result = (Boolean) request.getAttribute("result");%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <div id="mystyle" class="login" style="text-align: center;">    

            <h2>${message}</h2>
            <% if (!result) {%>
            <a href="index.jsp">Volver a la página de registro</a>
            <%} else {%>
            <a href="videoManagement.jsp">Continuar</a>
            <%}%>
        </div>

    </body>
</html>
