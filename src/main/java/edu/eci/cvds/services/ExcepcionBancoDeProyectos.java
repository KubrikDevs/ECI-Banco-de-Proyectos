package edu.eci.cvds.services;


public class ExcepcionBancoDeProyectos extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public final static String NO_DISPONIBLE = "Este recurso no esta disponible.";
	public final static String ERROR_INSERTAR = "Error al insertar.";
	public final static String ERROR_CONSULTAR = "Error al consultar.";
	public final static String USUARIO_YA_IDENTIFICADO = "Ya hay un usuario conectado.";

	public ExcepcionBancoDeProyectos(String mensaje) {
		super(mensaje);
	}
	public ExcepcionBancoDeProyectos(String mensaje, Throwable cause) {
		super(mensaje);
	}
	
	public ExcepcionBancoDeProyectos(String message, Exception e) {
		super(message,e);
	}
	
}

