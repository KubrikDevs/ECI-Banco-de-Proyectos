package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;


public interface IniciativaDAO {

    public void insertarIniciativa(Iniciativa iniciativa) throws PersistenceException;

    public ArrayList<Iniciativa> consultarIniciativas() throws PersistenceException;

    public void updateIniciativa(int id) throws PersistenceException;

    public ArrayList<String> consultarPalabrasClaves() throws PersistenceException;


}
