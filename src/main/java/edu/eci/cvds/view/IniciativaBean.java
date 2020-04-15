package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;


import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name="IniciativaBean")


public class IniciativaBean extends BasePageBean {


    private Iniciativa iniciativa;

    public void insertarIniciativa (Integer id, String nombre, EstadoIniciativa estado, ArrayList<Usuario> votos, ArrayList<String> palabrasClave, ArrayList<Usuario> interesados, Usuario proponente, String area, Date fechaCreacion, Date fechaFin, String descripcion, ArrayList<Usuario> integrantesDelProyecto) throws Exception {
        Iniciativa iniciativa = new Iniciativa(id, nombre, estado, votos, palabrasClave, interesados,proponente, area, fechaCreacion, fechaFin, descripcion,integrantesDelProyecto);
        FacesMessage msg;
        msg = new FacesMessage("Iniciativa Insertada Exitosamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

    public void setIniciativa(Iniciativa iniciativa) {
        this.iniciativa = iniciativa;
    }

}
