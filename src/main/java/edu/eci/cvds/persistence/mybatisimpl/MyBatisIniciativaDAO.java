package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public class MyBatisIniciativaDAO implements IniciativaDAO {
    @Inject
    private IniciativaMapper iniciativaMapper;

    @Override
    public void insertarIniciativa(Iniciativa i) throws PersistenceException {
        try{
            iniciativaMapper.registrarIniciativa(i);
        }catch (PersistenceException e){
            throw new PersistenceException("Error al registrar iniciativa: " +i.toString(), e);
        }
    }

    @Override
    public void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException {
        try{
            iniciativaMapper.modificarEstadoIniciativa(id, estado);
        }catch (PersistenceException e){
            throw new PersistenceException("Error al modificar iniciativa: " + id, e);
        }
    }

    @Override
    public Iniciativa cargarIniciativa(int id) throws PersistenceException {
        try{
            return  iniciativaMapper.consultarIniciativa(id);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar iniciativa: " +id, e);
        }
    }

    @Override
    public List<Iniciativa> cargarIniciativas() throws PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativas();
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar iniciativas i's", e);
        }
    }

    @Override
    public List<Iniciativa> consultarIniciativas(List<String> palabrasClaves) throws PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativas(palabrasClaves);
        } catch (PersistenceException e){
            throw new PersistenceException("Error al consultar iniciativas con palabra clave", e);
        }
    }

    @Override
    public List<Iniciativa> cargarIniciativas(String tag) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativasPorTag(tag);
        } catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas", e);
        }
    }

    @Override
    public List<Iniciativa> cargarIniciativas(Iniciativa i) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return iniciativaMapper.consultarIniciativasRelacionadas(i);
        }catch (PersistenceException e) {
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas", e);
        }
    }

    @Override
    public List<Estadistico> cargarEstadisticaPorAreas() throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return iniciativaMapper.consultarEstadisticasPorArea();
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al cargar estadisticas", e);
        }
    }
}
