package com.sdi.presentation;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

@ManagedBean(name = "asignaturas")
@SessionScoped
public class BeanAsignaturas implements Serializable {

	private static final long serialVersionUID = 1L;

	private Asignatura asignatura = new Asignatura();

	private Usuario usuario = new Usuario();

	private List<Asignatura> asignaturas = null;

	private String error = null;

	public String getError() {
		return error;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	/**
	 * lista las asignaturas con los profesores que las imparte.
	 */
	public String listadoConProfesores() {
		asignaturas = Factories.services.createAsignaturasService()
				.listarAsignaturasConProfesores();
		return "EXITO";
	}

	/**
	 * busca las asignaturas pas�ndole como par�metro en el m�todo interno la
	 * b�squeda que queremos realizar
	 */
	public String buscarAsignaturas() {
		asignaturas = Factories.services.createAsignaturasService()
				.buscarAsignaturas(asignatura);
		return "EXITO";
	}

	/**
	 * modifica la asignatura que queremos modificar pas�ndole c�mo par�metros
	 * en el m�todo interno la asignatura
	 */
	public String modificarAsignatura() {
		boolean resultado = Factories.services.createAsignaturasService()
				.modificarAsignatura(asignatura);
		if (resultado) {
			listadoConProfesores();
			return "EXITO";
		}
		return "FRACASO";
	}

	/**
	 * modifica la asignatura pas�ndole como par�metro la asignatura que
	 * queremos modificar
	 */
	public String mostrarModificarAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
		return "EXITO";
	}

	/**
	 * elimina una asignatura pas�ndole como par�metro la asignatura que
	 * queremos eliminar
	 */
	public String eliminarAsignatura(Asignatura asign) {
		boolean resultado = Factories.services.createAsignaturasService()
				.eliminarAsignatura(asign);
		asignaturas = Factories.services.createAsignaturasService()
				.listarAsignaturasConProfesores();
		if (resultado)
			return "EXITO";
		error = "error_eliminarAsignatura";
		return "FRACASO";
	}

	/**
	 * inserta una nueva asignatura
	 */
	public String nuevaAsignatura() {
		boolean resultado = Factories.services.createAsignaturasService()
				.nuevaAsignatura(asignatura);
		if (resultado) {
			listadoConProfesores();
			return "EXITO";
		}
		return "FRACASO";
	}

}
