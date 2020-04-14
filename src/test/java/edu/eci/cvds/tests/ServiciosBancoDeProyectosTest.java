package edu.eci.cvds.tests;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.*;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBancoDeProyectos;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;
import edu.eci.cvds.services.impl.ServiciosBancoDeProyectosImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiciosBancoDeProyectosTest {	
	

	@Before
	public void setUp() {
				
	}

	@Test(expected = ExcepcionBancoDeProyectos.class)
	public void excepcionRegistroPorCorreoNulo() throws ExcepcionBancoDeProyectos {
		ServiciosBancoDeProyectosImpl sistema = new ServiciosBancoDeProyectosImpl();
		Usuario user = null;
		sistema.registrarUsuario(user);
	}

	@Test(expected = ExcepcionBancoDeProyectos.class)
	public void excepcionConsultaCorreoInvalido() throws ExcepcionBancoDeProyectos {
		ServiciosBancoDeProyectosImpl sistema = new ServiciosBancoDeProyectosImpl();
		String correo = "";
		sistema.consultarUsuario(correo);
		
        }

	@Test(expected = NullPointerException.class)
	public void excepcionResgistroUsuarioNoEstaEnBaseDeDatos() throws ExcepcionBancoDeProyectos {
		ServiciosBancoDeProyectosImpl sistema = new ServiciosBancoDeProyectosImpl();
		Usuario user1 = new Usuario();		
		sistema.registrarUsuario(user1);			
	}

	@Test(expected = NullPointerException.class)
	public void excepcionConsultaUsuarioInexistente() throws ExcepcionBancoDeProyectos {
		ServiciosBancoDeProyectosImpl sistema = new ServiciosBancoDeProyectosImpl();
		String random = "correo";				
		sistema.consultarUsuario(random);			
	}
}
