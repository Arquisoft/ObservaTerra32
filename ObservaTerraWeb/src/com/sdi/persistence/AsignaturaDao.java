package com.sdi.persistence;

import impl.sdi.persistence.BaseDeDatos;

import java.util.List;

import com.sdi.model.Asignatura;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Asignatura.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface AsignaturaDao {

	public void setBD(BaseDeDatos bd);

	public List<Asignatura> buscarTodas();

	public List<Asignatura> buscarAsignaturasPorProfesor(int idUsuario);
	
	public List<Asignatura> buscarAsignaturas(Asignatura asignatura);

	public boolean modificarAsignatura(Asignatura asignatura);

	public boolean eliminarAsignatura(Asignatura asignatura);

	public boolean exitsProfesores(Asignatura asignatura);

	public boolean exitsAlumnos(Asignatura asignatura);

	public boolean nuevaAsignatura(Asignatura asignatura);
	
	public List<Asignatura> asignaturasImparte(int idAsignatura);
	

}
