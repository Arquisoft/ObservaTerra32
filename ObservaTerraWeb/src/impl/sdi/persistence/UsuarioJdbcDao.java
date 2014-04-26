package impl.sdi.persistence;

import java.util.List;

import com.sdi.model.Asignatura;
import com.sdi.model.Usuario;
import com.sdi.persistence.UsuarioDao;

public class UsuarioJdbcDao implements UsuarioDao {

	private BaseDeDatos bd;

	@Override
	public void setBD(BaseDeDatos bd) {
		this.bd = bd;
	}

	@Override
	public List<Usuario> buscarProfesoresPorAsignatura(int idAsignatura) {
		return new UsuariosJdbc(bd).buscarProfesoresPorAsignatura(idAsignatura);
	}

	@Override
	public List<Usuario> buscarTodos() {
		return new UsuariosJdbc(bd).buscarTodos();
	}

	@Override
	public List<Usuario> buscarProfesores(String busqueda) {
		return new UsuariosJdbc(bd).buscarProfesores(busqueda);
	}

	@Override
	public boolean insertar(Usuario usuario) {
		return new UsuariosJdbc(bd).insertar(usuario);
	}

	@Override
	public Usuario buscarPorUsuario(String usuario) {
		return new UsuariosJdbc(bd).buscarPorUsuario(usuario);
	}

	@Override
	public Usuario comprobarLogin(String usuario, String password) {
		return new UsuariosJdbc(bd).comprobarLogin(usuario, password);
	}

	@Override
	public boolean modificarPerfil(Usuario usuario, String nuevaPassword,
			String nuevaPasswordConfirmar) {
		return new UsuariosJdbc(bd).modificarPerfil(usuario, nuevaPassword,
				nuevaPasswordConfirmar);
	}

	@Override
	public List<Usuario> buscarUsuariosActivos(String busqueda) {
		return new UsuariosJdbc(bd).buscarUsuariosActivos(busqueda);
	}

	@Override
	public List<Usuario> buscarUsuariosInactivos(String busqueda) {
		return new UsuariosJdbc(bd).buscarUsuariosInactivos(busqueda);
	}

	@Override
	public List<Usuario> listarUsuariosActivos() {
		return new UsuariosJdbc(bd).listarUsuariosActivos();
	}

	@Override
	public List<Usuario> listarUsuariosInactivos() {
		return new UsuariosJdbc(bd).listarUsuariosInActivos();
	}

	@Override
	public boolean activarUsuario(Usuario usuario) {
		return new UsuariosJdbc(bd).activarUsuario(usuario);
	}

	@Override
	public boolean desactivarUsuario(Usuario usuario) {
		return new UsuariosJdbc(bd).desactivarUsuario(usuario);
	}

	@Override
	public boolean confirmarAsignacionProfesorado(int idUsuario, int idAsignatura) {
		return new UsuariosJdbc(bd)
				.confirmarAsignacionProfesorado(idUsuario, idAsignatura);
	}
	
	@Override
	public boolean confirmarAsignacionAlumnado(int idUsuario, int idAsignatura) {
		return new UsuariosJdbc(bd)
				.confirmarAsignacionAlumnado(idUsuario, idAsignatura);
	}

	@Override
	public List<Asignatura> listarCalificarAlumnos(int idUsuario) {
		return new UsuariosJdbc(bd).listarCalificarAlumnos(idUsuario);
	}

	@Override
	public List<Usuario> alumnosMatriculados(int idAsignatura) {
		return new UsuariosJdbc(bd).alumnosMatriculados(idAsignatura);
	}

	@Override
	public void calificarAlumno(double nota, int idAsignatura, int idUsuario) {
		new UsuariosJdbc(bd).calificarAlumno(nota, idAsignatura, idUsuario);
	}

	@Override
	public List<Asignatura> consultarExpediente(int idUsuario) {
		return new UsuariosJdbc(bd).consultarExpediente(idUsuario);
	}

	@Override
	public List<Usuario> buscarAlumnosPorAsignatura(int idAsignatura) {
		return new UsuariosJdbc(bd).buscarAlumnosPorAsignatura(idAsignatura);
	}

	@Override
	public List<Usuario> buscaTodosAlumnos() {
		return new UsuariosJdbc(bd).buscarTodosAlumnos();
	}

}
