/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import service.LoginUsuService;

/**
 *
 * @author Marc
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginUsuServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nickname = request.getParameter("nickName");
        String password = request.getParameter("password");

        String message = "";

        LoginUsuService loginService = new LoginUsuService();
        Boolean result = loginService.comprobar(nickname, password);
        if (!result) {
            message = "ERROR: No coinciden el usuario y contraseña";
            nickname = null;
        }
        if (result) {
            message = "Bienvenido " + nickname;
        }
        try {
            request.getSession().setAttribute("usuario", nickname);
            request.setAttribute("message", message);
            request.setAttribute("result", result);
            request.getRequestDispatcher("registroRes.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(LoginUsuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
