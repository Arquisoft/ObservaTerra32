package com.sdi.business;

import java.util.List;

import com.sdi.business.exception.EntityAlreadyExistsException;
import com.sdi.business.exception.EntityNotFoundException;
import com.sdi.model.Alumno;

/**
 * Interfaz AlumnosService que ofrece cualquier implementación de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface AlumnosService {

	List<Alumno> getAlumnos() throws Exception;
	Alumno findById(Long id) throws EntityNotFoundException;
	void saveAlumno(Alumno alumno) throws EntityAlreadyExistsException;
	void updateAlumno(Alumno alumno) throws EntityNotFoundException;
	void deleteAlumno(Long id) throws EntityNotFoundException;

}