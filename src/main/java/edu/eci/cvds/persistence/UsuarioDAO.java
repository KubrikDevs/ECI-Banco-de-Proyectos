package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface UsuarioDAO {

	/**
	 * Actulizar el Rol de un Usuario
	 * @param correo Identificador de un Usuario
	 * @param r Tipo de Rol
	 * @throws PersistenceException
	 */
	@Transactional
	void modificarUsuario(String correo, Rol r) throws PersistenceException;

	/**
	 * Busqueda de usuarios por su correo
	 * @param correo Identificador de un Usuario
	 * @return Usuario
	 * @throws PersistenceException
	 */
	Usuario cargarUsuario(String correo) throws PersistenceException;

	/**
	 * Busqueda de todos de los Usuarios
	 * @return Listado de usuarios
	 * @throws PersistenceException
	 */
	List<Usuario> cargarUsuarios() throws PersistenceException;


}