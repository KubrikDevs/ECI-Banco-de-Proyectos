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
    public void insertarIniciativa(Iniciativa i) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            iniciativaMapper.registrarIniciativa(i);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al registrar iniciativa: " +i.toString(), e);
        }
    }

    @Override
    public void modificarIniciativa(int id, EstadoIniciativa estado) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            iniciativaMapper.modificarEstadoIniciativa(id, estado);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al modificar iniciativa: " + id, e);
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
    public List<Iniciativa> cargarIniciativas() throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativas();
        } catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas i's", e);
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
    public List<Estadistico> cargarEstadisticasPorAreas() throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return iniciativaMapper.consultarEstadisticasPorArea();
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al cargar estadisticas", e);
        }
    }

    @Override
    public void insertarVoto(int id, String correo) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            iniciativaMapper.registrarVoto(id, correo);
        } catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al registrar voto", e);
        }
    }

    @Override
    public void borrarVoto(int id, String correo) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            iniciativaMapper.eliminarVoto(id, correo);
        } catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al borrar voto", e);
        }
    }

    @Override
    public int consultarSiPuedeVotar(int id, String correo) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.puedeVotar(id, correo);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar posibilidad de voto", e);
        }
    }

    @Override
    public int cagarNumeroDeVotos(int id) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.consultarNumeroDeVotos(id);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar numero de votos de la iniciativa" + id, e);
        }
    }

    @Override
    public List<Iniciativa> cargarIniciativasUsuario(String correo) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            return iniciativaMapper.consultarIniciativasUsuario(correo);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas del usuario "+correo, e);
        }
    }

    @Override
    public List<Estadistico> cargarEstadisticasPorEstado() throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return iniciativaMapper.consultarEstadisticasPorEstado();
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al cargar estadisticas", e);
        }
    }

    @Override
    public List<Iniciativa> cargarIniciativas(EstadoIniciativa estado) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            return iniciativaMapper.consultarIniciativasPorEstado(estado);
        }catch (PersistenceException e) {
            throw new edu.eci.cvds.persistence.PersistenceException("Error al consultar iniciativas", e);
        }
    }

    @Override
    public void insertarInteresado(int id, String correo) throws edu.eci.cvds.persistence.PersistenceException {
        try{
            iniciativaMapper.registrarInteresado(id, correo);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al registrar interesado", e);
        }
    }

    @Override
    public void insertarPalabraClave(int id, String palabraClave) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            iniciativaMapper.registrarPalabraClave(id, palabraClave);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al registrar palabra clave", e);
        }
    }

    @Override
    public void modificarIniciativa(Iniciativa i) throws edu.eci.cvds.persistence.PersistenceException {
        try {
            iniciativaMapper.modificarIniciativa(i);
        }catch (PersistenceException e){
            throw new edu.eci.cvds.persistence.PersistenceException("Error al modificar iniciativa", e);
        }
    }
}
