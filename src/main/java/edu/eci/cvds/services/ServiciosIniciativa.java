package edu.eci.cvds.services;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

/**
 *
 */
public interface ServiciosIniciativa {

    /**
     * Realiza una nueva iniciativa
     * @param i Iniciativa a realizar
     * @throws ExcepcionBancoDeProyectos
     */
    @Transactional
    void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos;

    /**
     * Actualiza el estado de una iniciativa
     *
     * @param id Identificador de Iniciativa
     * @param estado Estado de una Iniciativa
     * @throws ExcepcionBancoDeProyectos
     */
    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos;

    /**
     * Busqueda de una Iniciativa por su ID
     *
     * @param id Identificador de Iniciativa
     * @return Inicitiva
     * @throws ExcepcionBancoDeProyectos
     */
    Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos;

    /**
     * Listado de todas las iniciativas
     *
     * @return Listado de Iniciativas
     * @throws ExcepcionBancoDeProyectos
     */
    List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos;

    /**
     * Listado de iniciativas que tenga un Tag en común
     *
     * @param tag Busqueda de Iniciativas relacionadas
     * @return Listado de Iniciativa
     * @throws ExcepcionBancoDeProyectos
     */
    List<Iniciativa> buscarIniciativasPorTag(String tag) throws  ExcepcionBancoDeProyectos;
}