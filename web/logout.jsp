<%-- 
    Document   : logout
    Created on : 04/04/2016, 18:24:30
    Author     : Oriol-Sony Vaio
--%>

<%@ page session="true"%>
<%@include file="/includes/includes-css-js.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro y consulta de videos</title>
    </head>
    <body>

        <div id="mystyle" class="login" style="text-align: center;">

            <h2>El usuario '<%=request.getSession().getAttribute("usuario")%>' ha cerrado la sesion.
            </h2> 
            <% session.invalidate();%>

            <br/><br/>
            <a href="index.jsp">Login/Registrarse</a>

        </div>

    </body>
</html>