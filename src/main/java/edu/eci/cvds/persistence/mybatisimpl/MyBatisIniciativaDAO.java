package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.mybatisimpl.mappers.IniciativaMapper;
import edu.eci.cvds.persistence.mybatisimpl.mappers.UsuarioMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.exceptions.PersistenceException;

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
    public Iniciativa consultarIniciativa(Integer id) throws PersistenceException {
        try {
            return iniciativaMapper.consultarIniciativa(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error (P) al consultar iniciativa: " + id, e);
        }
    }
}
