package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import static org.joda.time.format.ISODateTimeFormat.date;

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
    private Iniciativa iniciativa;
    private final String estadoInicial = "ESPERA";
    private EstadoIniciativa estado;
    private String descripcion;
    private Date fechaDeInicio;
    private List<Iniciativa> iniciativas;
    private String mensaje = "Correcto";
    private String operacion = "Correcto";
    //private ArrayList<String> palabrasClaveConsultar= new ArrayList<String>();
    //private List<Iniciativa> iniciativasConClave= new ArrayList<Iniciativa>();

    public Iniciativa getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
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
    
    
    public LocalDate getFecha() {
        LocalDate localDate = LocalDate.now();
        return localDate;
    }
    
    public void registrarIniciativa(String nombre,String area,Usuario proponente,String descripcion, LocalDate fechaDeInicio) throws  Exception{
        this.iniciativas = serviciosIniciativa.buscarIniciativas();
        int idIniciativa =  (iniciativas.size());
        Date fechaInicio = Date.valueOf(fechaDeInicio);
        EstadoIniciativa estadoI = EstadoIniciativa.valueOf(estadoInicial);
        List<String> pruebaPC = new ArrayList<String>();
        pruebaPC.add("pruebaPalabraClave");
        System.out.println(pruebaPC);
        Iniciativa iniciativa = new Iniciativa(idIniciativa,nombre,area,proponente,descripcion,estadoI,fechaInicio, pruebaPC);
        try{
            serviciosIniciativa.crearIniciativa(iniciativa);
            this.operacion = "registrada";
        }catch (ExcepcionBancoDeProyectos e){
            this.mensaje = "Error al registrar iniciativa";
            this.operacion = "error";
            throw e;
        }
    }
    
    
    public void mensaje(String iniciativa) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, this.mensaje, "Iniciativa "+iniciativa+ " " + this.operacion));
    }
    
    
    public void modificarIniciativa(int id, String estadoIniciativa) throws  Exception{
            EstadoIniciativa estadoI = EstadoIniciativa.valueOf(estadoIniciativa);
        try{
            serviciosIniciativa.modificarIniciativa(id, estadoI);
            this.operacion = "modificada";
        }catch (ExcepcionBancoDeProyectos e){
            this.mensaje = "Error al modificar Iniciativa";
            this.operacion = "error";
            throw e;
        }
    }

    public List<Iniciativa> consultarIniciativas(List<String> palabrasClaves) throws ExcepcionBancoDeProyectos{
        List<Iniciativa> todasLasIniciativas = serviciosIniciativa.buscarIniciativas();
        List<Iniciativa> iniciativasConPalClaves = new ArrayList<Iniciativa>();

        for(Iniciativa i: todasLasIniciativas) {

            for (String s : palabrasClaves) {
                if (i.getPalabrasClave().contains(s) && !iniciativasConPalClaves.contains(i)) {
                    iniciativasConPalClaves.add(i);
                }
            }
        }
        return iniciativasConPalClaves;
    }



}


