package com.sdi.business;

import java.util.List;

import com.sdi.model.Asignatura;

/**
 * Interfaz AsignaturasService que ofrece cualquier implementación de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface AsignaturasService {

	public List<Asignatura> listarAsignaturasConProfesores();

	public List<Asignatura> buscarAsignaturas(Asignatura asignatura);

	public boolean modificarAsignatura(Asignatura asignatura);

	public boolean eliminarAsignatura(Asignatura asignatura);

	public boolean nuevaAsignatura(Asignatura asignatura);

}
