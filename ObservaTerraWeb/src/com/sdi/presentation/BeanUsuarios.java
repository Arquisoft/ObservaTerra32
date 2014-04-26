package com.sdi.presentation;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.sdi.infrastructure.Factories;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

@ManagedBean(name = "usuarios")
@SessionScoped
public class BeanUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();

	private Asignatura asignatura = new Asignatura();

	private List<Usuario> usuarios = null;

	private List<Asignatura> asignaturas = null;

	public List<Usuario> usuariosActivos = null;

	public List<Usuario> usuariosInactivos = null;

	private String nuevaPassword;

	private String confirmarPassword;

	private String busqueda;

	private String error = null;

	private Double nota;

	public void setNota(Double nota) {
		this.nota = nota;
	}

	public Double getNota() {
		return nota;
	}

	public String getError() {
		return error;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuariosActivos() {
		return usuariosActivos;
	}

	public void setUsuariosActivos(List<Usuario> usuariosActivos) {
		this.usuariosActivos = usuariosActivos;
	}

	public List<Usuario> getUsuariosInactivos() {
		return usuariosInactivos;
	}

	public void setUsuariosInactivos(List<Usuario> usuariosInactivos) {
		this.usuariosInactivos = usuariosInactivos;
	}

	public String getNuevaPassword() {
		return nuevaPassword;
	}

	public void setNuevaPassword(String nuevaPassword) {
		this.nuevaPassword = nuevaPassword;
	}

	public String getConfirmarPassword() {
		return confirmarPassword;
	}

	public void setConfirmarPassword(String confirmarPassword) {
		this.confirmarPassword = confirmarPassword;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	/**
	 * registra un nuevo usuario pasándole como parámetros en el método interno
	 * el usuario y la password a confirmar
	 */
	public String registrarUsuarioNuevo() {
		boolean resultado = Factories.services.createUsuariosService()
				.registrarUsuario(usuario, confirmarPassword);
		if (resultado)
			return "EXITO";
		return "FRACASO";
	}

	/**
	 * modifica el perfil del usuario que queremos modificar pasándole cómo
	 * parámetros en el método interno el usuario, la nueva password y la
	 * password a confirmar
	 */
	public String modificarPerfilUsuario() {
		boolean resultado = Factories.services.createUsuariosService()
				.modificarPerfilUsuario(usuario, nuevaPassword,
						confirmarPassword);
		if (resultado)
			return "EXITO";

		error = "error_modificacion_usuario";
		return "FRACASO";
	}

	/**
	 * lista los profesores con las asignaturas que imparte
	 */
	public String listadoConAsignaturas() {
		usuarios = Factories.services.createUsuariosService()
				.listarProfesoresConAsignaturas();
		return "EXITO";
	}

	/**
	 * busca los profesores pasándole como parámetro en el método interno la
	 * búsqueda que queremos realizar
	 */
	public String buscarProfesores() {
		usuarios = Factories.services.createUsuariosService().buscarProfesores(
				busqueda);
		return "EXITO";
	}

	/**
	 * busca los usuarios activados pasándole como parámetro en el método
	 * interno la búsqueda que queremos realizar
	 */
	public String buscarUsuariosActivos() {
		usuariosActivos = Factories.services.createUsuariosService()
				.buscarUsuariosActivos(busqueda);
		return "EXITO";
	}

	/**
	 * busca los usuarios desactivados pasándole como parámetro en el método
	 * interno la búsqueda que queremos realizar.
	 */
	public String buscarUsuariosInactivos() {
		usuariosInactivos = Factories.services.createUsuariosService()
				.buscarUsuariosInactivos(busqueda);
		return "EXITO";
	}

	/**
	 * lista los usuarios que están activados
	 */
	public String listarUsuariosActivos() {
		usuariosActivos = Factories.services.createUsuariosService()
				.listarUsuariosActivos();
		return "EXITO";
	}

	/**
	 * lista los usuarios que están desactivados
	 */
	public String listarUsuariosInactivos() {
		usuariosInactivos = Factories.services.createUsuariosService()
				.listarUsuariosInactivos();
		return "EXITO";
	}

	/**
	 * activa los usuarios pasándole como parámetro el usuario que queremos
	 * activar
	 */
	public void activarUsuarios(Usuario usuario) {
		Factories.services.createUsuariosService().activarUsuario(usuario);
		usuariosInactivos = Factories.services.createUsuariosService()
				.listarUsuariosInactivos();
	}

	/**
	 * desactiva los usuarios pasándole como parámetro el usuario que queremos
	 * desactivar
	 */
	public void desactivarUsuarios(Usuario usuario) {
		Factories.services.createUsuariosService().desactivarUsuario(usuario);
		usuariosActivos = Factories.services.createUsuariosService()
				.listarUsuariosActivos();
	}

	/**
	 * modifica el perfil del usuario recogiendo el usuario que está en sesión
	 */
	public String modificarPerfil() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		this.usuario = (Usuario) session.get("LOGGEDIN_USER");
		return "EXITO";
	}

	/**
	 * modifica el perfil del usuario pasándole como parámetro el usuario que
	 * queremos modificar
	 */
	public String formularioModificarPerfilUsuarioActivacionUsuarioActivado(
			Usuario usuarioActivado) {
		usuario = usuarioActivado;
		return "EXITO";
	}

	/**
	 * modifica el perfil del usuario que está desactivado pasándole como
	 * parámetro el usuario que queremos modificar
	 */
	public String formularioModificarPerfilUsuarioActivacionUsuarioDesactivado(
			Usuario usuarioDesactivado) {
		usuario = usuarioDesactivado;
		return "EXITO";
	}

	/**
	 * lista las asignaturas con los profesores que imparte cada asignatura
	 */
	public String listarAsignarProfesoresAsignatura() {
		asignaturas = Factories.services.createUsuariosService()
				.asignarProfesoresAsignatura();
		return "EXITO";
	}

	/**
	 * lista los profesores que imparten la asignatura que le paso como
	 * parámetro
	 */
	public String buscarProfesoresPorAsignatura(Asignatura asignatura) {
		usuarios = Factories.services.createUsuariosService().buscarTodos();
		this.asignatura = asignatura;
		return "EXITO";
	}

	/**
	 * lista las asignaturas con los alumnos que están matriculados en cada
	 * asignatura
	 */
	public String listarAsignarAlumnosAsignatura() {
		asignaturas = Factories.services.createUsuariosService()
				.asignarAlumnosAsignatura();
		return "EXITO";
	}

	/**
	 * lista los alumnos que están matriculados en la asignatura que le paso
	 * como parámetro
	 */
	public String buscarAlumnosPorAsignatura(Asignatura asignatura) {
		usuarios = Factories.services.createUsuariosService()
				.buscarTodosAlumnos();
		this.asignatura = asignatura;
		return "EXITO";
	}

	/**
	 * lista las asignaturas que imparte el profesor de la sesión con los
	 * alumnos que están matriculados en ellas para poder calificarlos pasándole
	 * como parámetro en el método interno el usuario de la sesión en la que
	 * está
	 */
	public String listarCalificarAlumnos() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Usuario usuario = (Usuario) session.get("LOGGEDIN_USER");
		asignaturas = Factories.services.createUsuariosService()
				.listarCalificarAlumnos(usuario.getIdUsuario());
		return "EXITO";
	}

	/**
	 * muestra la información del alumno que queremos calificar pasándole como
	 * parámetro el usuario y la asignatura para calificar ese alumno de esa
	 * asignatura
	 */
	public String formularioCalificarAlumno(Usuario alumno,
			Asignatura asignatura) {
		usuario = alumno;
		this.asignatura = asignatura;
		return "EXITO";
	}

	/**
	 * inserta la nueva calificación pasándole como parámetro en el método
	 * interno el id de la asignatura y el id del usuario que estamos
	 * calificando
	 */
	public String confirmarCalificar() {
		Factories.services.createUsuariosService().confirmarCalificar(nota,
				asignatura.getIdAsignatura(), usuario.getIdUsuario());
		listarCalificarAlumnos();
		return "EXITO";
	}

	/**
	 * inserta el nuevo profesor en la asignatura seleccionada pasándole como
	 * parámetro el usuario
	 */
	public String confirmarAsignacionProfesorado(Usuario usuario) {
		boolean resultado = Factories.services.createUsuariosService()
				.confirmarAsignacionProfesorado(usuario.getIdUsuario(),
						asignatura.getIdAsignatura());
		if (resultado) {
			listarAsignarProfesoresAsignatura();
			return "EXITO";
		}
		return "FRACASO";
	}

	/**
	 * inserta el nuevo alumno en la asignatura seleccionada pasándole como
	 * parámetro el usuario
	 */
	public String confirmarAsignacionAlumnado(Usuario usuario) {
		boolean resultado = Factories.services.createUsuariosService()
				.confirmarAsignacionAlumnado(usuario.getIdUsuario(),
						asignatura.getIdAsignatura());
		if (resultado) {
			listarAsignarAlumnosAsignatura();
			return "EXITO";
		}
		return "FRACASO";
	}

	/**
	 * muestra toda la información de las asignaturas de las que está
	 * matriculado y las calificaciones correspondientes
	 */
	public String consultarExpediente() {
		Map<String, Object> session = FacesContext.getCurrentInstance()
				.getExternalContext().getSessionMap();
		Usuario usuario = (Usuario) session.get("LOGGEDIN_USER");

		asignaturas = Factories.services.createUsuariosService()
				.consultarExpediente(usuario.getIdUsuario());
		return "EXITO";
	}

}
