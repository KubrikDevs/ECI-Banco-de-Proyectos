package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.annotations.Param;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface IniciativaMapper {

    @Transactional
    void registrarIniciativa(@Param("i") Iniciativa i);

    @Transactional
    void modificarEstadoIniciativa(@Param("id") int id, @Param("estado") EstadoIniciativa estado);

    Iniciativa consultarIniciativa(@Param("id") int id);

    List<Iniciativa> consultarIniciativas();

    List<Iniciativa> consultarIniciativasPorTag(String tag);

}
