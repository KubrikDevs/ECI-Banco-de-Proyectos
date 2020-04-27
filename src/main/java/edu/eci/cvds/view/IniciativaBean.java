package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.util.List;

@SuppressWarnings("deprecation")
@ManagedBean(name = "iniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean {

    private static final long serialVersionUID = 3594009161252782831L;

    @Inject
    private ServiciosIniciativa serviciosIniciativa;


    private int id;
    private String nombre;
    private String area;
    private EstadoIniciativa estado;
    private String descripcion;
    private Date fechaDeInicio;
    private List<Iniciativa> iniciativas;


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

    public String getEstado() {
        return estado.name();
    }

    public void setEstado(String estado) {
        this.estado = EstadoIniciativa.valueOf(estado);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaDeInicio() {
        return fechaDeInicio;
    }

    public void setFechaDeInicio(Date fechaDeInicio) {
        this.fechaDeInicio = fechaDeInicio;
    }

    public List<Iniciativa> getIniciativas() throws Exception{
        try{
            return serviciosIniciativa.buscarIniciativas();
        }catch (ExcepcionBancoDeProyectos e){
            throw e;
        }

    }

    public void setIniciativas(List<Iniciativa> iniciativas) {
        this.iniciativas = iniciativas;
    }
}


