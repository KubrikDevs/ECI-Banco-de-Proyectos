package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import org.apache.ibatis.exceptions.PersistenceException;

public interface UsuarioDAO {
 	void insertarUsuario(Usuario usuario) throws PersistenceException;
        public Usuario consultarUsuario(String correo) throws PersistenceException;
    
}
