package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosUsuario;
import java.util.List;


/**
 *
 */
public class ServiciosUsuarioImpl implements ServiciosUsuario {

    @Inject
    UsuarioDAO usuarioDAO;

    /**
     * Actualiza el tipo de Rol de una usuario
     *
     * @param correo Correo identificador de un usuario
     * @param r Tipo de Rol del usuario
     * @throws ExcepcionBancoDeProyectos
     */
    @Override
    public void modificarUsuario(String correo, Rol r) throws ExcepcionBancoDeProyectos {
        try {
            usuarioDAO.modificarUsuario(correo,r);
        } catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Modificacion:"+e.getLocalizedMessage(), e);
        }


    }

    /**
     * Busqueda de un usuario por su correo
     *
     * @param correo Correo identifcador de un usuario
     * @return Usuario
     * @throws ExcepcionBancoDeProyectos
     */
    @Override
    public Usuario buscarUsuario(String correo) throws ExcepcionBancoDeProyectos {
        try{
            return usuarioDAO.cargarUsuario(correo);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }

    }

    /**
     * Busqueda de todos los usuarios
     *
     * @return Listado de Usuarios
     * @throws ExcepcionBancoDeProyectos
     */
    @Override
    public List<Usuario> buscarUsuarios() throws ExcepcionBancoDeProyectos {
        try {
            return usuarioDAO.cargarUsuarios();
        } catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }

    }
}