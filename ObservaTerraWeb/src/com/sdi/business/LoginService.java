package com.sdi.business;

import com.sdi.model.Usuario;

/**
 * Interfaz LoginService que ofrece cualquier implementaci�n de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface LoginService {
	public Usuario comprobarLogin(String usuario, String password);
}
