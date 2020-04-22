package edu.eci.cvds.services;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface ServiciosUsuario {

    /**
     * Actualiza el tipo de Rol de una usuario
     *
     * @param correo Correo identificador de un usuario
     * @param r Tipo de Rol del usuario
     * @throws ExcepcionBancoDeProyectos
     */
    @Transactional
    void modificarUsuario(String correo, Rol r) throws ExcepcionBancoDeProyectos;

    /**
     * Busqueda de un usuario por su correo
     *
     * @param correo Correo identifcador de un usuario
     * @return Usuario
     * @throws ExcepcionBancoDeProyectos
     */
    Usuario buscarUsuario(String correo) throws  ExcepcionBancoDeProyectos;

    /**
     * Busqueda de todos los usuarios
     *
     * @return Listado de Usuarios
     * @throws ExcepcionBancoDeProyectos
     */
    List<Usuario> buscarUsuarios() throws  ExcepcionBancoDeProyectos;
}