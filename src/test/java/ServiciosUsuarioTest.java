import com.google.inject.Inject;
import edu.eci.cvds.services.ServiciosBancoDeProyectosFactory;
import edu.eci.cvds.services.ServiciosUsuario;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosUsuarioTest {
    @Inject
    private SqlSession sqlSession;

    private ServiciosUsuario serviciosUsuario;

    public ServiciosUsuarioTest(){
        serviciosUsuario = ServiciosBancoDeProyectosFactory.getInstance().getServiciosUsuarioTesting();
    }
}
