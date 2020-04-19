package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.IniciativaMapper;
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
            throw new PersistenceException("Error al consultar iniciativas ", e);
        }
    }
}