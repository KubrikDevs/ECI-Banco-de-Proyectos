package edu.eci.cvds.services;

import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.MyBatisUsuarioDAO;
import edu.eci.cvds.services.impl.ServiciosUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosUsuarioFactory {

    private static  ServiciosUsuarioFactory instance = new ServiciosUsuarioFactory();

    private static Optional<Injector> optionalInjector;

    private Injector myBatisInjector(String env, String pathResource){
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
                setEnvironmentId(env);
                install(JdbcHelper.PostgreSQL);
                setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
            }
        });
    }

    private ServiciosUsuarioFactory(){
        optionalInjector = Optional.empty();
    }

    public ServiciosUsuario getServiciosUsuario(){
        if (!optionalInjector.isPresent()) {
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optionalInjector.get().getInstance(ServiciosUsuario.class);
    }

    public ServiciosUsuario getServiciosUsuarioTesting(){
        if (!optionalInjector.isPresent()) {
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config-h2.xml"));
        }

        return optionalInjector.get().getInstance(ServiciosUsuario.class);
    }


    public static ServiciosUsuarioFactory getInstance(){
        return instance;
    }
}
