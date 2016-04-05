<%-- 
    Document   : userInfo
    Created on : 04/04/2016, 19:59:04
    Author     : Oriol-Sony Vaio
--%>

<%@page import="model.Usuario"%>
<%@page language="java"%>
<%@include file="/includes/includes-css-js.jsp" %>
<!DOCTYPE html>
<html>
    <head>
    </head>
    <body>
        <% String usuario = (String) session.getAttribute("usuario");
            System.out.println(usuario);
            if (usuario == null) {
                response.sendRedirect("index.jsp");
                return;
            }
        %>

        Bienvenido <b><%=usuario%></b>
        <a href="logout.jsp">Logout</a>
    </body>
</html>
