package edu.eci.cvds.authentication;

import edu.eci.cvds.services.ExcepcionBancoDeProyectos;

/**
 *
 * @author juaco
 */
public interface SessionLogger {
    public void login(String correo,String password,boolean hist) throws ExcepcionBancoDeProyectos;
    
    public boolean isLogged();
}