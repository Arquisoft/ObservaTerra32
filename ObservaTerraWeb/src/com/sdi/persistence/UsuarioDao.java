package com.sdi.persistence;

import impl.sdi.persistence.BaseDeDatos;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Interfaz de la fachada a servicios de persistencia para la entidad Usuario.
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public interface UsuarioDao {

	void setBD(BaseDeDatos bd);

	public List<Usuario> buscarTodos();

	public List<Usuario> buscarProfesoresPorAsignatura(int idAsignatura);

	public List<Usuario> buscarProfesores(String busqueda);

	public boolean insertar(Usuario usuario);

	public Usuario buscarPorUsuario(String usuario);

	public Usuario comprobarLogin(String usuario, String password);

	public boolean modificarPerfil(Usuario usuario, String nuevaPassword,
			String nuevaPasswordConfirmar);

	public List<Usuario> buscarUsuariosActivos(String busqueda);
	
	public List<Usuario> buscarUsuariosInactivos(String busqueda);

	public List<Usuario> listarUsuariosActivos();

	public List<Usuario> listarUsuariosInactivos();

	public boolean activarUsuario(Usuario usuario);

	public boolean desactivarUsuario(Usuario usuario);
	
	public List<Asignatura> listarCalificarAlumnos(int idUsuario);

	public List<Usuario> alumnosMatriculados(int idAsignatura);

	public List<Asignatura> consultarExpediente(int idUsuario);

	public void calificarAlumno(double nota, int idAsignatura, int idUsuario);

	public boolean confirmarAsignacionProfesorado(int idUsuario, int idAsignatura);
	
	public boolean confirmarAsignacionAlumnado(int idUsuario, int idAsignatura);

	public List<Usuario> buscarAlumnosPorAsignatura(int idAsignatura);

	public List<Usuario> buscaTodosAlumnos();

}
