package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface UsuarioDAO {
 	void insertarUsuario(Usuario usuario) throws PersistenceException;
 	public Usuario consultarUsuario(String correo) throws PersistenceException;
 	public List<Usuario> consultarUsuarios() throws PersistenceException;
	public void updateUsuario(String correo, String rol) throws Exception;
    
}
