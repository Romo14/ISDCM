<%-- 
    Document   : videoManagement
    Created on : 31/03/2016, 23:42:01
    Author     : Oriol-Sony Vaio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String result = (String) request.getAttribute("message");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro y consulta de videos</title>
        <link rel="stylesheet" type="text/css" href="style.css">


    </head>
    <body>
        <div id="ok" class="message-success" style="display: none;">Video registrado correctamente</div>
        <div id="ko" class="message-error" style="display: none;">Error al registrar el video</div>
        <div id="mystyle" class="myform" title="Registro Videos">
            <form id="formVideo" name="formVideo" action = "registroVideo" method = "post" >
                <h1>Registro de videos</h1>
                <p>Por favor, introduzca la información del nuevo video<br><br>
                    <label>Titulo</label>
                    <input type="text" name="titulo" required maxlength="100"><br>
                    <label>Autor</label>
                    <input type="text" name="autor" required maxlength="100"><br>
                    <label>Descripcion</label>
                    <input type="text" name="descripcion" required maxlength="255"><br>
                    <label>Duracion</label>
                    <input type="time" name="duracion" required step="1"><br>
                    <label>Formato</label> 
                    <input type="text" name="formato" required maxlength="5"><br>
                    <label>Fecha de creacion</label>
                    <input type="date" id="fechaCreacion" name="fechaCreacion"><br>
                    <button type="submit">Registrar video</button>
            </form>

        </div>
        <div id="mystyle" class="myform">
            <h1>Búsqueda de videos</h1>
        </div>
        <script type="text/javascript">
            window.onload = function () {
                debugger;
                var message = result;
                var div;
                if (message == "ok") {
                    div = document.getElementById("ok");
                } else if (message = "ko") {
                    div = document.getElementById("ko");
                }
                div.style.display = 'block';

                setTimeout(div.style.display = 'block', 3000);
            };
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
