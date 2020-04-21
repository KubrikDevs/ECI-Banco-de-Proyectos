package edu.eci.cvds.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Iniciativa {

    private int id;
    private String nombre;
    private String area;
    private Usuario proponente;
    private String descripcion;
    private EstadoIniciativa estado;
    private Date fechaDeInicio;
    private Date fechaDeFin;
    private List<String> palabrasClave;
    private List<Usuario> votos;
    private List<Usuario> interesados;

    public Iniciativa(){}

    public Iniciativa(int id, String nombre, String area, Usuario proponente, String descripcion, EstadoIniciativa estado, Date fechaDeInicio){
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.proponente = proponente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeInicio;
        this.interesados = new ArrayList<>();
        this.votos = new ArrayList<>();
        this.palabrasClave = new ArrayList<>();

    }

    public Iniciativa(int id, String nombre, String area, Usuario proponente, String descripcion, EstadoIniciativa estado, Date fechaDeInicio, Date fechaDeFin, List<String> palabrasClave){
        this.id = id;
        this.nombre = nombre;
        this.area = area;
        this.proponente = proponente;
        this.descripcion = descripcion;
        this.estado = estado;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFin = fechaDeFin;
        this.palabrasClave = palabrasClave;
        this.interesados = new ArrayList<>();
        this.votos = new ArrayList<>();

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public EstadoIniciativa getEstado() {
        return estado;
    }

    public void setEstado(EstadoIniciativa estado) {
        this.estado = estado;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public Date getFechaDeFin() {
        return fechaDeFin;
    }

    public void setFechaDeFin(Date fechaDeFin) {
        this.fechaDeFin = fechaDeFin;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public List<Usuario> getVotos() {
        return votos;
    }

    public void setVotos(List<Usuario> votos) {
        this.votos = votos;
    }

    public List<Usuario> getInteresados() {
        return interesados;
    }

    public void setInteresados(List<Usuario> interesados) {
        this.interesados = interesados;
    }

    public Usuario getProponente() {
        return proponente;
    }

    public void setProponente(Usuario proponente) {
        this.proponente = proponente;
    }

    @Override
    public String toString() {
        return "Iniciativa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", area='" + area + '\'' +
                ", proponente=" + proponente.getCorreo()+
                ", descripcion='" + descripcion + '\'' +
                ", estado=" + estado.name() +
                ", fechaDeInicio=" + fechaDeInicio+
                ", fechaDeFin=" + fechaDeFin + +
                '}';
    }
}
