package edu.eci.cvds.services;

import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public interface ServiciosIniciativa {

    @Transactional
    void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos;

    @Transactional
    void registrarVoto(int id, String correo) throws ExcepcionBancoDeProyectos;

    @Transactional
    void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos;

    void cancelarVoto(int id, String correo) throws ExcepcionBancoDeProyectos;

    int buscarNumeroDeVotos(int id) throws ExcepcionBancoDeProyectos;

    boolean consultarSiPuedeVotar(int id, String correo) throws ExcepcionBancoDeProyectos;

    Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativasUsuario(String correo) throws ExcepcionBancoDeProyectos;

    List<Iniciativa> consultarIniciativas(List<String> palabrasClaves) throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativasPorTag(String tag) throws  ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativas(Iniciativa i) throws ExcepcionBancoDeProyectos;

    List<Estadistico> buscarEstadisticasPorArea() throws ExcepcionBancoDeProyectos;

    List<Estadistico> buscarEstadisticasPorEstado() throws ExcepcionBancoDeProyectos;

    List<Iniciativa> buscarIniciativas(EstadoIniciativa estado) throws  ExcepcionBancoDeProyectos;
}
