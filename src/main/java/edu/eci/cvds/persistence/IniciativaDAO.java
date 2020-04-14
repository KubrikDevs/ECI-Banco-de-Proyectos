package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.exceptions.PersistenceException;


public interface IniciativaDAO {

    void insertarIniciativa(Iniciativa iniciativa) throws PersistenceException;

    public Iniciativa consultarIniciativa(Integer id) throws PersistenceException;



}
