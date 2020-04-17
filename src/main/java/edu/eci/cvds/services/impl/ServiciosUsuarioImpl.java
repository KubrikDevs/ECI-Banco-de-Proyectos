package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.persistence.UsuarioDAO;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosUsuario;

import java.util.List;

public class ServiciosUsuarioImpl implements ServiciosUsuario {
    @Inject
    UsuarioDAO usuarioDAO;

    @Override
    public void modificarUsuario(String correo, Rol r) throws ExcepcionBancoDeProyectos {

    }

    @Override
    public Usuario buscarUsuario(String correo) throws ExcepcionBancoDeProyectos {
        return null;
    }

    @Override
    public List<Usuario> buscarUsuarios() throws ExcepcionBancoDeProyectos {
        return null;
    }
}
