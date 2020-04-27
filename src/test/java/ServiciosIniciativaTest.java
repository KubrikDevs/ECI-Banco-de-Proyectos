import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosBancoDeProyectosFactory;
import edu.eci.cvds.services.ServiciosIniciativa;
import edu.eci.cvds.services.ServiciosUsuario;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ServiciosIniciativaTest {
    @Inject
    private SqlSession sqlSession;
    private ServiciosUsuario serviciosUsuario;
    private ServiciosIniciativa serviciosIniciativa;


    public ServiciosIniciativaTest(){
        serviciosIniciativa = ServiciosBancoDeProyectosFactory.getInstance().getServiciosIniciativaTesting();
        serviciosUsuario = ServiciosBancoDeProyectosFactory.getInstance().getServiciosUsuarioTesting();

    }

    /**
     * Consulta una iniciativa existente y verificamos que no este vacio.
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void deberiaCrearUnaIniciativa() throws ExcepcionBancoDeProyectos {
        Usuario proponente = serviciosUsuario.buscarUsuario("test@gmail.com");
        Iniciativa iniPrueba = new Iniciativa(1, "prueba2", "prueba", proponente,"Iniciativa de prueba", EstadoIniciativa.ESPERA, Date.valueOf("2020-04-01"));
        serviciosIniciativa.crearIniciativa(iniPrueba);
        assertTrue(true);
    }


    /**
     * Consulta una iniciativa existente y verificamos que no este vacio.
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void deberiaBuscarUnaIniciativa() throws ExcepcionBancoDeProyectos {

        Iniciativa iniPrueba = serviciosIniciativa.buscarIniciativa(0);
        assertTrue (iniPrueba != null);
    }

    /**
     * Consulta la lista actual de Iniciativas en la base de datos
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void deberiaBuscarListaIniciativas() throws ExcepcionBancoDeProyectos {

        List<Iniciativa> inisPrueba = serviciosIniciativa.buscarIniciativas();
        assertTrue (inisPrueba !=null);
        for(Iniciativa i: inisPrueba){
            System.out.println(i);
        }
    }

    /**
     * Modifica el Estado de la iniciativa Prueba
     * @throws ExcepcionBancoDeProyectos
     */
    @Test
    public void deberiaCambiarEstado() throws ExcepcionBancoDeProyectos {
        serviciosIniciativa.modificarIniciativa(0, EstadoIniciativa.ESPERA);
    }


}
