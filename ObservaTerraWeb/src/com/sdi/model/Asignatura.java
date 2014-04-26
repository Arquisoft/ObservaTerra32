package com.sdi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Asignatura con sus atributos, getters y setters
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class Asignatura {

	public int idAsignatura;

	public String nombre;

	public int curso;

	public int numeroCreditos;

	public List<Usuario> profesores = new ArrayList<>();

	public List<Usuario> alumnos = new ArrayList<>();

	public double nota;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getIdAsignatura() {
		return idAsignatura;
	}

	public void setIdAsignatura(int idAsignatura) {
		this.idAsignatura = idAsignatura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCurso() {
		return curso;
	}

	public void setCurso(int curso) {
		this.curso = curso;
	}

	public int getNumeroCreditos() {
		return numeroCreditos;
	}

	public void setNumeroCreditos(int numeroCreditos) {
		this.numeroCreditos = numeroCreditos;
	}

	public List<Usuario> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<Usuario> profesores) {
		this.profesores = profesores;
	}

	public List<Usuario> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Usuario> alumnos) {
		this.alumnos = alumnos;
	}

	@Override
	public String toString() {
		return "Asignatura [nombre=" + nombre + ", curso=" + curso
				+ ", numeroCreditos=" + numeroCreditos + ", profesores="
				+ profesores + ", alumnos=" + alumnos + "]";
	}

}
