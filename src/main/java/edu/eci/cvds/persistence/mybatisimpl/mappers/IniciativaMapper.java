package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;

import java.util.List;

public interface IniciativaMapper {

    void registrarIniciativa(Iniciativa i);

    void modificarEstadoIniciativa(int id, EstadoIniciativa estado);

    Iniciativa consultarIniciativa(int id);

    List<Iniciativa> consultarIniciativas();

    List<Iniciativa> consultarIniciativasPorTag(String tag);

}
