package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import java.util.List;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.*;
import edu.eci.cvds.entities.*;
import java.util.Date;
import org.apache.ibatis.exceptions.PersistenceException;

public class MyBatisUsuarioDAO implements UsuarioDAO {

	@Inject
	private UsuarioMapper usuarioMapper;

	/**
	 * Actulizar el Rol de un Usuario
	 * @param correo Identificador de un Usuario
	 * @param r Tipo de Rol
	 * @throws PersistenceException
	 */
	@Override
	public void modificarUsuario(String correo, Rol r) throws PersistenceException {
		try {
			usuarioMapper.modificarRolUsuario(correo, r);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al modificar el usuario:" + correo, e);
		}

	}

	/**
	 * Busqueda de usuarios por su correo
	 * @param correo Identificador de un Usuario
	 * @return
	 * @throws PersistenceException
	 */
	@Override
	public Usuario cargarUsuario(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(correo);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el usuario: " + correo, e);
		}

	}

	/**
	 * Busqueda de todos de los Usuarios
	 * @return Listado de usuarios
	 * @throws PersistenceException
	 */
	@Override
	public List<Usuario> cargarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar los usuarios", e);
		}

	}


}