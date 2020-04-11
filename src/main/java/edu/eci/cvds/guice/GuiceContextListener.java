package edu.eci.cvds.guice;

import javax.servlet.ServletContext;


import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.authentication.SessionLogger;
import edu.eci.cvds.authentication.ShiroSession;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.persistence.mybatisimpl.*;
import edu.eci.cvds.services.ServiciosBancoDeProyectos;
import edu.eci.cvds.services.impl.ServiciosBancoDeProyectosImpl;


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
				// TODO Add service class associated to Stub implementation
				bind(ServiciosBancoDeProyectos.class).to(ServiciosBancoDeProyectosImpl.class);
				bind(UsuarioDAO.class).to(MyBatisUsuarioDAO.class);
				bind(SessionLogger.class).to(ShiroSession.class);

			}
		});

		servletContextEvent.getServletContext().setAttribute(Injector.class.getName(), injector);
	}
}

