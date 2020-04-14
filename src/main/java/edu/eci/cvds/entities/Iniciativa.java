package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.Date;

public class Iniciativa {
    private Integer id;
    private String nombre;
    private String estado;
    private Integer numVotos;
    private Usuario proponente;
    private String area;
    private Date fechaCreacion;
    private Date fechaFin;
    private String descripcion;

    public Iniciativa(Integer id, String nombre, String estado, Integer numVotos, Usuario proponente, String area, Date fechaCreacion, Date fechaFin, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.numVotos = numVotos;
        this.proponente = proponente;
        this.area = area;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNumVotos(Integer numVotos) {
        this.numVotos = numVotos;
    }

    public void setProponente(Usuario proponente) {
        this.proponente = proponente;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public Integer getNumVotos() {
        return numVotos;
    }

    public Usuario getProponente() {
        return proponente;
    }

    public String getArea() {
        return area;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    @Override
    public String toString() {
        return "Iniciativa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", numVotos=" + numVotos +
                ", proponente=" + proponente +
                ", area='" + area + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
