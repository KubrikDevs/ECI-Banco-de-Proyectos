package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosUsuario;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.List;

import static edu.eci.cvds.entities.Rol.PUBLICO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@SuppressWarnings("deprecation")
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean {

    private static final long serialVersionUID = 3594009161252782831L;


    @Inject
    private ServiciosUsuario serviciosUsuario;

    private List<Usuario> usuarios;

    private Usuario usuario;

    private String correo;

    private String nombre;

    private String rol;
    
    private String mensaje = "Correcto";

    public Usuario getUsuario(){
        return this.usuario;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public String getCorreo(){
        return this.correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getNombre(){
        return  this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getRol() { return rol; }

    public void setRol(String rol) { this.rol = rol; }

    public List<Usuario> getUsuarios() throws Exception{
        try {
            return serviciosUsuario.buscarUsuarios();
        }catch (ExcepcionBancoDeProyectos e){
            throw e;
        }
    }

    public Usuario getUsuario(String correo) throws Exception{
        try{
            return serviciosUsuario.buscarUsuario(correo);
        } catch (ExcepcionBancoDeProyectos e){
            throw e;
        }

    }
    

    public void modificarUsuario(String correo, String rol) throws  Exception{
            Rol rolexample = Rol.valueOf(rol);
        try{
            serviciosUsuario.modificarUsuario(correo, rolexample);
        }catch (ExcepcionBancoDeProyectos e){
            this.mensaje = "error al modificar Usuario";
            throw e;
        }
    }
    
    public void mensaje(String user) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, this.mensaje, "Usuario "+user+ " actualizado"));
    }




}
