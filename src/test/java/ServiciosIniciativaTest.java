import com.google.inject.Inject;
import edu.eci.cvds.services.ServiciosBancoDeProyectosFactory;
import edu.eci.cvds.services.ServiciosIniciativa;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosIniciativaTest {
    @Inject
    private SqlSession sqlSession;

    private ServiciosIniciativa serviciosIniciativa;

    public ServiciosIniciativaTest(){
        serviciosIniciativa = ServiciosBancoDeProyectosFactory.getInstance().getServiciosIniciativaTesting();
    }

    @Before
    public void setUp() throws Exception {
    }


}
