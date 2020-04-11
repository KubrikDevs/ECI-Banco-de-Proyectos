package edu.eci.cvds.services;

import edu.eci.cvds.entities.Usuario;

public interface ServiciosBancoDeProyectos {
    	public abstract void registrarUsuario(Usuario u) throws ExcepcionBancoDeProyectos;

	public abstract Usuario consultarUsuario(String correo) throws ExcepcionBancoDeProyectos;
}
