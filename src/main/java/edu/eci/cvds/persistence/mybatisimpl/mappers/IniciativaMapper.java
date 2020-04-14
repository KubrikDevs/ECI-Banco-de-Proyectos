package edu.eci.cvds.persistence.mybatisimpl.mappers;

import edu.eci.cvds.entities.Iniciativa;
import org.apache.ibatis.annotations.Param;

public interface IniciativaMapper {

    public void insertarIniciativa(@Param("iniciativa") Iniciativa iniciativa);

    public Iniciativa consultarIniciativa(@Param("id") Integer id);

}
