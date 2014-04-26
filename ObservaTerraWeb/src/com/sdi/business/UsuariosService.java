package com.sdi.business;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Interfaz UsuariosService que ofrece cualquier implementación de la
 * clase fachada.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface UsuariosService {

	public List<Usuario> listarProfesoresConAsignaturas();

	public List<Usuario> buscarProfesores(String busqueda);

	public boolean registrarUsuario(Usuario usuario, String confirmarPassword);

	public boolean modificarPerfilUsuario(Usuario usuario,
			String nuevaPassword, String nuevaPasswordConfirmar);

	public List<Usuario> buscarUsuariosActivos(String busqueda);
	
	public List<Usuario> buscarUsuariosInactivos(String busqueda);

	public List<Usuario> listarUsuariosActivos();

	public List<Usuario> listarUsuariosInactivos();

	public boolean activarUsuario(Usuario usuario);

	public boolean desactivarUsuario(Usuario usuario);
	
	public List<Asignatura> asignarProfesoresAsignatura();
	
	public List<Usuario> buscarTodos();
	
	public List<Asignatura> asignarAlumnosAsignatura();
	
	public List<Usuario> buscarTodosAlumnos();

	public boolean confirmarAsignacionProfesorado(int idUsuario, int idAsignatura);
	
	public boolean confirmarAsignacionAlumnado(int idUsuario, int idAsignatura);

	public List<Asignatura> listarCalificarAlumnos(int idUsuario);

	public void confirmarCalificar(double nota, int idAsignatura, int idUsuario);

	public List<Asignatura> consultarExpediente(int idUsuario);

}
