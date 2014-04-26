package com.sdi.business;

import com.sdi.model.Usuario;

/**
 * Interfaz LoginService que ofrece cualquier implementación de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface LoginService {
	public Usuario comprobarLogin(String usuario, String password);
}
