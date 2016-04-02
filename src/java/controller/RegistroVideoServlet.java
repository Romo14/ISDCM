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
import java.util.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import model.Video;
import service.RegistroVideoService;

@WebServlet(name = "registroVideo", urlPatterns = {"/registroVideo"})
public class RegistroVideoServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response) {

        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String fechaCreacionString = request.getParameter("fechaCreacion");
        String duracionString = request.getParameter("duracion");
        String descripcion = request.getParameter("descripcion");
        String formato = request.getParameter("formato");

        String message = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date fechaCreacion = null;
        SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");
        long ms = 0;
        try {
            ms = tdf.parse(duracionString).getTime();
            fechaCreacion = (Date) df.parse(fechaCreacionString);
        } catch (ParseException ex) {
            Logger.getLogger(RegistroVideoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        java.sql.Date fechaCreacionSql = new java.sql.Date(fechaCreacion.getTime());
        Time duracion = new Time(ms);
        Video video = new Video(titulo, autor, fechaCreacionSql, duracion, (long) 0, descripcion, formato);
        RegistroVideoService registerService = new RegistroVideoService();
        message = registerService.registrar(video);

        
        try {
            request.setAttribute("message", message);
            request.getRequestDispatcher("videoManagement.jsp").forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(RegistroUsuServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //També s'ha de fer un doGet per consultes de video
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response) {
    }

}
