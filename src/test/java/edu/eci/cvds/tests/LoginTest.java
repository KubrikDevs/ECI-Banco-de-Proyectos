
package edu.eci.cvds.tests;

import org.mybatis.guice.transactional.Transactional;

import edu.eci.cvds.services.*;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.authentication.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

@Transactional
public class LoginTest {

	private ServiciosBancoDeProyectos serviciosB;

	public LoginTest() throws ExcepcionBancoDeProyectos {
		serviciosB = ServiciosBancoFactory.getInstance().getServiciosBancoTesting();		 
	}

	/**
	* Comprueba que no se puede registrar un usuario de correo nulo
	*/
	@Test
	public void noDeberiaRegistrarUnUsuarioNulo() {
		Usuario user;
		try {
			user = new Usuario("admin2", null, "admin2", "admin");
			serviciosB.registrarUsuario(user);
			fail("Debe fallar porque el correo del usuario es nulo");
		} catch (ExcepcionBancoDeProyectos e) {
			assertTrue(true);
		}
	}

	/**
	* Comprueba que no se puede registrar dos veces un usuario igual
	*/
	@Test
	public void noSeberiaRegistrarUnUsuarioRepetido() {
		Usuario user1;
		Usuario user2;
		try {
			user1 = new Usuario("admin2", "admin2@gmail.com", "admin2", "prueba");
			serviciosB.registrarUsuario(user1);
			user2 = new Usuario("admin2", "admin2@gmail.com", "admin2", "admin");
			serviciosB.registrarUsuario(user2);
			fail("Debe fallar porque el usuario se esta intentando registrar un usuario ya existente");
		} catch (ExcepcionBancoDeProyectos e) {
			assertTrue(true);
		}		
	}

	@Test
	public void deberiaRegistrarUnUsuarioCorrectamente() throws ExcepcionBancoDeProyectos {
		Usuario user = new Usuario("test", "test@gmail.com", "test", "prueba");
		serviciosB.registrarUsuario(user);
		Usuario userPrueba = serviciosB.consultarUsuario("test@gmail.com");
		assertTrue (userPrueba !=null);

	}

	/**
	* Comprueba que no se puede consultar un correo vacio
	*/
	@Test
	public void noDeberiaConsultarCorreoVacio() {
		String correo = "";
		try {			
			serviciosB.consultarUsuario(correo);
			fail("Debe fallar porque el correo es nulo");
		} catch (ExcepcionBancoDeProyectos e) {
			assertTrue(true);
		}
	}
	
	
	/**
	 * Consulta un usuario existente y verificamos que no este vacio.
	 * @throws ExcepcionBancoDeProyectos
	 */
	
	@Test
	public void deberiaConsultarUnUsuario() throws ExcepcionBancoDeProyectos {

		Usuario userPrueba = serviciosB.consultarUsuario("admin@gmail.com");
		assertTrue (userPrueba !=null);
	}

	/**
	 * No consulta el usuario porque no existe en la base de datos
	 * @throws ExcepcionBancoDeProyectos
	 */
	
	@Test
	public void noDeberiaConsultarUnUsuario() throws ExcepcionBancoDeProyectos {
		
		assertTrue (serviciosB.consultarUsuario("random@random.org") == null);
	}

}