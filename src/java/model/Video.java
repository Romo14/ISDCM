/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Marc
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIDEOS")
public class Video {
   
    @Id
    @Column(name = "ID")
    private String id;
    
    @Column(name = "TITULO")
    private String titulo;
    
    @Column(name = "AUTOR")
    private String autor;
    
    @Column(name = "FECHA_CREACION")
    private String fechaCreacion;
    
    @Column(name = "DURACION")
    private String duracion;
    
    @Column(name = "REPRODUCCIONES")
    private String reproducciones;
        
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FORMATO")
    private String formato;
    
    public Video() {
        
    }

    public Video(String id, String titulo, String autor, String fechaCreacion, String duracion, String reproducciones, String descripcion, String formato) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.duracion = duracion;
        this.reproducciones = reproducciones;
        this.descripcion = descripcion;
        this.formato = formato;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(String reproducciones) {
        this.reproducciones = reproducciones;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    
    
    
}
