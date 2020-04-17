package edu.eci.cvds.services.impl;

import edu.eci.cvds.entities.Rol;
import edu.eci.cvds.entities.Usuario;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosUsuario;

import java.util.List;

public class ServiciosUsuarioSTUB implements ServiciosUsuario {
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
