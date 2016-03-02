/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.util.Map;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modelo.Usuario;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oriol Gasset
 */
public class servletRegistroUsu extends HttpServlet {
    public void doPost(HttpServletRequest request,
                    HttpServletResponse response){
        Map<String, String[]> parametros = request.getParameterMap();
        
        Boolean existe = Usuario.getUsuario(parametros.get("nickName")[0]);

        
    }

}
