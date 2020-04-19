package edu.eci.cvds.services;

import com.google.inject.Injector;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.impl.ServiciosBancoDeProyectosImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import java.util.Optional;

import static com.google.inject.Guice.createInjector;

public class ServiciosBancoFactory {

    private static ServiciosBancoFactory instance = new ServiciosBancoFactory();

    private static Optional<Injector> optInjector;

    private Injector myBatisInjector(String env, String pathResource) {
        return createInjector(new XMLMyBatisModule() {
            @Override
            protected void initialize() {
            	setEnvironmentId(env);
            	install(JdbcHelper.PostgreSQL);
            	setClassPathResource(pathResource);
                bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
                bind(ServiciosBancoDeProyectos.class).to(ServiciosBancoDeProyectosImpl.class);
            }
        });
    }

    private ServiciosBancoFactory(){
        optInjector = Optional.empty();
    }

    public ServiciosBancoDeProyectos getServiciosBanco(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosBancoDeProyectos.class);
    }


    public ServiciosBancoDeProyectos getServiciosBancoTesting(){
        if (!optInjector.isPresent()) {
            optInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }

        return optInjector.get().getInstance(ServiciosBancoDeProyectos.class);
    }


    public static ServiciosBancoFactory getInstance(){
        return instance;
    }

}