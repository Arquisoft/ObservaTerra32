package com.sdi.persistence;

import java.util.List;

import com.sdi.model.Alumno;
import com.sdi.persistence.exception.AlreadyPersistedException;
import com.sdi.persistence.exception.NotPersistedException;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Alumno.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface AlumnoDao {

	List<Alumno> getAlumnos();

	void save(Alumno a) throws AlreadyPersistedException;

	void update(Alumno a) throws NotPersistedException;

	void delete(Long id) throws NotPersistedException;

	Alumno findById(Long id);

}