package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.annotations.Param;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

/**
 *
 */
public interface IniciativaMapper {

    /**
     * Inscribe una inicitiva
     * @param i Iniciatuva
     */
    @Transactional
    void registrarIniciativa(@Param("i") Iniciativa i);

    /**
     * Actualiza una inicitiva
     * @param id Identificador de un iniciativa
     * @param estado El tipo de estado a modificar
     */
    @Transactional
    void modificarEstadoIniciativa(@Param("id") int id, @Param("estado") EstadoIniciativa estado);

    /**
     * Busca una iniciativa por su identificador
     *
     * @param id identificador de una iniciativa
     * @return Iniciativa
     */
    Iniciativa consultarIniciativa(@Param("id") int id);

    /**
     * Busqueda de todas las inicitivas
     *
     * @return Listado de las Iniciativas
     */
    List<Iniciativa> consultarIniciativas();

    /**
     * Busqueda de todas las iniciativas
     *
     * @param tag Nombre de la relacion con otras iniciativas
     * @return Listado de Iniciativas
     */
    List<Iniciativa> consultarIniciativasPorTag(@Param("tag") String tag);

}