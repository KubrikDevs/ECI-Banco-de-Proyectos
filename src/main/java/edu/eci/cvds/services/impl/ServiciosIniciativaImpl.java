package edu.eci.cvds.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.entities.EstadoIniciativa;
import edu.eci.cvds.entities.Iniciativa;
import edu.eci.cvds.persistence.IniciativaDAO;
import edu.eci.cvds.services.ExcepcionBancoDeProyectos;
import edu.eci.cvds.services.ServiciosIniciativa;

import java.util.List;

public class ServiciosIniciativaImpl implements ServiciosIniciativa {
    @Inject
    IniciativaDAO iniciativaDAO;

    @Override
    public void crearIniciativa(Iniciativa i) throws ExcepcionBancoDeProyectos {

    }

    @Override
    public void modificarIniciativa(int id, EstadoIniciativa estado) throws ExcepcionBancoDeProyectos {

    }

    @Override
    public Iniciativa buscarIniciativa(int id) throws ExcepcionBancoDeProyectos {
        return null;
    }

    @Override
    public List<Iniciativa> buscarIniciativas() throws ExcepcionBancoDeProyectos {
        return null;
    }
}
