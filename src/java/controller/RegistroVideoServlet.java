/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Marc
 */

import java.io.IOException;
import model.Usuario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import model.Video;
import service.RegistroUsuService;
import service.RegistroVideoService;

@WebServlet(name = "registroVideo", urlPatterns = {"/registroVideo"})
public class RegistroVideoServlet  extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) {
        
        String id = request.getParameter("id");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String fechaCreacion = request.getParameter("fechaCreacion");
        String duracion = request.getParameter("duracion");
        String reproducciones = request.getParameter("reproducciones");
        String descripcion = request.getParameter("descripcion");
        String formato = request.getParameter("formato");

        String message = "";
        Video video = new Video(id, titulo, autor, fechaCreacion, duracion, reproducciones, descripcion, formato);
        RegistroVideoService registerService = new RegistroVideoService();
        message = registerService.registrar(video);
       
        request.setAttribute("message", message);
   
    }
    
    //També s'ha de fer un doGet per consultes de video
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) {
    }
    
}
