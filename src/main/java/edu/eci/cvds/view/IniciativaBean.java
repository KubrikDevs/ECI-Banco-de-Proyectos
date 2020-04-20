package edu.eci.cvds.view;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;
import static edu.eci.cvds.view.LoginBean.setErrorMessage;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

@SuppressWarnings("deprecation")
@ManagedBean(name = "IniciativaBean")
@SessionScoped
public class IniciativaBean extends BasePageBean {

    @Inject
    private ServiciosIniciativa serviciosIniciativa;
    
    
	public List<Iniciativa> consultarIniciativas() {
		List<Iniciativa> iniciativas = null;
		
		try {
			iniciativas = serviciosIniciativa.buscarIniciativas();
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
		return iniciativas;
	}
        
	public void registrarIniciativa(int id, String nombre, String area, Usuario proponente, String descripcion, EstadoIniciativa estado, java.sql.Date fechaDeInicio, java.sql.Date fechaDeFin, List<String> palabrasClave) { 
            Iniciativa iniciativa = new Iniciativa(id,nombre,area,proponente,descripcion,estado.ESPERA,fechaDeInicio,fechaDeFin,palabrasClave);
            try {
                    serviciosIniciativa.crearIniciativa(iniciativa);
            }catch (ExcepcionBancoDeProyectos e) {
                    setErrorMessage(e);
            }
	}
        
	public void actualizarEstadoIniciativa(int id, EstadoIniciativa estado) {
		try {
			switch(estado.name()) {
				case "ESPERA":{
					serviciosIniciativa.modificarIniciativa(id, EstadoIniciativa.ESPERA);
					break;
				} case "REVISION":{
					serviciosIniciativa.modificarIniciativa(id, EstadoIniciativa.REVISION);					
					break;
				} case "PROYECTO":{
					serviciosIniciativa.modificarIniciativa(id, EstadoIniciativa.PROYECTO);
					break;
				} case "SOLUCIONADO":{
					serviciosIniciativa.modificarIniciativa(id, EstadoIniciativa.SOLUCIONADO);
					break;
				}
			}                    			
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
	}
        
	public Iniciativa consultarIniciativa(int id) {
            Iniciativa iniciativa = null;
		try {
			iniciativa = serviciosIniciativa.buscarIniciativa(id);
		} catch (ExcepcionBancoDeProyectos e) {
			setErrorMessage(e);
		}
		return iniciativa;
	}        
}
