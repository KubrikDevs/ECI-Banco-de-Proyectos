package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

public interface IniciativaMapper {

    public void insertarIniciativa(@Param("iniciativa") Iniciativa iniciativa);

    public ArrayList<Iniciativa> buscarIniciativas();

    public void updateIniciativa(@Param("id") int id);

    public ArrayList<String> consultarPalabrasClaves();

}
