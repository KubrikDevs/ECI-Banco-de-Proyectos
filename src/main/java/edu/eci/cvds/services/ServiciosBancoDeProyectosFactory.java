package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisIniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.impl.ServiciosIniciativaImpl;
import edu.eci.cvds.services.impl.ServiciosUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

/**
 *
 */
public class ServiciosBancoDeProyectosFactory {

    private static ServiciosBancoDeProyectosFactory instance = new ServiciosBancoDeProyectosFactory();

    private static Optional<Injector> optInjector;

    /**
     * Relacion My Batis
     *
     * @param env
     * @param pathResource
     * @return
     */
    private Injector myBatisInjector(String env, String pathResource) {

        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
                bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
                bind(ServiciosIniciativa.class).to(ServiciosIniciativaImpl.class);
            }
        });
    }

    private ServiciosBancoDeProyectosFactory(){
        optInjector = Optional.empty();
    }

    /**
     * Enlace con los mapper
     * @return
     */
    public ServiciosIniciativa getServiciosIniciativa(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosIniciativa.class);
    }


    public ServiciosIniciativa getServiciosIniciativaTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosIniciativa.class);
    }

    /**
     * Test
     * @return
     */
    public ServiciosUsuario getServiciosUsuario(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosUsuario.class);
    }

    /**
     * Test
     * @return
     */
    public ServiciosUsuario getServiciosUsuarioTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("test","mybatis-config-h2.xml"));
        }

        return optInjector.get().getInstance(ServiciosUsuario.class);
    }

    public static ServiciosBancoDeProyectosFactory getInstance(){
        return instance;
    }
}