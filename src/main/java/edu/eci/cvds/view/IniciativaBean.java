package edu.eci.cvds.view;

import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.Date;

@ManagedBean(name="IniciativaBean")

public class IniciativaBean extends BasePageBean {

    public void insertarIniciativa (Integer id, String nombre, String estado, Integer numVotos, Usuario proponente, String area, Date fechaCreacion, Date fechaFin,String descripcion) throws Exception {

        Iniciativa iniciativa = new Iniciativa(id, nombre, estado, numVotos,proponente,area,fechaCreacion,fechaFin,descripcion);
        FacesMessage msg;
        msg = new FacesMessage("Iniciativa Insertada Exitosamente");
        FacesContext.getCurrentInstance().addMessage(null, msg);

    }

}
