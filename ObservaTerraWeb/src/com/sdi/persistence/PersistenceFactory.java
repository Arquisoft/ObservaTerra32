package com.sdi.persistence;

/**
 * Interfaz de la factoria que suministra implementaciones reales de la fachada
 * de persistencia para cada Entidad del Modelo
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface PersistenceFactory {

	AsignaturaDao createAsignaturaDao();

	UsuarioDao createUsuarioDao();
}
