package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.IniciativaMapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

/**
 *
 */
public class MyBatisIniciativaDAO implements IniciativaDAO {
    @Inject
    private IniciativaMapper iniciativaMapper;

    /**
     * Crea una nueva inciativa
     * @param i Identificador de Iniciativa
     * @throws PersistenceException
     */
    @Override
    public void insertarIniciativa(Iniciativa i) throws PersistenceException {
        try{
            iniciativaMapper.registrarIniciativa(i);
        }catch (PersistenceException e){
            throw new PersistenceException("Error al registrar iniciativa: " +i.toString(), e);
        }
    }

    /**
     * Actuliza una iniciativa
     * @param id Identificador de Iniciativa
     * @param estado Estado a modificar la iniciativa
     * @throws PersistenceException
     */
    @Override
    public void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException {
        try{
            iniciativaMapper.modificarEstadoIniciativa(id, estado);
        }catch (PersistenceException e){
            throw new PersistenceException("Error al modificar iniciativa: " + id, e);
        }
    }

    /**
     * Busqueda de inicitivas por su identificador
     * @param id Identificador de Iniciativa
     * @return
     * @throws PersistenceException
     */
    @Override
    public Iniciativa cargarIniciativa(int id) throws PersistenceException {
        try{
            return  iniciativaMapper.consultarIniciativa(id);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar iniciativa: " +id, e);
        }
    }

    /**
     * Busqueda de todas las inicitivas
     * @return Listado de Inicitiva
     * @throws PersistenceException
     */
    @Override
    public List<Iniciativa> cargarIniciativas() throws PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativas();
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar iniciativas ", e);
        }
    }

    /**
     * Busqueda de todas las iniciativas por un tag en común
     * @param tag palabras o grupo a relacionar iniciativas
     * @return
     * @throws edu.eci.cvds.persistence.PersistenceException
     */
    @Override
    public List<Iniciativa> cargarIniciativas(String tag) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativasPorTag(tag);
        } catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas", e);
        }
    }
}