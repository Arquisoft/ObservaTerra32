package impl.sdi.business;

import impl.sdi.business.classes.CommandExecutor;
import impl.sdi.business.classes.administrador.ActivarUsuario;
import impl.sdi.business.classes.administrador.AsignarAlumnosAsignatura;
import impl.sdi.business.classes.administrador.AsignarProfesoresAsignatura;
import impl.sdi.business.classes.administrador.BuscarAlumnosPorAsignatura;
import impl.sdi.business.classes.administrador.BuscarProfesoresPorAsignatura;
import impl.sdi.business.classes.administrador.BuscarUsuariosActivos;
import impl.sdi.business.classes.administrador.BuscarUsuariosInactivos;
import impl.sdi.business.classes.administrador.ConfirmarAsignacionAlumnado;
import impl.sdi.business.classes.administrador.ConfirmarAsignacionProfesorado;
import impl.sdi.business.classes.administrador.DesactivarUsuario;
import impl.sdi.business.classes.administrador.ListarUsuariosActivos;
import impl.sdi.business.classes.administrador.ListarUsuariosInActivos;
import impl.sdi.business.classes.administrador.ModificarPerfilUsuario;
import impl.sdi.business.classes.alumno.ConsultarExpediente;
import impl.sdi.business.classes.profesor.CalificarAlumno;
import impl.sdi.business.classes.profesor.ListarCalificarAlumnos;
import impl.sdi.business.classes.publico.BuscarProfesores;
import impl.sdi.business.classes.publico.ListarProfesoresConAsignaturas;
import impl.sdi.business.classes.publico.RegistrarUsuario;

import java.util.List;

import com.sdi.business.UsuariosService;
import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;

/**
 * Clase SimpleUsuariosService de implementación del interfaz de la fachada de
 * servicios
 * 
 * @author Fernando Vigil-Escalera Caicoya
 * 
 */
public class SimpleUsuariosService implements UsuariosService {

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarProfesoresConAsignaturas() {
		return (List<Usuario>) CommandExecutor
				.execute(new ListarProfesoresConAsignaturas());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarProfesores(String busqueda) {
		return (List<Usuario>) CommandExecutor.execute(new BuscarProfesores(
				busqueda));
	}

	@Override
	public boolean registrarUsuario(Usuario usuario, String confirmarPassword) {
		return (boolean) CommandExecutor.execute(new RegistrarUsuario(usuario,
				confirmarPassword));
	}

	@Override
	public boolean modificarPerfilUsuario(Usuario usuario,
			String nuevaPassword, String nuevaPasswordConfirmar) {
		return (boolean) CommandExecutor.execute(new ModificarPerfilUsuario(
				usuario, nuevaPassword, nuevaPasswordConfirmar));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuariosActivos(String busqueda) {
		return (List<Usuario>) CommandExecutor
				.execute(new BuscarUsuariosActivos(busqueda));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarUsuariosInactivos(String busqueda) {
		return (List<Usuario>) CommandExecutor
				.execute(new BuscarUsuariosInactivos(busqueda));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarUsuariosActivos() {
		return (List<Usuario>) CommandExecutor
				.execute(new ListarUsuariosActivos());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listarUsuariosInactivos() {
		return (List<Usuario>) CommandExecutor
				.execute(new ListarUsuariosInActivos());
	}

	@Override
	public boolean activarUsuario(Usuario usuario) {
		return (boolean) CommandExecutor.execute(new ActivarUsuario(usuario));
	}

	@Override
	public boolean desactivarUsuario(Usuario usuario) {
		return (boolean) CommandExecutor
				.execute(new DesactivarUsuario(usuario));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> asignarProfesoresAsignatura() {
		return (List<Asignatura>) CommandExecutor
				.execute(new AsignarProfesoresAsignatura());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodos() {
		return (List<Usuario>) CommandExecutor
				.execute(new BuscarProfesoresPorAsignatura());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> asignarAlumnosAsignatura() {
		return (List<Asignatura>) CommandExecutor
				.execute(new AsignarAlumnosAsignatura());
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> buscarTodosAlumnos() {
		return (List<Usuario>) CommandExecutor
				.execute(new BuscarAlumnosPorAsignatura());
	}

	@Override
	public boolean confirmarAsignacionProfesorado(int idUsuario,
			int idAsignatura) {
		return (boolean) CommandExecutor
				.execute(new ConfirmarAsignacionProfesorado(idUsuario,
						idAsignatura));
	}

	@Override
	public boolean confirmarAsignacionAlumnado(int idUsuario, int idAsignatura) {
		return (boolean) CommandExecutor
				.execute(new ConfirmarAsignacionAlumnado(idUsuario,
						idAsignatura));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> listarCalificarAlumnos(int idUsuario) {
		return (List<Asignatura>) CommandExecutor
				.execute(new ListarCalificarAlumnos(idUsuario));
	}

	@Override
	public void confirmarCalificar(double nota, int idAsignatura, int idUsuario) {
		CommandExecutor.execute(new CalificarAlumno(nota, idAsignatura,
				idUsuario));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignatura> consultarExpediente(int idUsuario) {
		return (List<Asignatura>) CommandExecutor
				.execute(new ConsultarExpediente(idUsuario));
	}

}
