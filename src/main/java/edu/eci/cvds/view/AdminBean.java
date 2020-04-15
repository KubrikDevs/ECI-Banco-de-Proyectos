package edu.eci.cvds.view;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ServiciosBancoDeProyectos;
import com.google.inject.Inject;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.eci.cvds.view.LoginBean.setErrorMessage;

public class AdminBean extends BasePageBean {

    private List<Usuario> listUsuarios = null;

    @Inject
    private ServiciosBancoDeProyectos serviciosBancoIniciativa;

    public List<Usuario> consultarUsuarios() {

        try {
            listUsuarios = serviciosBancoIniciativa.consultarUsuarios();
        } catch (Exception ex) {
            setErrorMessage(ex);
        }
        return listUsuarios;
    }


    public void updateUsuario(String correo, String rol) {

        try {
            serviciosBancoIniciativa.updateUsuario(correo,rol);
            FacesMessage msg;
            msg = new FacesMessage("Actualizado");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception ex) {
            setErrorMessage(ex);
        }
    }

}
