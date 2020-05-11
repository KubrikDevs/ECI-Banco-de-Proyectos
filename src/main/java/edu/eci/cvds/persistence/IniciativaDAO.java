package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import org.mybatis.guice.transactional.Transactional;


import java.util.List;

public interface IniciativaDAO {

    @Transactional
    void insertarIniciativa(Iniciativa i) throws PersistenceException;

    @Transactional
    void insertarVoto(int id, String correo) throws  PersistenceException;

    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException;

    void borrarVoto(int id, String correo) throws PersistenceException;

    int consultarSiPuedeVotar(int id, String correo) throws PersistenceException;

    int cagarNumeroDeVotos(int id) throws PersistenceException;

    Iniciativa cargarIniciativa(int id) throws PersistenceException;

    List<Iniciativa> cargarIniciativas() throws PersistenceException;

    List<Iniciativa> cargarIniciativasUsuario(String correo) throws PersistenceException;

    List<Iniciativa> consultarIniciativas(List<String> palabrasClaves) throws PersistenceException;

    List<Iniciativa> cargarIniciativas(String tag) throws PersistenceException;

    List<Iniciativa> cargarIniciativas(Iniciativa i)throws PersistenceException;

    List<Estadistico> cargarEstadisticasPorAreas()throws PersistenceException;

    List<Estadistico> cargarEstadisticasPorEstado() throws PersistenceException;


}
