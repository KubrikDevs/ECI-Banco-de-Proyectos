package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.List;

public interface IniciativaDAO {

    void insertarIniciativa(Iniciativa i) throws PersistenceException;

    void modificarIniciativa(int id, EstadoIniciativa estado) throws PersistenceException;

    Iniciativa cargarIniciativa(int id) throws PersistenceException;

    List<Iniciativa> cargarIniciativas() throws PersistenceException;

}
