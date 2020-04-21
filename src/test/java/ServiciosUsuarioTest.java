import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosBancoDeProyectosFactory;
import edu.eci.cvds.services.ServiciosUsuario;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ServiciosUsuarioTest {
    @Inject
    private SqlSession sqlSession;

    private ServiciosUsuario serviciosUsuario;


    public ServiciosUsuarioTest(){
        serviciosUsuario = ServiciosBancoDeProyectosFactory.getInstance().getServiciosUsuarioTesting();
    }


    /**
     * Consulta un usuario existente y verificamos que no este vacio.
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void deberiaBuscarUnUsuario() throws ExcepcionBancoDeProyectos {

        Usuario userPrueba = serviciosUsuario.buscarUsuario("admin@gmail.com");
        assertTrue (userPrueba !=null);
    }

    /**
     * Consulta la lista actual de usuarios en la base de datos
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void deberiaBuscarListaUsuarios() throws ExcepcionBancoDeProyectos {

        List<Usuario> usersPrueba = serviciosUsuario.buscarUsuarios();
        assertTrue (usersPrueba !=null);
    }

    /**
     * No consulta el usuario porque no existe en la base de datos
     * @throws ExcepcionBancoDeProyectos
     */

    @Test
    public void noDeberiaConsultarUnUsuario() throws ExcepcionBancoDeProyectos {

        assertTrue (serviciosUsuario.buscarUsuario("random@random.org") == null);
    }

    /**
     * Modifica el Rol del usuario test
     * @throws ExcepcionBancoDeProyectos
     */
    @Test
    public void deberiaCambiarRol() throws ExcepcionBancoDeProyectos {
        serviciosUsuario.modificarUsuario("test@gmail.com", Rol.PROPONENTE);
        Assert.assertEquals(serviciosUsuario.buscarUsuario("test@gmail.com").getRol(), Rol.PROPONENTE);
    }
}
