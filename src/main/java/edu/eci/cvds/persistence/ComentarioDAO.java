package edu.eci.cvds.persistence;

import edu.eci.cvds.entities.Comentario;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface ComentarioDAO {

    @Transactional
    void insertarComentario(Comentario c, int idIniciativa) throws PersistenceException;

    List<Comentario> cargarComentarios(int idIniciativa) throws PersistenceException;
}
