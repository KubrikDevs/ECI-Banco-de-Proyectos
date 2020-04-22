package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;

import edu.eci.cvds.entities.Rol;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Usuario;
import org.mybatis.guice.transactional.Transactional;

/**
 *
 */
public interface UsuarioMapper {

	/**
	 * Busqueda de usuarios por su correo
	 *
	 * @param correo Correo identificador de usuario
	 * @return
	 */
	public Usuario consultarUsuario(@Param("correo") String correo);

	/**
	 * Busqueda de todos los usuarios
	 * @return Listado de todos los usuarios
	 */
	public List<Usuario> consultarUsuarios();

	/**
	 * Actuliza el rol de un usuario
	 * @param correo Correo itendificador del usuario
	 * @param r Tipo de Rol a actulizar
	 */
	@Transactional
	public void modificarRolUsuario(@Param("correo") String correo, @Param("rol") Rol r);

}