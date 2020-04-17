package edu.eci.cvds.services;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;

import java.util.List;

public interface ServiciosIniciativa {

    void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos;

    void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos;

    Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos;
}
