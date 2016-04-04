/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Video;
import service.GestionVideoService;

/**
 *
 * @author Oriol-Sony Vaio
 */
@WebServlet(name = "buscarVideo", urlPatterns = {"/buscarVideo"})
public class BuscarVideoServlet extends HttpServlet {

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
        String titulo = request.getParameter("tituloBusqueda");
        String autor = request.getParameter("autorBusqueda");
        String fechaCreacionString = request.getParameter("fechaCreacionBusqueda");
        String duracionString = request.getParameter("duracionBusqueda");
        String descripcion = request.getParameter("descripcionBusqueda");
        String formato = request.getParameter("formatoBusqueda");

        java.util.Date fechaCreacion = null;
        java.sql.Date fechaCreacionSql = null;
        if (fechaCreacionString != null) {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

            try {
                fechaCreacion = (Date) df.parse(fechaCreacionString);
            } catch (ParseException ex) {
                Logger.getLogger(BuscarVideoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            fechaCreacionSql = new java.sql.Date(fechaCreacion.getTime());
        }
        long ms = 0;
        Time duracion = null;
        if (duracionString != null && !duracionString.equals("")) {
            SimpleDateFormat tdf = new SimpleDateFormat("hh:mm:ss");

            try {
                ms = tdf.parse(duracionString).getTime();

            } catch (ParseException ex) {
                Logger.getLogger(RegistroVideoServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            duracion = new Time(ms);
        }

        Video video = new Video(titulo, autor, fechaCreacionSql, duracion, (long) 0, descripcion, formato);
        GestionVideoService gestionVideoService = new GestionVideoService();
        List<Video> videos = gestionVideoService.buscar(video);
        request.setAttribute("videos", videos);
        request.setAttribute("table", "mostrar");
        storeInRequest(request, "tituloBusqueda");
        storeInRequest(request, "autorBusqueda");
        storeInRequest(request, "fechaCreacionBusqueda");
        storeInRequest(request, "duracionBusqueda");
        storeInRequest(request, "descripcionBusqueda");
        storeInRequest(request, "formatoBusqueda");
        request.getRequestDispatcher("videoManagement.jsp").forward(request, response);
    }

    private void storeInRequest(HttpServletRequest request, String param) {
        String val = request.getParameter(param);
        if (param != null && !param.isEmpty()) {
            System.out.println(val);
            request.setAttribute(param, val);
        }
    }
}
