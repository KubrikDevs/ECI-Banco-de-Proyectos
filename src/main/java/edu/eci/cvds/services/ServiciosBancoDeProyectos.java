package edu.eci.cvds.services;

import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.entities.Usuario;

import java.util.ArrayList;
import java.util.List;


public interface ServiciosBancoDeProyectos {

	//Usuario

	public abstract Usuario consultarUsuario(String correo) throws ExcepcionBancoDeProyectos;

	public abstract List<Usuario> consultarUsuarios() throws ExcepcionBancoDeProyectos;

	public abstract void updateUsuario(String correo,String rol) throws Exception;

	//Iniciativa

	public abstract ArrayList<Iniciativa> consultarIniciativas() throws ExcepcionBancoDeProyectos;

	public abstract void updateIniciativa(int id) throws ExcepcionBancoDeProyectos;

	public abstract  void registrarIniciativa(Iniciativa i) throws  ExcepcionBancoDeProyectos;

	public abstract  void consultarPalabrasClaves() throws ExcepcionBancoDeProyectos;

	}
