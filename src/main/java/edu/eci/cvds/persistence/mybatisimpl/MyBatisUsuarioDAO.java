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
	public void insertarUsuario(Usuario usuario) throws PersistenceException {
		try {
			usuarioMapper.insertarUsuario(usuario);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al registrar el usuario " + usuario.toString(), e);
		}

	}

	@Override
	public Usuario consultarUsuario(String correo) throws PersistenceException {
		try {
			return usuarioMapper.consultarUsuario(correo);
		} catch (org.apache.ibatis.exceptions.PersistenceException e) {
			throw new PersistenceException("Error (P) al consultar el usuario: " + correo, e);
		}

	}


}
