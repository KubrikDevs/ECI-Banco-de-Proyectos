package edu.eci.cvds.services;

import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;

import java.util.List;


public interface ServiciosBancoDeProyectos {

	public abstract void registrarUsuario(Usuario u) throws ExcepcionBancoDeProyectos;

	public abstract Usuario consultarUsuario(String correo) throws ExcepcionBancoDeProyectos;

	public abstract List<Usuario> consultarUsuarios() throws ExcepcionBancoDeProyectos;

	public abstract void updateUsuario(String correo,String rol) throws Exception;

	public abstract Iniciativa  consultarIniciativa(Integer id) throws ExcepcionBancoDeProyectos;

	public abstract  void registrarIniciativa(Iniciativa i) throws  ExcepcionBancoDeProyectos;

}
