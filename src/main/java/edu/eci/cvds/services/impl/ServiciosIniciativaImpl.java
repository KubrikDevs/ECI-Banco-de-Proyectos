package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.Comentario;
import edu.eci.cvds.entities.Estadistico;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.ComentarioDAO;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ServiciosIniciativaImpl implements ServiciosIniciativa {
    @Inject
    IniciativaDAO iniciativaDAO;

    @Inject
    ComentarioDAO comentarioDAO;

    @Override
    public void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos {
        try{
            iniciativaDAO.insertarIniciativa(i);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Registro:"+e.getLocalizedMessage(), e);
        }

    }

    @Override
    public void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos {
        try{
            iniciativaDAO.modificarIniciativa(id, estado);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Modificacion:"+e.getLocalizedMessage(), e);
        }

    }

    @Override
    public Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarIniciativa(id);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarIniciativas();
        } catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }

    }

    @Override
    public List<Iniciativa> buscarIniciativas(List<String> palabrasClaves) throws ExcepcionBancoDeProyectos {
        try {
            List<Iniciativa> busqueda = new ArrayList<Iniciativa>();
            Set<Integer> ids = new HashSet<Integer>();
            for(String palabra : palabrasClaves){
                iniciativaDAO.cargarIniciativas(palabra).forEach(i -> {
                    if(!ids.contains(i.getId())){
                        ids.add(i.getId());
                        busqueda.add(i);
                    }
                });
            }
            return busqueda;
        }catch (PersistenceException e) {
            throw new ExcepcionBancoDeProyectos("Error de Busqueda de palabras clave:" + e.getLocalizedMessage(), e);
        }

    }


    @Override
    public List<Iniciativa> buscarIniciativas(Iniciativa i) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarIniciativas(i);
        }catch (PersistenceException e){
            throw new  ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Estadistico> buscarEstadisticasPorArea() throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarEstadisticasPorAreas();
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void registrarVoto(int id, String correo) throws ExcepcionBancoDeProyectos {
        try {
            iniciativaDAO.insertarVoto(id, correo);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Registro"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void cancelarVoto(int id, String correo) throws ExcepcionBancoDeProyectos {
        try {
            iniciativaDAO.borrarVoto(id, correo);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Eliminacion"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public int buscarNumeroDeVotos(int id) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cagarNumeroDeVotos(id);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public boolean consultarSiPuedeVotar(int id, String correo) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.consultarSiPuedeVotar(id, correo) == 0;
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> buscarIniciativasUsuario(String correo) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarIniciativasUsuario(correo);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Estadistico> buscarEstadisticasPorEstado() throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarEstadisticasPorEstado();
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Iniciativa> buscarIniciativas(EstadoIniciativa estado) throws ExcepcionBancoDeProyectos {
        try {
            return iniciativaDAO.cargarIniciativas(estado);
        } catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }

    }

    @Override
    public void registrarInteresado(int id, String correo) throws ExcepcionBancoDeProyectos {
        try {
            iniciativaDAO.insertarInteresado(id, correo);
        } catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Registro:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public void agregarComentario(Comentario c, int idIniciativa) throws ExcepcionBancoDeProyectos{
        try{
            comentarioDAO.insertarComentario(c, idIniciativa);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Registro:"+e.getLocalizedMessage(), e);
        }
    }

    @Override
    public List<Comentario> buscarComentarios(int idIniciativa) throws ExcepcionBancoDeProyectos {
        try{
            return comentarioDAO.cargarComentarios(idIniciativa);
        }catch (PersistenceException e){
            throw new ExcepcionBancoDeProyectos("Error de Busqueda:"+e.getLocalizedMessage(), e);
        }
    }
}
