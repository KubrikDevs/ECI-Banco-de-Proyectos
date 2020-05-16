package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Comentario;
import org.apache.ibatis.annotations.Param;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface ComentarioMapper {

    @Transactional
    void registrarComentario(@Param("c") Comentario c, @Param("idIni") int idIniciativa);

    List<Comentario> consultarComentarios(@Param("idIni") int idIniciativa);
}
