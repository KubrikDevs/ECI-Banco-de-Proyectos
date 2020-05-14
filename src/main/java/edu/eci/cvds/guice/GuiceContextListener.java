package edu.eci.cvds.guice;

import javax.servlet.ServletContext;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import edu.eci.cvds.services.ServiciosIniciativa;
import edu.eci.cvds.services.ServiciosUsuario;
import edu.eci.cvds.services.impl.ServiciosIniciativaImpl;
import edu.eci.cvds.services.impl.ServiciosUsuarioImpl;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.authentication.SessionLogger;
import edu.eci.cvds.authentication.ShiroSession;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;


public class GuiceContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(Injector.class.getName());
	}

	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			@Override
			protected void initialize() {
				install(JdbcHelper.PostgreSQL);
				setEnvironmentId("development");
				setClassPathResource("mybatis-config.xml");

				//Services
				bind(ServiciosUsuario.class).to(ServiciosUsuarioImpl.class);
				bind(ServiciosIniciativa.class).to(ServiciosIniciativaImpl.class);

				//Persistence
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(IniciativaDAO.class).to(MyBatisIniciativaDAO.class);
				bind(ComentarioDAO.class).to(MyBatisComentarioDAO.class);

				//Authentication
				bind(SessionLogger.class).to(ShiroSession.class);

			}
		});

		servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
	}
}

