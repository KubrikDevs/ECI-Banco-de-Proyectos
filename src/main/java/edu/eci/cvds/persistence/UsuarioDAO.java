package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface UsuarioDAO {

    @Transactional
 	void modificarUsuario(String correo, Rol r) throws PersistenceException;

    Usuario cargarUsuario(String correo) throws PersistenceException;

    List<Usuario> cargarUsuarios() throws PersistenceException;

    
}
