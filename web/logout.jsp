<%-- 
    Document   : logout
    Created on : 04/04/2016, 18:24:30
    Author     : Oriol-Sony Vaio
--%>

<%@ page session="true"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro y consulta de videos</title>
        <link rel="stylesheet" type="text/css" href="style.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

    </head>
    <body>

        <div id="mystyle" class="login" style="text-align: center;">

            El usuario '<%=request.getSession().getAttribute("usuario")%>' ha cerrado la sesion.

            <% session.invalidate();%>

            <br/><br/>
            <a href="index.jsp">Login/Registrarse</a>

        </div>

    </body>
</html>