package edu.eci.cvds.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Comentario;
import edu.eci.cvds.persistence.ComentarioDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.persistence.mybatisimpl.mappers.ComentarioMapper;

import java.util.List;

public class MyBatisComentarioDAO implements ComentarioDAO {
    @Inject
    ComentarioMapper comentarioMapper;

    @Override
    public void insertarComentario(Comentario c, int idIniciativa) throws PersistenceException {
        try{
            comentarioMapper.registrarComentario(c, idIniciativa);
        } catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error de registrando comentario", e);
        }

    }

    @Override
    public List<Comentario> cargarComentarios(int idIniciativa) throws PersistenceException {
        try{
            return comentarioMapper.consultarComentarios(idIniciativa);
        }catch (org.apache.ibatis.exceptions.PersistenceException e){
            throw new PersistenceException("Error consultando comentarios de la iniciativa:" + idIniciativa, e);
        }
    }
}
