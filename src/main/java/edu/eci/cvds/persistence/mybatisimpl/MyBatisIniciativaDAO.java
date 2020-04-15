package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.exceptions.PersistenceException;

import java.util.ArrayList;

public class MyBatisIniciativaDAO implements IniciativaDAO {
    @Inject
    private IniciativaMapper iniciativaMapper;

    @Override
    public void insertarIniciativa(Iniciativa iniciativa) throws PersistenceException {
        try {
            iniciativaMapper.insertarIniciativa(iniciativa);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error (P) al registrar iniciativa " + iniciativa.toString(), e);
        }
    }

    @Override
    public ArrayList<Iniciativa> consultarIniciativas() throws PersistenceException {
        return iniciativaMapper.buscarIniciativas();
    }

    @Override
    public void updateIniciativa(int id) throws PersistenceException {
        iniciativaMapper.updateIniciativa(id);
    }


    @Override
    public ArrayList<String> consultarPalabrasClaves() throws PersistenceException {
        return iniciativaMapper.consultarPalabrasClaves();
    }
}
