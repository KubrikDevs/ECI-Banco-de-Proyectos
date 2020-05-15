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
    void registrarInteresado(@Param("id") int id, @Param("correo") String correo);

    @Transactional
    void registrarVoto(@Param("id")int id, @Param("correo") String correo);

    @Transactional
    void registrarPalabraClave(@Param("id") int id, @Param("tag") String palabraClave);

    @Transactional
    void modificarEstadoIniciativa(@Param("id") int id, @Param("estado") EstadoIniciativa estado);

    @Transactional
    void  modificarIniciativa(@Param("i") Iniciativa i);

    Iniciativa consultarIniciativa(@Param("id") int id);

    List<Iniciativa> consultarIniciativas();

    List<Iniciativa> consultarIniciativasPorEstado(@Param("estado") EstadoIniciativa estadoIniciativa);

    List<Iniciativa> consultarIniciativasPorTag(@Param("tag") String tag);

    List<Iniciativa> consultarIniciativasRelacionadas(@Param("ini") Iniciativa i);

    List<Estadistico> consultarEstadisticasPorArea();

    int consultarNumeroDeVotos(@Param("id") int id);

    int puedeVotar(@Param("id")int id, @Param("correo") String correo);

    void eliminarVoto(@Param("id")int id, @Param("correo") String correo);

    List<Iniciativa> consultarIniciativasUsuario(@Param("correo") String correo);

    List<Estadistico> consultarEstadisticasPorEstado();

}
