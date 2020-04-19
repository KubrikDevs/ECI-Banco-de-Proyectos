package edu.eci.cvds.services;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface ServiciosIniciativa {

    @Transactional
    void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos;

    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos;

    Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos;
}
