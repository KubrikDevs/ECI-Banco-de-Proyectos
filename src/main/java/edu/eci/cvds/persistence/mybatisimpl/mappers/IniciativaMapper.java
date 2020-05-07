package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
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

    List<Iniciativa> consultarIniciativas(@Param("palabrasClaves") List<String> palabrasClaves);


    List<Iniciativa> consultarIniciativasPorTag(@Param("tag") String tag);

    List<Iniciativa> consultarIniciativasRelacionadas(@Param("ini") Iniciativa i);

    List<Estadistico> consultarEstadisticasPorArea();
}
