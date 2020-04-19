package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;


import java.util.List;

public interface IniciativaDAO {

    @Transactional
    void insertarIniciativa(Iniciativa i) throws PersistenceException;

    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException;

    Iniciativa cargarIniciativa(int id) throws PersistenceException;

    List<Iniciativa> cargarIniciativas() throws PersistenceException;

}
