package edu.eci.cvds.persistence.mybatisimpl.mappers;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.entities.Usuario;

public interface UsuarioMapper {

	public void insertarUsuario(@Param("usuario") Usuario usuario);

	public Usuario consultarUsuario(@Param("correo") String correo);

	public List<Usuario> consultarUsuarios();

	public void updateUsuario(@Param("correo") String correo, @Param("rol") String rol);

}
