package edu.eci.cvds.services;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;

import java.util.List;

public interface ServiciosUsuario {

    void modificarUsuario(String correo, Rol r) throws ExcepcionBancoDeProyectos;

    Usuario buscarUsuario(String correo) throws  ExcepcionBancoDeProyectos;

    List<Usuario> buscarUsuarios() throws  ExcepcionBancoDeProyectos;
}
