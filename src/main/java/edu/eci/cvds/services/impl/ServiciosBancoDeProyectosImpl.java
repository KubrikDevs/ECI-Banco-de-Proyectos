package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.*;
import edu.eci.cvds.services.*;
import edu.eci.cvds.persistence.*;
import edu.eci.cvds.services.ServiciosBancoDeProyectos;
import org.apache.ibatis.exceptions.PersistenceException;
import org.mybatis.guice.transactional.Transactional;

public class ServiciosBancoDeProyectosImpl implements ServiciosBancoDeProyectos {
    

	@Inject
	private UsuarioDAO usuarioDAO;


	// Usuarios

	@Override
	@Transactional
	public void registrarUsuario(Usuario usuario) throws ExcepcionBancoDeProyectos {
		if (usuario == null)
			throw new ExcepcionBancoDeProyectos("El correo no puede ser nulo");

		try {
			usuarioDAO.insertarUsuario(usuario);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al registrar el correo " + usuario.getCorreo(), e);
		}
	}

	@Override
	public Usuario consultarUsuario(String correo) throws ExcepcionBancoDeProyectos {
		if (correo == "")
			throw new ExcepcionBancoDeProyectos("El numero de documento es inválido");
		try {
			return usuarioDAO.consultarUsuario(correo);
		} catch (PersistenceException e) {
			throw new ExcepcionBancoDeProyectos("Error al consultar el usuario" + correo, e);
		}
	}
}
