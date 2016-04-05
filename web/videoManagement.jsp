<%-- 
    Document   : videoManagement
    Created on : 31/03/2016, 23:42:01
    Author     : Oriol-Sony Vaio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/includes/includes-css-js.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro y consulta de videos</title>


    </head>
    <body>

        <div id="ok" class="message-success" style="display: none">Video registrado correctamente</div>
        <div id="ko" class="message-error" style="display: none">Error al registrar el video</div>
        <div style="float: right; padding-right: 40px">
            <%@include file="userInfo.jsp" %>
        </div>
        <br>
        <div  style="text-align: center">
            <div id="mystyle" class="container" title="Registro Videos" style="display: inline-block; vertical-align: top;">
                <h1>Registro de videos</h1>
                <p>Por favor, introduzca la información del nuevo vídeo:<br>
                <form id="formVideo" name="formVideo" action = "registroVideo" method = "post" >

                    <label>Titulo</label>
                    <input type="text" name="titulo" required maxlength="100"><br>
                    <label>Autor</label>
                    <input type="text" name="autor" required maxlength="100"><br>
                    <label>Descripcion</label>
                    <input type="text" name="descripcion" required maxlength="255"><br>
                    <label>Duracion</label>
                    <input type="time" name="duracion" required step="3" value="00:00:00"><br>
                    <label>Formato</label> 
                    <input type="text" name="formato" required maxlength="5"><br>
                    <label>Fecha de creacion</label>
                    <input type="date" id="fechaCreacion" name="fechaCreacion"><br>
                    <button type="submit">Registrar video</button>
                </form>

            </div>
            <div id="mystyle" class="container" title="Buscar Videos" style="display: inline-block; vertical-align: top">
                <h1>Búsqueda de videos</h1>
                <p>Filtrar por atributos:<br>
                <form id="buscarVideoForm" name="buscarVideoForm" action = "buscarVideo" method = "post" >
                    <label>Titulo</label>
                    <input type="text" name="tituloBusqueda"  maxlength="100" value="${tituloBusqueda}"><br>
                    <label>Autor</label>
                    <input type="text" name="autorBusqueda"  maxlength="100" value="${autorBusqueda}"><br>
                    <label>Descripcion</label>
                    <input type="text" name="descripcionBusqueda"  maxlength="255" value="${descripcionBusqueda}"><br>
                    <label>Duracion</label>
                    <input type="time" name="duracionBusqueda"  step="1" value="${duracionBusqueda}"><br>
                    <label>Formato</label> 
                    <input type="text" name="formatoBusqueda"  maxlength="5" value="${formatoBusqueda}"><br>
                    <label>Fecha de creacion</label>
                    <input type="date" id="fechaCreacionBusqueda" name="fechaCreacion" value="${fechaCreacionBusqueda}"><br>
                    <button type="submit">Buscar videos</button>
                </form>
            </div>
            <c:if test="${table == 'mostrar'}">
                <div id="mystyle" class="container" style="width: 836px">
                    <h1>Resultado de la búsqueda</h1>
                    <table id="buscarVideoTable" style="width: 100%">
                        <tr style="background-color: #D9AB71">
                            <td>Id</td>
                            <td>Título</td>
                            <td>Autor</td>
                            <td>Descripción</td>
                            <td>Fecha creación</td>
                            <td>Duración</td>
                            <td>Reproducciones</td>
                            <td>Formato</td>
                        </tr>
                        <c:if test="${fn:length(videos) gt 0}">
                            <c:forEach items="${videos}" var="video">
                                <tr>
                                    <td>${video.id}</td>
                                    <td>${video.titulo}</td>
                                    <td>${video.autor}</td>
                                    <td>${video.descripcion}</td>
                                    <td>${video.fechaCreacion}</td>
                                    <td>${video.duracion}</td>
                                    <td>${video.reproducciones}</td>
                                    <td>${video.formato}</td>
                                </tr>
                            </c:forEach>
                        </c:if>
                        <c:if test="${fn:length(videos) eq 0}">
                            <tr>
                                <td>No se han encontrado resultados</td>
                            </tr> 
                        </c:if>
                    </table>
                </div>
            </c:if>
        </div>
        <script type="text/javascript">

            window.onload = function () {

                var okDiv = document.getElementById("ok");
                var koDiv = document.getElementById("ko");
                if ('<c:out value="${message}" />' == "ok") {
                    $("#ok").dialog({
                        modal: true,
                        closeOnEscape: false,
                        position: {at: "left top", of: window},
                        open: function (event, ui) {
                            $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
                        },
                        width: 500,
                        height: 80,
                    });
                    setTimeout(function () {
                        $("#ok").dialog('close')
                    }, 2000);
                }
                if ('<c:out value="${message}" />' == "ko") {
                    $("#ko").dialog({
                        modal: true,
                        closeOnEscape: false,
                        open: function (event, ui) {
                            $(".ui-dialog-titlebar-close", ui.dialog | ui).hide();
                        },
                        width: 200,
                        height: 80,
                    });
                    setTimeout(function () {
                        $("#ko").dialog('close')
                    }, 2000);
                }
            }

            function setInputDate(_id) {
                var _dat = document.querySelector(_id);
                var hoy = new Date(),
                        d = hoy.getDate(),
                        m = hoy.getMonth() + 1,
                        y = hoy.getFullYear(),
                        data;
                if (d < 10) {
                    d = "0" + d;
                }
                ;
                if (m < 10) {
                    m = "0" + m;
                }
                ;
                data = y + "-" + m + "-" + d;
                console.log(data);
                _dat.value = data;
            }
            ;
            setInputDate("#fechaCreacion");


        </script>
    </body>

</html>
