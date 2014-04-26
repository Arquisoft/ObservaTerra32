package com.sdi.business;

/**
 * Interfaz ServicesFactory que ofrece cualquier implementaci�n de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface ServicesFactory {
	
	AsignaturasService createAsignaturasService();

	LoginService createLoginService();

	UsuariosService createUsuariosService();

}
