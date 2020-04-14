package edu.eci.cvds.entities;

import java.util.ArrayList;
import java.util.Date;

public class Iniciativa {
    private Integer id;
    private String nombre;
    private EstadoIniciativa estado;
    private ArrayList<Usuario> votos;
    private ArrayList<String> palabrasClave;
    private ArrayList<Usuario> interesados;
    private Usuario proponente;
    private String area;
    private Date fechaCreacion;
    private Date fechaFin;
    private String descripcion;
    private ArrayList<Usuario> integrantesDelProyecto;

    public Iniciativa(Integer id, String nombre, EstadoIniciativa estado, ArrayList<Usuario> votos,ArrayList<String> palabrasClave, ArrayList<Usuario> interesados,Usuario proponente, String area, Date fechaCreacion, Date fechaFin, String descripcion,ArrayList<Usuario> integrantesDelProyecto) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.votos = votos;
        this.palabrasClave = palabrasClave;
        this.interesados = interesados;
        this.proponente = proponente;
        this.area = area;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.integrantesDelProyecto = integrantesDelProyecto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstado(EstadoIniciativa estado) {
        this.estado = estado;
    }

    public void setNumVotos(Integer numVotos) {
        this.votos = votos;
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

    public ArrayList<Usuario> getVotos() {
        return votos;
    }

    public void setVotos(ArrayList<Usuario> votos) {
        this.votos = votos;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public ArrayList<Usuario> getInteresados() {
        return interesados;
    }

    public void setInteresados(ArrayList<Usuario> interesados) {
        this.interesados = interesados;
    }

    public ArrayList<Usuario> getIntegrantesDelProyecto() {
        return integrantesDelProyecto;
    }

    public void setIntegrantesDelProyecto(ArrayList<Usuario> integrantesDelProyecto) {
        this.integrantesDelProyecto = integrantesDelProyecto;
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

    public EstadoIniciativa getEstado() {
        return estado;
    }

    public ArrayList<Usuario> getNumVotos() {
        return votos;
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
                ", numVotos=" + votos +
                ", proponente=" + proponente +
                ", area='" + area + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
