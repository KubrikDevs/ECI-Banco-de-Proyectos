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

	@Override
	public void modificarUsuario(String correo, Rol r) throws PersistenceException {
		try {
			usuarioMapper.modificarRolUsuario(correo, r);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al modificar el usuario:" + correo, e);
		}

	}

	@Override
	public Usuario cargarUsuario(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(correo);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar el usuario: " + correo, e);
		}

	}
	@Override
	public List<Usuario> cargarUsuarios() throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuarios();
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error al consultar los usuarios", e);
		}

	}


}
