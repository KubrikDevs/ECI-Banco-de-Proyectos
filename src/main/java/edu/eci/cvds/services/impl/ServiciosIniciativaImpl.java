package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.persistence.PersistenceException;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;


import java.util.List;

public class ServiciosIniciativaImpl implements ServiciosIniciativa {
    @Inject
    IniciativaDAO iniciativaDAO;

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
}
