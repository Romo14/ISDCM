/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import service.RegistroUsuService;

@WebServlet(name = "registro", urlPatterns = {"/registro"})
public class RegistroUsuServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) {
        String nombre = request.getParameter("nombre");
        String apellidos = request.getParameter("apellidos");
        String nickname = request.getParameter("nickName");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");

        String message = "";

        if (password.equals(repassword)) {
            Usuario usuario = new Usuario(nombre, apellidos, correo, nickname, password);
            RegistroUsuService registerService = new RegistroUsuService();
            message = registerService.registrar(usuario);
        } else {
            message = "Las contraseñas no son iguales!";
        }
        try {
            request.setAttribute("message", message);
            request.getRequestDispatcher("registroRes.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(RegistroUsuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
