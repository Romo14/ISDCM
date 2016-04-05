<%-- 
    Document   : index
    Created on : 04/04/2016, 17:48:10
    Author     : Oriol-Sony Vaio
--%>

<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
 <%@include file="/includes/includes-css-js.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro Usuarios</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">       
    </head>
    <body>

        <% String usuario = (String) session.getAttribute("usuario");
            System.out.println(usuario);
            if (usuario != null) {
                response.sendRedirect("videoManagement.jsp");
                return;
            }
        %>

        <div id="mystyle" class="myform" title="Log in">
            <form id="LoginForm" class="myform" name="form" action = "login" method = "post">
                <h1>Log in</h1>
                <label> Nombre usuario:</label>
                <input type="text" name="nickName" required maxlength="50"><br>
                <label> Constraseña:</label>
                <input type="password" name="password" required maxlength="50"><br>
                <button type="submit">Log in</button>
            </form>
        </div>
        <div id="mystyle" class="myform" title="Registro Usuarios">
            <form id="RegisterForm" class="myform" name="form" action = "registro" method = "post" onsubmit="return checkPassword(this.password.value)">
                <h1>Registro de usuario</h1>
                <p>Por favor, introduzca su información de registro<br><br>
                    <label> Nombre:</label>
                    <input type="text" name="nombre" required maxlength="50"><br>
                    <label> Apellidos:</label> 
                    <input type="text" name="apellidos" required maxlength="50"><br>
                    <label>Correo electrónico: </label>
                    <input type="email" name="correo" required maxlength="255"><br>
                    <label>Nombre usuario: </label>
                    <input type="text" name="nickName" required maxlength="50"><br>
                    <label>Contraseña:</label> 
                    <input type="password" name="password" required maxlength="50"><br>
                    <label>Repetir contraseña: </label>
                    <input type="password" required name="repassword" ><br>
                    <button type="submit">Registrar usuario</button>
            </form>
        </div>

        <script type="text/javascript">
            function checkPassword(str)
            {
                return true;
                var re = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])\w{6,}$/;
                if (!re.test(str)) {
                    alert("El password debe contener al menos 6 carácteres, una letra mayúscula, una minúscula y un número");
                    return false;
                }
            }

        </script>
    </body>
</html>
