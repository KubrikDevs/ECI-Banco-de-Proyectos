package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface IniciativaMapper {

    @Transactional
    void registrarIniciativa(Iniciativa i);

    @Transactional
    void modificarEstadoIniciativa(int id, EstadoIniciativa estado);

    Iniciativa consultarIniciativa(int id);

    List<Iniciativa> consultarIniciativas();

    List<Iniciativa> consultarIniciativasPorTag(String tag);

}
