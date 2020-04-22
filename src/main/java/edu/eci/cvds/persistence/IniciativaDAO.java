package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

/**
 *
 */
public interface IniciativaDAO {

    /**
     * Crea una nueva inciativa
     * @param i Identificador de Iniciativa
     * @throws PersistenceException
     */
    @Transactional
    void insertarIniciativa(Iniciativa i) throws PersistenceException;

    /**
     * Actuliza una iniciativa
     * @param id Identificador de Iniciativa
     * @param estado Estado a modificar la iniciativa
     * @throws PersistenceException
     */
    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException;

    /**
     * Busqueda de inicitivas por su identificador
     * @param id Identificador de Iniciativa
     * @return Iniciativa
     * @throws PersistenceException
     */
    Iniciativa cargarIniciativa(int id) throws PersistenceException;

    /**
     * Busqueda de todas las inicitivas
     * @return  Listado de Iniciativa
     * @throws PersistenceException
     */
    List<Iniciativa> cargarIniciativas() throws PersistenceException;

    /**
     * Busqueda de todas las iniciativas por un tag en común
     * @param tag palabras o grupo a relacionar iniciativas
     * @return Listado de iniciativas
     * @throws PersistenceException
     */
    List<Iniciativa> cargarIniciativas(String tag) throws PersistenceException;

}