<%-- 
    Document   : reproduccionVideo
    Created on : 02-may-2016, 12:01:17
    Author     : Marc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/includes-css-js.jsp" %>
<% Boolean localVideo = (Boolean) request.getAttribute("localVideo");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${titulo}</title>
    </head>
    <body>
        <% if (localVideo) {%>
            <video controls autoplay>
              <source src="${uri}" type="video/mp4">
              <source src="${uri}" type="video/ogg">
              <source src="${uri}" type="video/avi">
              <source src="${uri}" type="video/mkv">
              Your browser does not support the video tag.
            </video>
        <%} else {%>
            <iframe src="${uri}" width="520" height="415">
                
            </iframe>
            
        <%}%>
        
        <br/><br/>
        <a href="videoManagement.jsp">Volver</a>
    </body>
</html>
