package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import org.mybatis.guice.transactional.Transactional;


import java.util.List;

public interface IniciativaDAO {

    @Transactional
    void insertarIniciativa(Iniciativa i) throws PersistenceException;

    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException;

    Iniciativa cargarIniciativa(int id) throws PersistenceException;

    List<Iniciativa> cargarIniciativas() throws PersistenceException;

    List<Iniciativa> consultarIniciativas(List<String> palabrasClaves) throws PersistenceException;

    List<Iniciativa> cargarIniciativas(String tag) throws PersistenceException;

}
