package edu.eci.cvds.entities;

import java.sql.Date;

public class Comentario {

    private int id;
    private Usuario autor;
    private String contenido;
    private Date fechaCreacion;

    public Comentario(){ }

    public Comentario(int id, Usuario autor, String contenido, Date fechaCreacion) {
        this.id = id;
        this.autor = autor;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", autor=" + autor +
                ", contenido='" + contenido + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }
}
