package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosUsuario;
import static edu.eci.cvds.view.LoginBean.setErrorMessage;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name = "UsuarioBean")
@SessionScoped
public class UsuarioBean extends BasePageBean {

    
    @Inject
    private ServiciosUsuario serviciosUsuario;
    
	public Usuario consultarUsuario(String correo) {
		Usuario usuario = null;
		try {
			usuario = serviciosUsuario.buscarUsuario(correo);
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
		return usuario; 
	}
        
	public List<Usuario> consultarUsuarios() {
		List<Usuario> usuarios = null;
		try {
			usuarios = serviciosUsuario.buscarUsuarios();
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
		return usuarios;
	}
        
	public void actualizarRolUsuario(String correo, String rol) {
		try {
			switch(rol) {
				case "ADMINISTRADOR":{
					serviciosUsuario.modificarUsuario(correo,Rol.ADMINISTRADOR); 
					break;
				} case "PERSONAL_PMO":{
					serviciosUsuario.modificarUsuario(correo,Rol.PERSONAL_PMO); 					
					break;
				} case "PROPONENTE":{
					serviciosUsuario.modificarUsuario(correo,Rol.PROPONENTE); 
					break;
				} case "PUBLICO":{
					serviciosUsuario.modificarUsuario(correo,Rol.PUBLICO); 
					break;
				}
                        }
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
	}   
}
