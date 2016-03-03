/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIOS")
public class Usuario {

    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "APELLIDOS")
    private String apellidos;
    
    @Column(name = "CORREO")
    private String correo;
    
    @Id
    @Column(name = "NICKNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;

    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String correo, String username, String password) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.username = username;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Boolean getUsuario(String nickName) {
        Connection connection = null;
        Boolean result = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ISDCM;user=isdcm;password=isdcm");
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            ResultSet u = statement.executeQuery("select * from USUARIOS");
            
            result = u.next();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return result;

    }

}
