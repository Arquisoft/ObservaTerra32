package com.sdi.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase Usuario con sus atributos, getters y setters
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class Usuario {
	
	public int idUsuario;

	public String nombre;

	public String apellidos;

	public String email;

	public String usuario;

	public String password;
	
	public String passwordConfirmacion;

	public String tipo;
	
	public Double nota;

	public List<Asignatura> asignaturas = new ArrayList<>();
	
	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPasswordConfirmacion() {
		return passwordConfirmacion;
	}

	public void setPasswordConfirmacion(String passwordConfirmacion) {
		this.passwordConfirmacion = passwordConfirmacion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public String getNotaStr() {
		if (this.nota == null) {
			return "No evaluado";
		}
		else if (this.nota >= 0) {
			return String.format("%3.1f", nota);
		}
		else {
			return "No presentado" ;
		}
	}


	
	

}
