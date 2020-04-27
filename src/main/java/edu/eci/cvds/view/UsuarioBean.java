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

    private Rol rol;

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

    public Rol getRol() { return rol; }

    public void setRol(Rol rol) { this.rol = rol; }

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

    public void modificarUsuario(String correo, Rol rol) throws  Exception{
        try{
            serviciosUsuario.modificarUsuario(correo, rol);
        }catch (ExcepcionBancoDeProyectos e){
            throw e;
        }
    }




}
